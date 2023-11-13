class BitTreeNode {
  final String bits;
  BitTreeNode left;
  BitTreeNode right;

  BitTreeNode(String bits) {
    this.bits = bits;
  } // BitTreeNode

  boolean isLeaf() {
    return false;
  } // isLeaf
} // class BitTreeNode
