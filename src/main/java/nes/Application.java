package nes;

import nes.ui.MainWindow;

public class Application {

  public static void main(String[] args) {

//    Emulator emulator = new Emulator();
//    emulator.insertCatridge("/home/chetan/Desktop/SuperMario.nes");
//    emulator.powerUp()
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        MainWindow.createAndShowGUI();
      }
    });

  }

}
