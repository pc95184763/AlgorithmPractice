package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderRecursive {
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;
    helper(root, result) ;
    return result ;
  }
  private void helper(TreeNode root, List<Integer> result ) {
    if (root == null ) {
      return  ;
    }
    helper(root.left, result) ;
    result.add(root.key) ;
    helper(root.right, result) ;
  }
}
