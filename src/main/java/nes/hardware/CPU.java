package nes.hardware;

import lombok.Data;
import nes.exceptions.InvalidMemoryRangeException;
import nes.exceptions.InvalidOpcodeFound;

@Data
public class CPU {

  private static CPU cpu;

  private CPU() {

  }

  private void setIrq(boolean value){
    throw new UnsupportedOperationException();
  }

  private void powerUp() throws InvalidMemoryRangeException {
    pc = 0x34;
    a = x = y = 0;
    sp = (byte) 0xFD;
    writeToRam(0x4017, (byte) 0x00);
    writeToRam(0x4015, (byte) 0x00);
    for (int i = 0x4000; i <= 0x4013; i++)
      writeToRam(i, (byte) 0x00);
    //Todo: All 15 bits of noise channel LFSR = $0000
  }

  private void reset() {
    sp = (byte) (sp - 3);
    setIrq(false);
    //Todo: APU mode in $4017 was unchanged
    // APU was silenced ($4015 = 0)
    // APU triangle phase is reset to 0 (i.e. outputs a value of 15, the first step of its waveform)
    // APU DPCM output ANDed with 1 (upper 6 bits cleared)
    // 2A03G: APU Frame Counter reset. (but 2A03letterless: APU frame counter retains old value) [6]

  }

  public static CPU getInstance() throws InvalidMemoryRangeException {
    if (cpu == null) {
      cpu = new CPU();
    }
    return cpu;
  }

  byte[] addressSpace = new byte[4 * 1024];
  // program counter, stack pointer and status registers
  short pc;
  byte sp;
  // accumator and index registers
  byte a, x, y;

  byte status_register;

  private enum Flag{

    C((byte)(1<<0)),
    Z((byte)(1<<1)),
    I((byte)(1<<2)),
    D((byte)(1<<3)),
    B((byte)(1<<4)),
    U((byte)(1<<5)),
    V((byte)(1<<6)),
    N((byte)(1<<7));

    public final byte value;

    private Flag(byte value){
      this.value = value;
    }

  }


  private void setFlag(Flag flag, int value) {
    if(value == 1){
      status_register |= flag.value;
    }
    else status_register &= ~flag.value;
  }

  public byte getFlag(Flag flag) {
   return (byte) ((status_register & flag.value) > 0 ? 1:0);
  }

  public void push(byte data) {
    throw new UnsupportedOperationException("Push to stack not supported yet");
  }

  public byte pop() {
    throw new UnsupportedOperationException("Pop from stack not supported yet");
  }

  public byte readFromRam(int address) throws InvalidMemoryRangeException {
    // range of Ram
    if (address >= 0x0000 && address <= 0x1FFF) {
      return readFromRam(address & 0x0800);
    } else if (address >= 0x2000 && address <= 0x3FFF) {
      //Todo: Nes PPU Registers
      //  address & 0x2007
    } else if (address >= 0x4000 && address <= 0x4017) {
      //Todo: NES APU and IO Registers
      throw new UnsupportedOperationException();
    } else if (address >= 0x4018 && address <= 0x401F) {
      //Todo: APU and I/O functionality that is normally disabled
      throw new UnsupportedOperationException();
    } else if (address >= 0x4020 && address <= 0xFFFF) {
      //Todo: Cartridge Space
      // Mappers Here
      throw new UnsupportedOperationException();
    }

    throw new InvalidMemoryRangeException();
  }

  public void writeToRam(int address, byte data) throws InvalidMemoryRangeException {
    // range of Ram
    if (address >= 0x0000 && address <= 0x1FFF) {
      writeToRam(address & 0x0800, data);
    }
    throw new InvalidMemoryRangeException();
  }

  private short absolute() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte lowerByte = readFromRam(pc);
    pc = (short) (pc + 1);
    byte upperByte = readFromRam(pc);

