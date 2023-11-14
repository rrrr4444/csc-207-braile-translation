import java.io.PrintWriter;
import java.io.InputStream;

class BitTree {
  private final int depth;
  private BitTreeNode root = null;

  BitTree(int n) {
    this.depth = n;
  } // BitTree()

  void set(String bits, String value) {
    if (bits.length() != this.depth || !bits.matches("[0-9]+")) {
      throw new IllegalArgumentException();
    } // if
    this.root = setRecurse(bits, value, this.root);
  } // set()

  private BitTreeNode setRecurse(String bits, String value, BitTreeNode node) {
    if (bits.isEmpty()) {
      return new BitTreeLeaf(bits, value);
    } else {
      if (node == null) {
        node = new BitTreeNode(bits);
      } // if
      if (bits.charAt(0) == '0') {
        node.left = setRecurse(bits.substring(1), value, node.left);
      } else {
        node.right = setRecurse(bits.substring(1), value, node.right);
      } // if/else
    } // if/else
    return node;
  } // setRecurse()

  String get(String bits) {
    if (bits.length() != this.depth || !bits.matches("[0-9]+")) {
      throw new IllegalArgumentException();
    } // if
    return getRecurse(bits, this.root);
  } // get()

  private String getRecurse(String bits, BitTreeNode node) {
    if (node == null) {
      throw new IllegalArgumentException();
    } else if (node.isLeaf() && bits.isEmpty()) {
      return ((BitTreeLeaf) node).value;
    } else {
      if (bits.charAt(0) == '0') {
        return getRecurse(bits.substring(1), node.left);
      } else {
        return getRecurse(bits.substring(1), node.right);
      } // if/else
    } // if/else
  } // get()

  void dump(PrintWriter pen) {
    dumpRecurse(pen, this.root);
  } // dump()

  private void dumpRecurse(PrintWriter pen, BitTreeNode node) {
    if (node == null) {
      return;
    } // if
    if (node.isLeaf()) {
      pen.println(node.bits + "," + ((BitTreeLeaf) node).value);
    } else {
      dumpRecurse(pen, node.left);
      dumpRecurse(pen, node.right);
    } // if/else
  } // dump()

  void set(InputStream source) {
    String[] lines = source.toString().split("\n");
    for (String line: lines) {
      String[] elements = line.split(",");
      this.set(elements[0], elements[1]);
    } // for
  } // set()

} // class BitTree