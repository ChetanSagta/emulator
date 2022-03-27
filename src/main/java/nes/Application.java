package nes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
  
  private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
  public static String bytesToHex(byte[] bytes) {
    char[] hexChars = new char[bytes.length * 2];
    for (int j = 0; j < bytes.length; j++) {
      int v = bytes[j] & 0xFF;
      hexChars[j * 2] = HEX_ARRAY[v >>> 4];
      hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
    }
    return new String(hexChars);
  }

  public static void main(String[] args) throws IOException {

    //int data = 0;
    //String fileLocation = "/home/chetan/Desktop/SuperMario.nes";
    //BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
    //while ((data = reader.ready()) != -1) {
    //  System.out.print(data + " ");
    //}
    //reader.close();

    //Path path = Paths.get(fileLocation);
    //byte[] data = Files.readAllBytes(path);
    //for(int i=0;i<data.length;i++){
    //  System.out.print(data[i]+" ");
    //}
    //String finalValues = bytesToHex(data);
    //System.out.println(finalValues);
    
  }

}
