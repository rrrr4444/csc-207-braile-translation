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

} // class BitTree