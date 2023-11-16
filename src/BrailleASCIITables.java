import java.io.FileInputStream;
import java.io.IOException;

/**
 * Utilities for converting using BitTrees.
 *
 * @author Reed Colloton
 */
public class BrailleASCIITables {
  BitTree ASCIIToBraille = new BitTree(8);
  BitTree BrailleToASCII = new BitTree(6);
  BitTree BrailleToUnicode = new BitTree(6);

  /**
   * Constructor
   */
  BrailleASCIITables() {
    try (FileInputStream brailleFile = new FileInputStream("translations/ascii.txt");
         FileInputStream asciiFile = new FileInputStream("translations/braille.txt");
         FileInputStream unicodeFile = new FileInputStream("translations/unicode.txt")) {
      ASCIIToBraille.load(brailleFile);
      BrailleToASCII.load(asciiFile);
      BrailleToUnicode.load(unicodeFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  } // BrailleASCIITables

  /**
   * Converts an ASCII character to a string of bits representing the corresponding braille character..
   */
  String toBraille(char letter) {
    return ASCIIToBraille.get(letter + "");
  } // toBraille()

  /**
   * Converts a string of bits representing a braille character to the corresponding ASCII character.
   */
  String toASCII(String bits) {
    return BrailleToUnicode.get(bits);
  } // toASCII()

  /**
   * Converts a string of bits representing a braille character to the corresponding Unicode braille character for those bits. You need only support six-bit braille characters.
   */
  String toUnicode(String bits) {
    return BrailleToUnicode.get(bits);
  } // toUnicode()

} // class BrailleASCIITables