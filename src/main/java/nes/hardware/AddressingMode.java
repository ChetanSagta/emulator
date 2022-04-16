package nes.hardware;

public enum AddressingMode{
  Absolute,
  Accumulator,
  Immediate,
  Implied,
  IndexedAbsoluteX,
  IndexedAbsoluteY,
  IndexedIndirect, //PreIndex
  IndirectIndexed, //PostIndex
  IndexedZeroPageX,
  IndexedZeroPageY,
  Indirect,
  Relative,
  ZeroPage,
}
