package BinaryTree;

public class TweakedIdentical {

  // T：O(n ^ 2)
  // S: O(height)
  public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
    // Write your solution here
    if ( one == null && two == null) {
      return true ;
    }
    if ( one == null || two == null || one.key != two.key) {
      return false ;
    }
    return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right) ||
        isTweakedIdentical(one.right, two.left) && isTweakedIdentical(one.left, two.right) ;
  }
  
}