    return (short) (lowerByte * 0x100 + upperByte);
  }

  private byte accumulator() {
    return a;
  }

  private byte immediate() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    return readFromRam(pc);
  }

  private void implied() {
  }

  private byte indexedAbsoluteX() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte lowerByte = readFromRam(pc);
    pc = (short) (pc + 1);
    byte upperByte = readFromRam(pc);
    short finalAddress = (short) ((upperByte << 8) | lowerByte);
    return readFromRam(finalAddress + x);
  }

  private byte indexedAbsoluteY() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte lowerByte = readFromRam(pc);
    pc = (short) (pc + 1);
    byte upperByte = readFromRam(pc);
    byte finalAddress = (byte) ((upperByte << 8) | lowerByte);
    return readFromRam(finalAddress + y);
  }

  private byte indexedIndirect() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte nextByte = readFromRam(pc);
    //Todo: Check this
    pc = (short) ((nextByte + x) & 0xFF);
    byte lowerByte = readFromRam(pc);
    pc = (short) (pc + 1);
    byte upperByte = readFromRam(pc);
    return readFromRam((byte) ((upperByte << 8) | lowerByte));
  }

  private byte indirectIndexed() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte nextByte = readFromRam(pc);
    byte targetAddressLowerByte = addressSpace[nextByte];
    byte targetAddressUpperByte = addressSpace[nextByte + 0x01];
    targetAddressLowerByte = (byte) (targetAddressLowerByte + y);
    return readFromRam((targetAddressUpperByte << 8) | targetAddressLowerByte);
  }

  private byte indexedZeroPageX() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte nextByte = readFromRam(pc);
    if (nextByte >= 0x0000 && nextByte <= 0x00ff) {
      pc = (short) (pc + 1);
      byte finalAddress = (byte) ((nextByte + x) & 0x00ff);
      return readFromRam(finalAddress);
    }
    throw new InvalidMemoryRangeException();
  }

  private byte indexedZeroPageY() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte nextByte = readFromRam(pc);
    if (nextByte >= 0x0000 && nextByte <= 0x00ff) {
      pc = (short) (pc + 1);
      byte finalAddress = (byte) ((nextByte + y) & 0x00ff);
      return readFromRam(finalAddress);
    }
    throw new InvalidMemoryRangeException();
  }


  private short indirect() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte lowerByte = readFromRam(pc);
    pc = (short) (pc + 1);
    byte upperByte = readFromRam(pc);
    return (byte) ((upperByte << 8) | lowerByte);
  }


  private byte relative() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte address = readFromRam(pc);
    address = (byte) (address + pc);
    pc = (short) (pc + 1);
    return readFromRam(address);
  }

  private byte zeroPage() throws InvalidMemoryRangeException {
    pc = (short) (pc + 1);
    byte nextByte = readFromRam(pc);
    if (nextByte >= 0x0 && nextByte <= 0xf) {
      pc = (short) (pc + 1);
      return readFromRam(nextByte);
    }
    throw new InvalidMemoryRangeException();
  }

  //Instructions
  private void adc() {
    short sum = (short) (a + fetchedValue + getFlag(Flag.C));
    if (sum > 255) setFlag(Flag.C, 1);
    else setFlag(Flag.C, 0);
    setFlag(Flag.Z, (sum & 0x00FF));
    setFlag(Flag.V, (((~(short) a + sum) & ((short) a ^ sum)) & 0x0080));
    setFlag(Flag.N, (a >> 7 & 0x01));
    a = (byte) (sum & 0x00FF);
    pc = (short) (pc + 1);
  }

  private void and() {
    a = (byte) (a & fetchedValue);
    if (a == 0) setFlag(Flag.Z, 0);
    else setFlag(Flag.Z, 1);
    setFlag(Flag.N, (a >> 7 & 0x01));
    pc = (short) (pc + 1);
  }

  private void asl() {
    //Todo: Fix this instruction
    setFlag(Flag.C, (a >> 7 & 0x01));
    a = (byte) (a << 1);
    pc = (short) (pc + 1);
  }

  private void bcc() {
    if (getFlag(Flag.C) == 0) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void bcs() {
    if (getFlag(Flag.C) == 1) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void beq() {
    if (getFlag(Flag.Z) == 1) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void bit() {
    setFlag(Flag.Z, (a & fetchedValue));
    setFlag(Flag.V, (fetchedValue & 0x40));
    setFlag(Flag.N, (fetchedValue & 0x80));
    pc = (short) (pc + 1);
  }

  private void bmi() {
    if (getFlag(Flag.N) == 1) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void bne() {
    if (getFlag(Flag.Z) == 0) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void bpl() {
    if (getFlag(Flag.N) == 0) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void brk() {
    throw new UnsupportedOperationException();
  }

  private void bvc() {
    if (getFlag(Flag.V) == 0) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void bvs() {
    if (getFlag(Flag.V) == 1) {
      pc = (short) (pc + fetchedValue);
    } else pc = (short) (pc + 1);
  }

  private void clc() {
    setFlag(Flag.C, 0);
    pc = (short) (pc + 1);
  }

  private void cld() {
    setFlag(Flag.D, 0);
    pc = (short) (pc + 1);
  }

  private void cli() {
    setFlag(Flag.I, 0);
    pc = (short) (pc + 1);
  }

  private void clv() {
    setFlag(Flag.V, 0);
    pc = (short) (pc + 1);
  }

  private void cmp() {
    if (a >= fetchedValue) setFlag(Flag.C, 1);
    //Todo: Verify if this else condition is required or not
    //else setFlag(Flag.C, 0);
    if (a == fetchedValue) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    //else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (a - fetchedValue) & 0x80);
    pc = (short) (pc + 1);
  }

  private void cpx() {
    if (x >= fetchedValue) setFlag(Flag.C, 1);
    //Todo: Verify if this else condition is required or not
    //else setFlag(Flag.C, 0);
    if (x == fetchedValue) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    //else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (x - fetchedValue) & 0x80);
    pc = (short) (pc + 1);
  }

  private void cpy() {
    if (y >= fetchedValue) setFlag(Flag.C, 1);
    //Todo: Verify if this else condition is required or not
    //else setFlag(Flag.C, 0);
    if (y == fetchedValue) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    //else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (y - fetchedValue) & 0x80);
    pc = (short) (pc + 1);
  }

  private void dec() {
    //Todo: Validate the working of this function
    // do we need to update the value in the stored location
    // or just subtracting is fine
    if (fetchedValue - 1 == 0) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (fetchedValue - 1) & 0x80);
    pc = (short) (pc + 1);
  }

  private void dex() {
    //Todo: Validate the working of this function
    // do we need to update the value in the stored location
    // or just subtracting is fine
    if (x - 1 == 0) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (x - 1) & 0x80);
    pc = (short) (pc + 1);
  }

  private void dey() {
    //Todo: Validate the working of this function
    // do we need to update the value in the stored location
    // or just subtracting is fine
    if (y - 1 == 0) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (y - 1) & 0x80);
    pc = (short) (pc + 1);
  }

  private void eor() {
    a = (byte) (a ^ fetchedValue);
    if (a == 0) setFlag(Flag.Z, 0);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 1);
    setFlag(Flag.N, a & 0x80);
    pc = (short) (pc + 1);
  }

  private void inc() {
    //Todo: Validate the working of this function
    // do we need to update the value in the stored location
    // or just adding is fine
    if (fetchedValue + 1 == 0) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (fetchedValue + 1) & 0x80);
    pc = (short) (pc + 1);
  }

  private void inx() {
    //Todo: Validate the working of this function
    // do we need to update the value in the stored location
    // or just adding is fine
    if (x + 1 == 0) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (x + 1) & 0x80);
    pc = (short) (pc + 1);
  }

  private void iny() {
    //Todo: Validate the working of this function
    // do we need to update the value in the stored location
    // or just adding is fine
    if (y + 1 == 0) setFlag(Flag.Z, 1);
    //Todo: Verify if this else condition is required or not
    // else setFlag(Flag.Z, 0);
    setFlag(Flag.N, (y + 1) & 0x80);
    pc = (short) (pc + 1);
  }

  private void jmp() {
    //NB:
    //An original 6502 has does not correctly fetch the target address
    // if the indirect vector falls on a page boundary
    // (e.g. $xxFF where xx is any value from $00 to $FF).
    // In this case fetches the LSB from $xxFF as expected but takes the MSB
    // from $xx00. This is fixed in some later chips like the 65SC02 so for
    // compatibility always ensure the indirect vector is not at the end of
    // the page.
    pc = fetchedValue;
  }

  private void jsr() {
    throw new UnsupportedOperationException();
  }


  private void lda() {
    a = (byte) fetchedValue;
    pc = (short) (pc + 1);
  }

  private void ldx() {
    x = (byte) fetchedValue;
    pc = (short) (pc + 1);
  }

  private void ldy() {
    y = (byte) fetchedValue;
    pc = (short) (pc + 1);
  }

  private void lsr() {
    throw new UnsupportedOperationException();
  }

  private void nop() {
    pc = (short) (pc + 1);
  }

  private void ora() {
    a = (byte) (a | fetchedValue);
    if (a == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, a >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void pha() {
    push(a);
    pc = (short) (pc + 1);
  }

  private void php() {
    //push status flag to stack
    throw new UnsupportedOperationException();
  }

  private void pla() {
    a = pop();
    if (a == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, a >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void plp() {
    //Todo: pull 8 bit value from stack to processor flags
    throw new UnsupportedOperationException();
  }

  private void ror() {
    //Todo: needs to understand what moving bits of memory mean
    throw new UnsupportedOperationException();
  }

  private void rti() {
    //Todo: The RTI instruction is used at the end of an interrupt processing
    // routine.It pulls the processor flags from the stack followed by the
    // program counter.
    throw new UnsupportedOperationException();
  }

  private void rts() {
    //Todo: The RTS instruction is used at the end of a subroutine to return
    // to the calling routine. It pulls the program counter (minus one) from
    // the stack.
    throw new UnsupportedOperationException();
  }

  private void sbc() {
    //Todo : A,Z,C,N = A-M-(1-C)
    // This instruction subtracts the contents of a memory location to the
    // accumulator together with the not of the carry bit. If overflow occurs
    // the carry bit is clear, this enables multiple byte subtraction to be
    // performed.
    throw new UnsupportedOperationException();
  }

  private void sec() {
    setFlag(Flag.C, 1);
    pc = (short) (pc + 1);
  }

  private void sed() {
    setFlag(Flag.D, 1);
    pc = (short) (pc + 1);
  }

  private void sei() {
    setFlag(Flag.I, 1);
    pc = (short) (pc + 1);
  }

  private void sta() throws InvalidMemoryRangeException {
    writeToRam(pc, a);
    pc = (short) (pc + 1);
  }

  private void stx() throws InvalidMemoryRangeException {
    writeToRam(pc, x);
    pc = (short) (pc + 1);
  }

  private void sty() throws InvalidMemoryRangeException {
    writeToRam(pc, y);
    pc = (short) (pc + 1);
  }

  private void tax() {
    x = a;
    if (x == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, x >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void tay() {
    y = a;
    if (y == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, y >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void tsx() {
    x = sp;
    if (x == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, x >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void txa() {
    a = x;
    if (a == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, a >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void txs() {
    sp = x;
    if (sp == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, sp >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private void tya() {
    a = y;
    if (a == 0) setFlag(Flag.Z, 1);
    setFlag(Flag.N, a >> 7 & 0x01);
    pc = (short) (pc + 1);
  }

  private short fetchedValue;

  void decode() throws InvalidOpcodeFound, InvalidMemoryRangeException {
    byte hexValue = readFromRam(pc);
    InstructionInfo instructionInfo = OpcodeDecoder.decode(hexValue);
    switch (instructionInfo.getAddressingMode()) {
      case Absolute:
        fetchedValue = absolute();
        break;
      case Accumulator:
        fetchedValue = accumulator();
        break;
      case Implied:
        implied();
        break;
      case Immediate:
        fetchedValue = immediate();
        break;
      case IndexedAbsoluteX:
        fetchedValue = indexedAbsoluteX();
        break;
      case IndexedAbsoluteY:
        fetchedValue = indexedAbsoluteY();
        break;
      case IndexedIndirect:
        fetchedValue = indexedIndirect();
        break;
      case IndexedZeroPageX:
        fetchedValue = indexedZeroPageX();
        break;
      case IndexedZeroPageY:
        fetchedValue = indexedZeroPageY();
        break;
      case Indirect:
        fetchedValue = indirect();
        break;
      case IndirectIndexed:
        fetchedValue = indirectIndexed();
        break;
      case Relative:
        fetchedValue = relative();
        break;
      case ZeroPage:
        fetchedValue = zeroPage();
        break;
    }

    switch (instructionInfo.getHexCode()) {

      case "ADC":
        adc();
        break;
      case "AND":
        and();
        break;
      case "ASL":
        asl();
        break;
      case "BCC":
        bcc();
        break;
      case "BCS":
        bcs();
        break;
      case "BEQ":
        beq();
        break;
      case "BIT":
        bit();
        break;
      case "BMI":
        bmi();
        break;
      case "BNE":
        bne();
        break;
      case "BPL":
        bpl();
        break;
      case "BRK":
        brk();
        break;
      case "BVC":
        bvc();
        break;
      case "BVS":
        bvs();
        break;
      case "CLC":
        clc();
        break;
      case "CLD":
        cld();
        break;
      case "CLI":
        cli();
        break;
      case "CLV":
        clv();
        break;
      case "CMP":
        cmp();
        break;
      case "CPX":
        cpx();
        break;
      case "CPY":
        cpy();
        break;
      case "DEC":
        dec();
        break;
      case "DEX":
        dex();
        break;
      case "DEY":
        dey();
        break;
      case "EOR":
        eor();
        break;
      case "INC":
        inc();
        break;
      case "INX":
        inx();
        break;
      case "INY":
        iny();
        break;
      case "JMP":
        jmp();
        break;
      case "JSR":
        jsr();
        break;
      case "LDA":
        lda();
        break;
      case "LDX":
        ldx();
        break;
      case "LDY":
        ldy();
        break;
      case "LSR":
        lsr();
        break;
      case "NOP":
        nop();
        break;
      case "ORA":
        ora();
        break;
      case "PHA":
        pha();
        break;
      case "PHP":
        php();
        break;
      case "PLA":
        pla();
        break;
      case "PLP":
        plp();
        break;
      case "ROR":
        ror();
        break;
      case "RTI":
        rti();
        break;
      case "RTS":
        rts();
        break;
      case "SBC":
        sbc();
        break;
      case "SEC":
        sec();
        break;
      case "SED":
        sed();
        break;
      case "SEI":
        sei();
        break;
      case "STA":
        sta();
        break;
      case "STX":
        stx();
        break;
      case "STY":
        sty();
        break;
      case "TAX":
        tax();
        break;
      case "TAY":
        tay();
        break;
      case "TSX":
        tsx();
        break;
      case "TXA":
        txa();
        break;
      case "TXS":
        txs();
        break;
      case "TYA":
        tya();
        break;

    }

  }

}
