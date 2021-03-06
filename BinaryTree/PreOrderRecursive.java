package BinaryTree;

import java.util.ArrayList;
import java.util.List;



public class PreOrderRecursive {
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;
    helper(root, result) ;

    return result ;
  }

  private void helper(TreeNode root, List<Integer> result) {
    if (root == null )  {
      return  ;
    }
    result.add(root.key) ;
    helper(root.left, result) ;
    helper(root.right, result) ;
  }
}
