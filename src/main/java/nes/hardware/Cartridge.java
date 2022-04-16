package nes.hardware;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import lombok.Data;

public class Cartridge {

  boolean trainerPresent;
  boolean chrRomPresent;
  boolean instRomPresent;
  boolean promPresent;

  ArrayList<Byte> prgRom = new ArrayList<>();
  ArrayList<Byte> chrRom = new ArrayList<>();
  Mapper mapper;

  @Data
  private class CatridgeHeader implements Serializable {
    byte n = 0x4E;
    byte e = 0x45;
    byte s = 0x53;
    byte eol = 0x1A;
    byte prgRomSize;
    byte chrRomSize;
    byte flag6;
    byte flag7;
    byte flag8;
    byte flag9;
    byte flag10;
    byte[] padding = new byte[5];

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
      for (int i = 11; i < 16; i++)
        padding[i-11] = values[1];
    }

    // 0: horizontal (vertical arrangement) (CIRAM A10 = PPU A11)
    // 1: vertical (horizontal arrangement) (CIRAM A10 =PPU A10)
    public byte getMirroring() {
      return (byte) ((flag6 >> 0) & 1);
    }

    // 0:No
    // 1: Cartridge contains battery-backed PRG RAM ($6000-7FFF) or other persistent
    // memory
    public byte getBattery() {
      return (byte) ((flag6 >> 1) & 1);
    }

    public byte getTrainer() {
      return (byte) ((flag6 >> 2) & 1);
    }

    // 0: No
    // 1: Ignore mirroring control or above mirroring bit; instead provide
    // four-screen VRAM
    public byte ignoreMirroringBit() {
      return (byte) ((flag6 >> 3) & 1);
    }

    public byte lowerMapperNybble() {
      return (byte) (flag6 & 11110000);
    }

    // VS UnisystemVS Unisystem
    public byte vsUnisystem() {
      return (byte) ((flag7 >> 1) & 1);
    }

    // PlayChoice-10 (8KB of Hint Screen data stored after CHR data)
    public byte playChoice() {
      return (byte) ((flag7 >> 2) & 1);
    }

    // If equal to 2, flags 8-15 are in NES 2.0 format
    // Todo: Check this
    public byte nes2() {
      return (byte) ((flag7 >> 2) & 00000011);
    }

    // Upper nybble of mapper number
    public byte upperNybble() {
      return (byte) (flag7 & 11110000);
    }

    //TV system (0: NTSC; 1: PAL)
    public byte tvSystem(){
      return (byte)(flag9 & 1);
    }

//76543210
//  ||  ||
//  ||  ++- TV system (0: NTSC; 2: PAL; 1/3: dual compatible)
//  |+----- PRG RAM ($6000-$7FFF) (0: present; 1: not present)
//  +------ 0: Board has no bus conflicts; 1: Board has bus conflicts
    //flags 10 This byte is not part of the official specification, and relatively few emulators honor it.

  }

  public Cartridge(final String fileName) {

    final Path path = Paths.get(fileName);
    try {
      final byte[] fileContents = Files.readAllBytes(path);
      final CatridgeHeader header = new CatridgeHeader();
      final byte[] headerBytes = new byte[16];
      for (int i = 0; i < 16; i++) {
        headerBytes[i] = fileContents[i];
      }
      header.bytesToHeader(headerBytes);

      System.out.println(header.toString());

    } catch (final IOException io) {
      io.printStackTrace();
    }

  }
}
