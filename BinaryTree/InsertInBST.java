package BinaryTree;

public class InsertInBST {
  public TreeNode insert(TreeNode root, int key) {
    // Write your solution here
    TreeNode target = new TreeNode (key) ;
    if ( root == null) {
      return target ;
    }
    TreeNode tmpRoot = root ;
    TreeNode pre = null ;
    while ( root != null ) {
      pre = root ;
      if ( key < root.key) {
        root = root.left ;
      } else if (key > root.key) {
        root = root.right ;
      } else {
        return tmpRoot ;
      }
    }
    if ( key < pre.key) {
      pre.left = new TreeNode (key) ;
    } else {
      pre.right = new TreeNode (key) ;
    }
    return tmpRoot ;
  }
}
