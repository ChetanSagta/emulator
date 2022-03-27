package nes.hardware;

public enum AddressingMode{
  Immediate,
  ZeroPage,
  IndexedZeroPageX,
  IndexedZeroPageY,
  Absolute,
  IndexedAbsoluteX,
  IndexedAbsoluteY,
  Indirect,
  Implied,
  Accumulator,
  Relative,
  IndexedIndirectX, //PreIndex
  IndexedIndirectY, //PostIndex
}
