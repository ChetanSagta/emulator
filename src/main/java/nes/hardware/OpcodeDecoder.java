package nes.hardware;

import nes.exceptions.InvalidOpcodeFound;

public class OpcodeDecoder {

  public static InstructionInfo decode(byte hexCode) throws InvalidOpcodeFound {

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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectY);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectY);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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
        tempInstuctionInfo.setInstructionLength(4);
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
        tempInstuctionInfo.setAddressingMode(AddressingMode.IndexedIndirectX);
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


      default:
        throw new InvalidOpcodeFound();
    }
    return tempInstuctionInfo;
  }
}
