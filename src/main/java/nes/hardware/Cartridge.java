package nes.hardware;

import lombok.Data;
import nes.mappers.Mapper;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cartridge {

  byte[] trainer = new byte[512];
  byte[] fileContents;
  byte[] prgRom;
  byte[] chrRom;
  byte[] playChoice;
  Mapper mapper;

  @Data
  private static class CatridgeHeader implements Serializable {

    private byte n = 0x4E;
    private byte e = 0x45;
    private byte s = 0x53;
    private byte eol = 0x1A;
    private byte prgRomSize;
    private byte chrRomSize;
    private byte flag6;
    private byte flag7;
    private byte flag8;
    private byte flag9;
    private byte flag10;
    private byte[] padding = new byte[5];

    void bytesToHeader(final byte[] values) {
      n = values[0];
      e = values[1];
      s = values[2];
      eol = values[3];
      prgRomSize = values[4];
      chrRomSize = values[5];
      flag6 = values[6];
      flag7 = values[7];
      // rest values should be set to 0 according to
      // https://gamefaqs.gamespot.com/nes/916386-nes/faqs/2947
      flag8 = values[8];
      flag9 = values[9];
      flag10 = values[10];
      System.arraycopy(values, 11, padding, 0, 5);
    }

    // 0: horizontal (vertical arrangement) (CIRAM A10 = PPU A11)
    // 1: vertical (horizontal arrangement) (CIRAM A10 =PPU A10)
    private byte getMirroring() {
      return (byte) ((flag6 >> 0) & 1);
    }

    // 0:No
    // 1: Cartridge contains battery-backed PRG RAM ($6000-7FFF) or other persistent
    // memory
    private byte getBattery() {
      return (byte) ((flag6 >> 1) & 1);
    }

    private byte getTrainer() {
      return (byte) ((flag6 >> 2) & 1);
    }

    // 0: No
    // 1: Ignore mirroring control or above mirroring bit; instead provide
    // four-screen VRAM
    private byte ignoreMirroringBit() {
      return (byte) ((flag6 >> 3) & 1);
    }

    private byte lowerMapperNybble() {
      return (byte) (flag6 & 11110000);
    }

    // VS UnisystemVS Unisystem
    private byte vsUnisystem() {
      return (byte) ((flag7 >> 1) & 1);
    }

    // PlayChoice-10 (8KB of Hint Screen data stored after CHR data)
    private byte playChoice() {
      return (byte) ((flag7 >> 2) & 1);
    }

    // If equal to 2, flags 8-15 are in NES 2.0 format
    // Todo: Check this
    private byte nes2() {
      return (byte) ((flag7 >> 2) & 0b00000011);
    }

    // Upper nybble of mapper number
    private byte upperNybble() {
      return (byte) ((flag7 >> 4 )& 0b00001111);
    }

    private byte getPrgRamSize() { return flag8; }

    private byte tvSystemflag9(){ return (byte)((flag9 >> 1) & 1);}

    //76543210
    //  ||  ||
    //  ||  ++- TV system (0: NTSC; 2: PAL; 1/3: dual compatible)
    //  |+----- PRG RAM ($6000-$7FFF) (0: present; 1: not present)
    //  +------ 0: Board has no bus conflicts; 1: Board has bus conflicts

    // TV system (0: NTSC; 1: PAL)
    private String tvSystemflag10() {
      switch (flag10 >> 2 & 0b11){
        case 0b00:
          return "NTSC";
        case 0b10:
          return "PAL";
        default:
          return "DUAL Compatible";
      }
    }

    private byte prgRamPresent(){ return (byte)(flag10 >> 4 & 0b1);}

    //flags 10 This byte is not part of the official specification, and relatively few emulators honor it.

  }

  private void setTrainer() {
    System.arraycopy(fileContents, 16, trainer, 1, 512);
  }

  public Cartridge(final URI fileName) {

    final Path path = Paths.get(fileName);
    try {
      fileContents = Files.readAllBytes(path);
      final CatridgeHeader header = new CatridgeHeader();
      final byte[] headerBytes = new byte[16];
      for (int i = 0; i < 16; i++) {
        headerBytes[i] = fileContents[i];
      }
      header.bytesToHeader(headerBytes);

      System.out.println(header);
      if (header.getTrainer() == 0x01) setTrainer();
      prgRom = new byte[16384 * header.getPrgRomSize()];
      chrRom = new byte[8192 * header.getChrRomSize()];
      if (header.playChoice() == 0x01) playChoice = new byte[8192];


    } catch (final IOException io) {
      io.printStackTrace();
    }

  }
}
