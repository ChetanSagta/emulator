package nes.hardware;

import nes.exceptions.InvalidOpcodeFound;

public class OpcodeDecoder {

  public static InstructionInfo decode(short hexCode) throws InvalidOpcodeFound {

    InstructionInfo tempInstuctionInfo = new InstructionInfo();
    switch (hexCode) {
      case 0x00:
        tempInstuctionInfo.setHexCode("BRK");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x01:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x02:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x03:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x04:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x05:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x06:
        tempInstuctionInfo.setHexCode("ASL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x07:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x08:
        tempInstuctionInfo.setHexCode("PHP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x09:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x0A:
        tempInstuctionInfo.setHexCode("ASL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Accumulator);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x0B:
        // Todo : Unsupported Text
        tempInstuctionInfo.setHexCode("ANC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x0C:
        // Todo : Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x0D:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x0E:
        tempInstuctionInfo.setHexCode("ASL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x0F:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x10:
        tempInstuctionInfo.setHexCode("BPL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2 , 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x11:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 5 or 6
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x12:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x13:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x14:
        // Todo : Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x15:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x16:
        tempInstuctionInfo.setHexCode("ASL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x17:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x18:
        tempInstuctionInfo.setHexCode("CLC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x19:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        // can be 4 or 5
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x1A:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x1B:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x1C:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x1D:
        tempInstuctionInfo.setHexCode("ORA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x1E:
        tempInstuctionInfo.setHexCode("ASL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x1F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SLO");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x20:
        tempInstuctionInfo.setHexCode("JSR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x21:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x22:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x23:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x24:
        tempInstuctionInfo.setHexCode("BIT");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x25:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x26:
        tempInstuctionInfo.setHexCode("ROL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x27:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x28:
        tempInstuctionInfo.setHexCode("PLP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x29:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x2A:
        tempInstuctionInfo.setHexCode("ROL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Accumulator);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x2B:
        // Todo : Unsupported Text
        tempInstuctionInfo.setHexCode("ANC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x2C:
        tempInstuctionInfo.setHexCode("BIT");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x2D:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x2E:
        tempInstuctionInfo.setHexCode("ROL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x2F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x30:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("BMI");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2,3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x31:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 5 or 6
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x32:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x33:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x34:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x35:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x36:
        tempInstuctionInfo.setHexCode("ROL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x37:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x38:
        tempInstuctionInfo.setHexCode("SEC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x39:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x3A:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x3B:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x3C:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x3D:
        tempInstuctionInfo.setHexCode("AND");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x3E:
        tempInstuctionInfo.setHexCode("ROL");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x3F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x40:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RTI");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x41:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x42:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x43:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x44:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x45:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x46:
        tempInstuctionInfo.setHexCode("LSR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x47:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x48:
        tempInstuctionInfo.setHexCode("PHA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x49:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x4A:
        tempInstuctionInfo.setHexCode("LSR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Accumulator);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x4B:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("ALR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x4C:
        tempInstuctionInfo.setHexCode("JMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x4D:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x4E:
        tempInstuctionInfo.setHexCode("LSR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x4F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x50:
        tempInstuctionInfo.setHexCode("BVC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x51:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x52:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x53:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x54:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x55:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x56:
        tempInstuctionInfo.setHexCode("LSR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x57:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x58:
        tempInstuctionInfo.setHexCode("CLI");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x59:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x5A:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x5B:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x5C:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x5D:
        tempInstuctionInfo.setHexCode("EOR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x5E:
        tempInstuctionInfo.setHexCode("LSR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x5F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SRE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x60:
        tempInstuctionInfo.setHexCode("RTS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x61:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x62:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x63:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RRA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x64:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
      case 0x65:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x66:
        tempInstuctionInfo.setHexCode("ROR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x67:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RRA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x68:
        tempInstuctionInfo.setHexCode("PLA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x69:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x6A:
        tempInstuctionInfo.setHexCode("ROR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x6B:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("ARR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x6C:
        tempInstuctionInfo.setHexCode("JMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Indirect);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x6D:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x6E:
        tempInstuctionInfo.setHexCode("ROR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x6F:
        tempInstuctionInfo.setHexCode("RRA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x70:
        tempInstuctionInfo.setHexCode("BVS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x71:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x72:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x73:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RRA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0x74:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x75:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x76:
        tempInstuctionInfo.setHexCode("ROR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x77:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RRA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x78:
        tempInstuctionInfo.setHexCode("SEI");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x79:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x7A:
      case 0x7D:
        tempInstuctionInfo.setHexCode("ADC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x7E:
        tempInstuctionInfo.setHexCode("ROR");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x7F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("RRA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0x80:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x81:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x82:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x83:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("SAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x84:
        tempInstuctionInfo.setHexCode("STY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x85:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x86:
        tempInstuctionInfo.setHexCode("STX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0x87:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("SAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x88:
        tempInstuctionInfo.setHexCode("DEY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x89:
        // Todo : Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x8A:
        tempInstuctionInfo.setHexCode("TXA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x8B:
        // Todo : Unsupported Text
        tempInstuctionInfo.setHexCode("XAA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x8C:
        tempInstuctionInfo.setHexCode("STY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x8D:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x8E:
        tempInstuctionInfo.setHexCode("STX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x8F:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("SAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x90:
        tempInstuctionInfo.setHexCode("BCC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x91:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x92:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x93:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("AHX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0x94:
        tempInstuctionInfo.setHexCode("STY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x95:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x96:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0x97:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("SAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0x98:
        tempInstuctionInfo.setHexCode("TYA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x99:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x9A:
        tempInstuctionInfo.setHexCode("TXS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
      case 0x9B:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("TAS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x9C:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SHY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x9D:
        tempInstuctionInfo.setHexCode("STA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0x9E:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("SHY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0x9F:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("AHX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0xA0:
        tempInstuctionInfo.setHexCode("LDY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xA1:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xA2:
        tempInstuctionInfo.setHexCode("LDX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xA3:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xA4:
        tempInstuctionInfo.setHexCode("LDY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xA5:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xA6:
        tempInstuctionInfo.setHexCode("LDX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xA7:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xA8:
        tempInstuctionInfo.setHexCode("TAY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xA9:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xAA:
        tempInstuctionInfo.setHexCode("TAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xAB:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xAC:
        tempInstuctionInfo.setHexCode("LDY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xAD:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xAE:
        tempInstuctionInfo.setHexCode("LDX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xAF:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xB0:
        tempInstuctionInfo.setHexCode("BCS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xB1:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xB2:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0xB3:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xB4:
        tempInstuctionInfo.setHexCode("LDY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xB5:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xB6:
        tempInstuctionInfo.setHexCode("LDX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xB7:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xB8:
        tempInstuctionInfo.setHexCode("CLV");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xB9:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xBA:
        tempInstuctionInfo.setHexCode("TSX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xBB:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xBC:
        tempInstuctionInfo.setHexCode("LDY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xBD:
        tempInstuctionInfo.setHexCode("LDA");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xBE:
        tempInstuctionInfo.setHexCode("LDX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xBF:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("LAX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xC0:
        tempInstuctionInfo.setHexCode("CPY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xC1:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xC2:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xC3:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xC4:
        tempInstuctionInfo.setHexCode("CPY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xC5:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xC6:
        tempInstuctionInfo.setHexCode("DEC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xC7:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xC8:
        tempInstuctionInfo.setHexCode("INY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xC9:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xCA:
        tempInstuctionInfo.setHexCode("DEX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xCB:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("AXS");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xCC:
        tempInstuctionInfo.setHexCode("CPY");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xCD:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
      case 0xCE:
        tempInstuctionInfo.setHexCode("DEC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xCF:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xD0:
        tempInstuctionInfo.setHexCode("BNE");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xD1:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
      case 0xD2:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0xD3:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xD4:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xD5:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xD6:
        tempInstuctionInfo.setHexCode("DEC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xD7:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xD8:
        tempInstuctionInfo.setHexCode("BRK");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xD9:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xDA:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xDB:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0xDC:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xDD:
        tempInstuctionInfo.setHexCode("CMP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xDE:
        tempInstuctionInfo.setHexCode("DEC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0xDF:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("DCP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0xE0:
        tempInstuctionInfo.setHexCode("CPX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xE1:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirect);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xE2:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xE3:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xE4:
        tempInstuctionInfo.setHexCode("CPX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(3);
        break;
      case 0xE5:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xE6:
        tempInstuctionInfo.setHexCode("INC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xE7:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xE8:
        tempInstuctionInfo.setHexCode("INX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xE9:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xEA:
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xEB:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Immediate);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xEC:
        tempInstuctionInfo.setHexCode("CPX");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xED:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xEE:
        tempInstuctionInfo.setHexCode("INC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xEF:
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Absolute);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xF0:
        tempInstuctionInfo.setHexCode("BEQ");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Relative);
        tempInstuctionInfo.setInstructionLength(2);
        // can be 2, 3 or 4
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xF1:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndirectIndexed);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(5);
        break;
      case 0xF2:
        // Unsupported Text
        tempInstuctionInfo.setHexCode("STP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(1);
        break;
      case 0xF3:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xF4:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.ZeroPage);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xF5:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xF6:
        tempInstuctionInfo.setHexCode("INC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(6);
        break;
      case 0xF7:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xF8:
        tempInstuctionInfo.setHexCode("SED");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xF9:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xFA:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.Implied);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xFB:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteY);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      case 0xFC:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("NOP");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(1);
        tempInstuctionInfo.setMinCycle(2);
        break;
      case 0xFD:
        tempInstuctionInfo.setHexCode("SBC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(4);
        break;
      case 0xFE:
        tempInstuctionInfo.setHexCode("INC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedAbsoluteX);
        tempInstuctionInfo.setInstructionLength(3);
        tempInstuctionInfo.setMinCycle(7);
        break;
      case 0xFF:
        // Todo: Unsupported Text
        tempInstuctionInfo.setHexCode("ISC");
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedZeroPageX);
        tempInstuctionInfo.setInstructionLength(2);
        tempInstuctionInfo.setMinCycle(8);
        break;
      default:
        throw new InvalidOpcodeFound();
    }
    return tempInstuctionInfo;
  }
}
