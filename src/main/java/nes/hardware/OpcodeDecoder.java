package nes.hardware;

import nes.exceptions.InvalidOpcodeFound;

public class OpcodeDecoder {

  private OpcodeDecoder(){}

  public static InstructionInfo decode(short hexCode) throws InvalidOpcodeFound {

    InstructionInfo tempInstructionInfo = new InstructionInfo();
    switch (hexCode) {
      case 0x00:
        tempInstructionInfo.setHexCode("BRK");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x01:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x02:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x03:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x04:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x05:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x06:
        tempInstructionInfo.setHexCode("ASL");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x07:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x08:
        tempInstructionInfo.setHexCode("PHP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x09:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x0A:
        tempInstructionInfo.setHexCode("ASL");
        tempInstructionInfo.setAddressingMode(AddressingMode.Accumulator);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x0B:
        // Todo : Unsupported Text
        tempInstructionInfo.setHexCode("ANC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x0C:
        // Todo : Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x0D:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x0E:
        tempInstructionInfo.setHexCode("ASL");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x0F:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x10:
        tempInstructionInfo.setHexCode("BPL");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2 , 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x11:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        // can be 5 or 6
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x12:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x13:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x14:
        // Todo : Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x15:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x16:
        tempInstructionInfo.setHexCode("ASL");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x17:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x18:
        tempInstructionInfo.setHexCode("CLC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x19:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        // can be 4 or 5
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x1A:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x1B:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x1C:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x1D:
        tempInstructionInfo.setHexCode("ORA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x1E:
        tempInstructionInfo.setHexCode("ASL");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x1F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SLO");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x20:
        tempInstructionInfo.setHexCode("JSR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x21:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x22:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x23:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x24:
        tempInstructionInfo.setHexCode("BIT");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x25:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x26:
        tempInstructionInfo.setHexCode("ROL");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x27:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x28:
        tempInstructionInfo.setHexCode("PLP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x29:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x2A:
        tempInstructionInfo.setHexCode("ROL");
        tempInstructionInfo.setAddressingMode(AddressingMode.Accumulator);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x2B:
        // Todo : Unsupported Text
        tempInstructionInfo.setHexCode("ANC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x2C:
        tempInstructionInfo.setHexCode("BIT");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x2D:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x2E:
        tempInstructionInfo.setHexCode("ROL");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x2F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x30:
        // Unsupported Text
        tempInstructionInfo.setHexCode("BMI");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2,3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x31:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        // can be 5 or 6
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x32:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x33:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x34:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x35:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x36:
        tempInstructionInfo.setHexCode("ROL");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x37:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x38:
        tempInstructionInfo.setHexCode("SEC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x39:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x3A:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x3B:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x3C:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x3D:
        tempInstructionInfo.setHexCode("AND");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x3E:
        tempInstructionInfo.setHexCode("ROL");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x3F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x40:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RTI");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x41:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x42:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x43:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x44:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x45:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x46:
        tempInstructionInfo.setHexCode("LSR");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x47:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x48:
        tempInstructionInfo.setHexCode("PHA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x49:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x4A:
        tempInstructionInfo.setHexCode("LSR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Accumulator);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x4B:
        // Unsupported Text
        tempInstructionInfo.setHexCode("ALR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x4C:
        tempInstructionInfo.setHexCode("JMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x4D:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x4E:
        tempInstructionInfo.setHexCode("LSR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x4F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x50:
        tempInstructionInfo.setHexCode("BVC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x51:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x52:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x53:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x54:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x55:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x56:
        tempInstructionInfo.setHexCode("LSR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x57:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x58:
        tempInstructionInfo.setHexCode("CLI");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x59:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x5A:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x5B:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x5C:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x5D:
        tempInstructionInfo.setHexCode("EOR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x5E:
        tempInstructionInfo.setHexCode("LSR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x5F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SRE");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x60:
        tempInstructionInfo.setHexCode("RTS");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x61:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x62:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x63:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RRA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x64:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
      case 0x65:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x66:
        tempInstructionInfo.setHexCode("ROR");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x67:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RRA");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x68:
        tempInstructionInfo.setHexCode("PLA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x69:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x6A:
        tempInstructionInfo.setHexCode("ROR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x6B:
        // Unsupported Text
        tempInstructionInfo.setHexCode("ARR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x6C:
        tempInstructionInfo.setHexCode("JMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Indirect);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x6D:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x6E:
        tempInstructionInfo.setHexCode("ROR");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x6F:
        tempInstructionInfo.setHexCode("RRA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x70:
        tempInstructionInfo.setHexCode("BVS");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x71:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x72:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x73:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RRA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0x74:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x75:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x76:
        tempInstructionInfo.setHexCode("ROR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x77:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RRA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x78:
        tempInstructionInfo.setHexCode("SEI");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x79:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x7A:
      case 0x7D:
        tempInstructionInfo.setHexCode("ADC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x7E:
        tempInstructionInfo.setHexCode("ROR");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x7F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("RRA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0x80:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x81:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x82:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x83:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("SAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x84:
        tempInstructionInfo.setHexCode("STY");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x85:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x86:
        tempInstructionInfo.setHexCode("STX");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0x87:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("SAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x88:
        tempInstructionInfo.setHexCode("DEY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x89:
        // Todo : Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x8A:
        tempInstructionInfo.setHexCode("TXA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x8B:
        // Todo : Unsupported Text
        tempInstructionInfo.setHexCode("XAA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x8C:
        tempInstructionInfo.setHexCode("STY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x8D:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x8E:
        tempInstructionInfo.setHexCode("STX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x8F:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("SAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x90:
        tempInstructionInfo.setHexCode("BCC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x91:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x92:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x93:
        // Unsupported Text
        tempInstructionInfo.setHexCode("AHX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0x94:
        tempInstructionInfo.setHexCode("STY");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x95:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x96:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0x97:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("SAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0x98:
        tempInstructionInfo.setHexCode("TYA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x99:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x9A:
        tempInstructionInfo.setHexCode("TXS");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
      case 0x9B:
        // Unsupported Text
        tempInstructionInfo.setHexCode("TAS");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x9C:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SHY");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x9D:
        tempInstructionInfo.setHexCode("STA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0x9E:
        // Unsupported Text
        tempInstructionInfo.setHexCode("SHY");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0x9F:
        // Unsupported Text
        tempInstructionInfo.setHexCode("AHX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0xA0:
        tempInstructionInfo.setHexCode("LDY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xA1:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xA2:
        tempInstructionInfo.setHexCode("LDX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xA3:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xA4:
        tempInstructionInfo.setHexCode("LDY");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xA5:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xA6:
        tempInstructionInfo.setHexCode("LDX");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xA7:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xA8:
        tempInstructionInfo.setHexCode("TAY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xA9:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xAA:
        tempInstructionInfo.setHexCode("TAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xAB:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xAC:
        tempInstructionInfo.setHexCode("LDY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xAD:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xAE:
        tempInstructionInfo.setHexCode("LDX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xAF:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xB0:
        tempInstructionInfo.setHexCode("BCS");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xB1:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xB2:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0xB3:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xB4:
        tempInstructionInfo.setHexCode("LDY");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xB5:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xB6:
        tempInstructionInfo.setHexCode("LDX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xB7:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xB8:
        tempInstructionInfo.setHexCode("CLV");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xB9:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xBA:
        tempInstructionInfo.setHexCode("TSX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xBB:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAS");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xBC:
        tempInstructionInfo.setHexCode("LDY");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xBD:
        tempInstructionInfo.setHexCode("LDA");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xBE:
        tempInstructionInfo.setHexCode("LDX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xBF:
        // Unsupported Text
        tempInstructionInfo.setHexCode("LAX");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xC0:
        tempInstructionInfo.setHexCode("CPY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xC1:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xC2:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xC3:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xC4:
        tempInstructionInfo.setHexCode("CPY");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xC5:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xC6:
        tempInstructionInfo.setHexCode("DEC");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xC7:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xC8:
        tempInstructionInfo.setHexCode("INY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xC9:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xCA:
        tempInstructionInfo.setHexCode("DEX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xCB:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("AXS");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xCC:
        tempInstructionInfo.setHexCode("CPY");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xCD:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
      case 0xCE:
        tempInstructionInfo.setHexCode("DEC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xCF:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xD0:
        tempInstructionInfo.setHexCode("BNE");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xD1:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
      case 0xD2:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0xD3:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xD4:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xD5:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xD6:
        tempInstructionInfo.setHexCode("DEC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xD7:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xD8:
        tempInstructionInfo.setHexCode("BRK");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xD9:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xDA:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xDB:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0xDC:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xDD:
        tempInstructionInfo.setHexCode("CMP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xDE:
        tempInstructionInfo.setHexCode("DEC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0xDF:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("DCP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0xE0:
        tempInstructionInfo.setHexCode("CPX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xE1:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xE2:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xE3:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xE4:
        tempInstructionInfo.setHexCode("CPX");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(3);
        break;
      case 0xE5:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xE6:
        tempInstructionInfo.setHexCode("INC");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xE7:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xE8:
        tempInstructionInfo.setHexCode("INX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xE9:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xEA:
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xEB:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xEC:
        tempInstructionInfo.setHexCode("CPX");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xED:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xEE:
        tempInstructionInfo.setHexCode("INC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xEF:
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xF0:
        tempInstructionInfo.setHexCode("BEQ");
        tempInstructionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstructionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xF1:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(5);
        break;
      case 0xF2:
        // Unsupported Text
        tempInstructionInfo.setHexCode("STP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(1);
        break;
      case 0xF3:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xF4:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xF5:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xF6:
        tempInstructionInfo.setHexCode("INC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(6);
        break;
      case 0xF7:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xF8:
        tempInstructionInfo.setHexCode("SED");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xF9:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xFA:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xFB:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      case 0xFC:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("NOP");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(1);
        tempInstructionInfo.setMinCycle(2);
        break;
      case 0xFD:
        tempInstructionInfo.setHexCode("SBC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(4);
        break;
      case 0xFE:
        tempInstructionInfo.setHexCode("INC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstructionInfo.setInstructionLength(3);
        tempInstructionInfo.setMinCycle(7);
        break;
      case 0xFF:
        // Todo: Unsupported Text
        tempInstructionInfo.setHexCode("ISC");
        tempInstructionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstructionInfo.setInstructionLength(2);
        tempInstructionInfo.setMinCycle(8);
        break;
      default:
        throw new InvalidOpcodeFound();
    }
    return tempInstructionInfo;
  }
}
