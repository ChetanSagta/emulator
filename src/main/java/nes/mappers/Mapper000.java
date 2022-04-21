package nes.mappers;

import java.util.ArrayList;

//https://www.nesdev.org/wiki/NROM
public class Mapper000 implements Mapper{
  //16K or 32K
  ArrayList<Byte> prgRom = new ArrayList<>();
  //2K or 4K in Family Basic only
  ArrayList<Byte> prgRam = new ArrayList<>();
  ArrayList<Byte> chrRom = new ArrayList<>();
  int chrCapacity = 8*1024;

}
