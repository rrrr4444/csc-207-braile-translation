class BitTreeLeaf extends BitTreeNode {
  final String translation;
  BitTreeLeaf(String bits, String translation) {
    super(bits);
    this.translation = translation;
  } // BitTreeNode

  @Override
   boolean isLeaf() {
    return true;
  } // isLeaf()
} // class BitTreeNode
