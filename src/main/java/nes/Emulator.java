package nes;

import lombok.extern.slf4j.Slf4j;
import nes.hardware.Cartridge;

import java.net.URI;

@Slf4j
public class Emulator {


  Cartridge catridge = null;

  public void powerUp() {

    if(catridge == null) {
      log.info("Insert a catridge");
    }

  }

  public void reset() {

  }

  public void connectInput() {

  }

  public void disconnectInput() {

  }

  public void connectDisplay() {

  }

  public void disconnectDisplay() {
  }

  public void insertCatridge(URI fileName) {

    log.info("Starting catridge");
    catridge = new Cartridge(fileName);

  }

  public void disconnectCatridge() {
    catridge = null;
  }

}
