package BinaryTree;

public class IsBinarySearchTreeOrNot {
  public boolean isBST(TreeNode root) {
    // Write your solution here
    if (root == null) {
      return true ;
    }
    return helper( root, Integer.MAX_VALUE, Integer.MIN_VALUE) ;
  }
  private boolean helper(TreeNode root, int max, int min) {
    if (root == null ) {
      return true ;
    }
    if ( root.key >= max || root.key <= min) {
      return false ;
    }

    return  helper(root.left, root.key, min) && helper(root.right, max, root.key) ;
  }
}
