class BitTreeLeaf extends BitTreeNode {
  String value;
  BitTreeLeaf(String bits, String value) {
    super(bits);
    this.value = value;
  } // BitTreeNode

  @Override
   boolean isLeaf() {
    return true;
  } // isLeaf()
} // class BitTreeNode
