package nes.hardware;

import lombok.Data;

@Data
public class InstructionInfo{

  private String hexCode;
  private AddressingMode addressingMode;
  private int instructionLength;
  private int minCycle;


}
