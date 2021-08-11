package BinaryTree;

public class HeightOfBT {


  public int findHeight(TreeNode root) {
    // Write your solution here
    if ( root == null ) {
      return 0 ;
    }
    return Math.max( findHeight(root.left), findHeight(root.right) ) + 1 ;
  }
}
