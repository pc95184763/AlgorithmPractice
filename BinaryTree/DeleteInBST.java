package BinaryTree;

public class DeleteInBST {
  public TreeNode deleteTree(TreeNode root, int key) {
    // Write your solution here
    if (root == null) {
      return root ;
    }
    if ( key < root.key) {
      root.left = deleteTree( root.left, key) ;
      return root;
    }
    else if ( key > root.key) {
      root.right = deleteTree( root.right, key) ;
      return root ;
    }
    if ( root.left == null) {
      return root.right ;
    }
    else if ( root.right == null ) {
      return root.left ;
    }
    if ( root.right.left == null ) {
      root.right.left = root.left ;
      return root.right ;
    }
    TreeNode smallest = deleteSmallest( root.right ) ;
    smallest.left = root.left ;
    smallest.right = root.right ;

    return smallest ;
  }
  private TreeNode deleteSmallest(TreeNode root) {
    TreeNode small = root.left ;

    while ( small.left != null) {
      root = small ;
      small = small.left ;
    }
    root.left = small.right ;

    return small ;
  }
}
