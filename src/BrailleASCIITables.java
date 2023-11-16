import java.io.FileInputStream;
import java.io.IOException;

public class BrailleASCIITables {
  BrailleASCIITables() {
    BitTree brailleToASCII = new BitTree(6);
    BitTree ASCIIToBraille = new BitTree(5);
    BitTree UnicodeToBraille = new BitTree(16);
    try (FileInputStream asciiFile = new FileInputStream("translations/ascii.txt");
         FileInputStream unicodeFile = new FileInputStream("translations/ascii.txt")) {
      brailleToASCII.load(asciiFile);
      brailleToASCII.load(unicodeFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
