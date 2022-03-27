package nes.hardware;

import java.util.EnumSet;

import lombok.Data;

@Data
public class CPU {

  /*
   * $0000-$00FF first page in memory $0000-$07FF are mirrored three times at
   * $0800-$1FFF. This means that, for example, any data written to $0000 will
   * also be written to $0800, $1000 and $1800. The memory mapped I/O registers
   * are located at $2000-$401F. Locations $2000-$2007 are mirrored every 8 bytes
   * in the region $2008-$3FFF and the remaining registers follow this mirroring
   * From $8000 onwards is the addresses allocated to cartridge PRG-ROM. Games
   * with only one 16 KB bank of PRG-ROM will load it into both $8000 and $C000.
   * This is to ensure that the vector table is located in the correct addresses.
   * Games with two 16 KB PRG-ROM banks will load one into $8000 and the other
   * into $C000.
   */
  /*
    Zero Page - $0000-$00FF 
   
   */
  byte[] ram = new byte[4*1024];
  short addressBus;
  // program counter, stack pointer and status registers
  short PC;
  byte SP;
  // accumator and index registers
  byte A, X, Y;

  private enum Registers{
    N, //Negative,
    V, //Overflow 
    U, //unused
    B, //break
    D, // DecimalMode
    I, // InterruptDisable
    Z, // Zero,
    C, //Carry
  }

  EnumSet<Registers> registers = EnumSet.allOf(Registers.class);

  public void push(byte data){throw new UnsupportedOperationException("Push to stack not supported yet");}
  public byte pop(){ throw new UnsupportedOperationException("Pop from stack not supported yet");}


  //Interrupts  
  //Addressing Modes
  //Instructions
  //


}
