package nes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class Application {

  public static void main(String[] args) throws URISyntaxException {

    Emulator emulator = new Emulator();
    URI nesFile = Objects.requireNonNull(Application.class.getClassLoader().getResource("Super_mario_brothers.nes")).toURI();
    emulator.insertCatridge(nesFile);
    emulator.powerUp();
  }

}
