package BinaryTree;

public class SearchInBST {

  public TreeNode search(TreeNode root, int key) {
    // Write your solution here
    while (root != null) {
      if ( key < root.key ) {
        root = root.left ;
      } else if ( key > root.key) {
        root = root.right ;
      } else {
        return root ;
      }
    }
    return root ;
  }
}
