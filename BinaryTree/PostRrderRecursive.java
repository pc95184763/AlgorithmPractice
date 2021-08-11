package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostRrderRecursive {
  public List<Integer> postOrder(TreeNode root) {
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

    helper(root.right, result) ;
    result.add(root.key) ;
  }
}
