package nes.mappers;

import nes.hardware.Cartridge;

import java.util.ArrayList;

//https://www.nesdev.org/wiki/NROM
public class Mapper000 extends Mapper{

  Cartridge cartridge;

  @Override
  public void writeToPrg(short address, byte data) {

  }

  @Override
  public Byte readFromPrg(short address) {
    return null;
  }

  @Override
  public void writeToChr(short address, byte data) {

  }

  @Override
  public Byte readFromChr(short address) {
    return null;
  }

  Mapper000(ArrayList<Byte> prgRom, ArrayList<Byte> chrRom){
    super(prgRom, chrRom);
    this.prgRom = prgRom;
    this.chrRom = chrRom;
  }

}
