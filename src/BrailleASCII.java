/**
 * CLI translator.
 *
 * @author Reed Colloton
 */
class BrailleASCII {
  public static void main(String[] args) {
    if (args.length != 2) {
      throw new IllegalArgumentException();
    } // if
    BrailleASCIITables tables = new BrailleASCIITables();
    switch (args[0].toLowerCase()) {
      case "braille" -> tables.toBraille(args[1]);
      case "ascii" -> tables.toASCII(args[1]);
      case "unicode" -> tables.toUnicode(args[1]);
    } // switch
  } // main()

} // class BrailleASCII
