package nes.mappers;

import nes.hardware.Cartridge;

import java.util.ArrayList;

public abstract class Mapper{
  ArrayList<Byte> prgRom;
  ArrayList<Byte> chrRom;

  abstract public void writeToPrg(short address, byte data);

  abstract public Byte readFromPrg(short address);

  abstract public void writeToChr(short address, byte data);

  abstract public Byte readFromChr(short address);

  Mapper(ArrayList<Byte> prgRom, ArrayList<Byte> chrRom){
    this.prgRom = prgRom;
    this.chrRom = chrRom;
  }

  //Todo: Nametable Mirrorring

  //Todo: Generating interrupts, especially ones timed to occur when the PPU reaches a certain scanlines


}
