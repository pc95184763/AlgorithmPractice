package Recursion2;

public class StoreNumberOfNodesInLeftSubtree {

  public void numNodesLeft(TreeNodeLeft root) {
    // Write your solution here

    helperLeft(root) ;

  }

  private int helperLeft (TreeNodeLeft root) {

    if (root == null) {
      return 0;
    }
    int left = (helperLeft(root.left) ) ;
    int right = (helperLeft(root.right) ) ;

    root.numNodesLeft = left ;

    return left + right + 1;

  }
}

 class TreeNodeLeft {
    public int key;
    public TreeNodeLeft left;
    public TreeNodeLeft right;
    public int numNodesLeft;
    public TreeNodeLeft(int key) {
      this.key = key;
    }
  }