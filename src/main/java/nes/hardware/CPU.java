package nes.hardware;

import lombok.Data;
import nes.exceptions.InvalidMemoryRangeException;

import java.util.EnumSet;

@Data
public class CPU {

  byte[] addressSpace = new byte[4 * 1024];
  // program counter, stack pointer and status registers
  byte pc, sp;
  // accumator and index registers
  byte a, x, y;

  private enum Registers {
    N, // Negative,
    V, // Overflow
    U, // unused
    B, // break
    D, // DecimalMode
    I, // InterruptDisable
    Z, // Zero,
    C, // Carry
  }

  EnumSet<Registers> registers = EnumSet.allOf(Registers.class);

  public void push(byte data) {
    throw new UnsupportedOperationException("Push to stack not supported yet");
  }

  public byte pop() {
    throw new UnsupportedOperationException("Pop from stack not supported yet");
  }

  public byte readFromRam(int address) throws InvalidMemoryRangeException {
    // range of Ram
    if (address >= 0x0000 && address <= 0x1FFF) {
      return addressSpace[address & 0x0800];
    }
    throw new InvalidMemoryRangeException();
  }

  public void writeToRam(int address, byte data) throws InvalidMemoryRangeException {
    // range of Ram
    if (address >= 0x0000 && address <= 0x1FFF) {
      addressSpace[address & 0x0800] = data;
    }
    throw new InvalidMemoryRangeException();
  }

  private byte absolute() {
    byte lowerByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    byte upperByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    short finalAddress = (short) (lowerByte * 0x100 + upperByte);
    return addressSpace[finalAddress];
  }

  private byte accumulator() {
    return a;
  }

  private byte immediate() {
    byte value = addressSpace[pc + 1];
    pc = (byte) (pc + 1);
    return value;
  }

  private void implied() {
    return;
  }

  private byte indexedAbsoluteX() {
    byte lowerByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    byte upperByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    short finalAddress = (short) (lowerByte * 0x100 + upperByte);
    return addressSpace[finalAddress + x];
  }

  private byte indexedAbsoluteY() {
    byte lowerByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    byte upperByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    short finalAddress = (short) (lowerByte * 0x100 + upperByte);
    return addressSpace[finalAddress + y];
  }

  private short indexedIndirectX() {

    byte nextByte = (byte) (pc + 1);
    byte targetAddress = (byte) ((nextByte + x) & 0xFF);
    return addressSpace[targetAddress];
  }

  private short indexedIndirectY() {
    byte nextByte = (byte) (pc + 1);
    byte targetAddressLowerByte = addressSpace[nextByte];
    byte targetAddressUpperByte = addressSpace[nextByte + 0x01];
    targetAddressLowerByte = (byte) (targetAddressLowerByte + y);
    return (short) ((targetAddressUpperByte << 8) | targetAddressLowerByte);
  }

  private byte indexedZeroPageX() throws InvalidMemoryRangeException {
    byte nextByte = (byte) (pc + 0x0001);
    if (nextByte >= 0x0000 && nextByte <= 0x00ff) {
      pc = (byte) (pc + 1);
      byte finalAddress = (byte) ((nextByte + x) & 0x00ff);
      return addressSpace[finalAddress];
    }
    throw new InvalidMemoryRangeException();
  }

  private byte indexedZeroPageY() throws InvalidMemoryRangeException {
    byte nextByte = (byte) (pc + 0x0001);
    if (nextByte >= 0x0000 && nextByte <= 0x00ff) {
      pc = (byte) (pc + 1);
      byte finalAddress = (byte) ((nextByte + y) & 0x00ff);
      return addressSpace[finalAddress];
    }
    throw new InvalidMemoryRangeException();
  }


  private short indirect() {
    byte lowerByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    byte upperByte = (byte) (pc + 1);
    pc = (byte) (pc + 1);
    return (short) (lowerByte * 0x100 + upperByte);
  }


  private byte relative() {
    byte address = addressSpace[pc + 1];
    address = (byte) (address + pc);
    pc++;
    return addressSpace[address];
  }

  private byte zeroPage() throws InvalidMemoryRangeException {
    byte nextByte = (byte) (pc + 0x0001);
    if (nextByte >= 0x0 && nextByte <= 0xf) {
      pc = (byte) (pc + 1);
      return addressSpace[nextByte];
    }
    throw new InvalidMemoryRangeException();
  }

}
