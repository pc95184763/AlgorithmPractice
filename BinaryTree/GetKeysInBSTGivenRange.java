package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBSTGivenRange {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;
    helper(root, result, min, max ) ;

    return result ;
  }
  private void helper(TreeNode root, List<Integer> result, int min, int max) {
    if (root == null ) {
      return  ;
    }
    if (root.key > min) {
      helper(root.left, result, min, max) ;
    }

    if (root.key <= max && root.key >= min) {
      result.add(root.key) ;
    }
    if (root.key < max) {
      helper(root.right, result, min, max) ;
    }

  }
}
