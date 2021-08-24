package BinaryTree;

public class isSymmetric {

  public static void main(String[] args) {
    TreeNode p = new TreeNode(1) ;
    System.out.println( isSymmetric(p) );
  }


  public static boolean isSymmetric(TreeNode root) {
    // Write your solution here
    if (root == null ) {
      return true;
    }
    return isSymmetric(root.left, root.right) ;
  }

  private static boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true ;
    }
    if (left == null || right == null || left.key != right.key) {
      return false ;
    }
    return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right) ;
  }
}
