package MyTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoNodeDistance {

  //T: O(n) n is # of nodes in the BST ;
  //S: O(height)
  public int distance (TreeNode root, TreeNode a, TreeNode b) {
    TreeNode lca = LCA(root, a, b) ;

    int lengthA = distance(lca, a) ;
    int lengthB = distance(lca, b) ;
    return lengthA + lengthB ;

  }

  public int distance(TreeNode root, TreeNode target) {
    int dis = 0 ;
    while (root != null) {
      if ( target.key < root.key ) {
        root = root.left ;
      } else if ( target.key > root.key ) {
        root = root.right ;
      } else {
        break ;
      }
      dis ++ ;
    }
    return dis ;
  }

  public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
    if (  root == null || root == a || root == b ) {
      return root ;
    }
    //step1:
    TreeNode leftResult = LCA(root.left, a, b );
    TreeNode rightResult = LCA(root.right, a, b );

    if (leftResult != null && rightResult != null ){
      return root ;
    }
    if (leftResult == null && rightResult != null) {
      return rightResult ;
    }
    if (leftResult != null && rightResult == null) {
      return leftResult ;
    }
    return null ;
  }

}
