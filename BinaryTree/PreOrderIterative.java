package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PreOrderIterative {

  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;
    if ( root == null) {
      return result ;
    }
    Deque<TreeNode> stack = new ArrayDeque<>() ;
    stack.offerFirst(root) ;

    while ( !stack.isEmpty() ) {
      TreeNode cur = stack.pollFirst() ;
      result.add(cur.key) ;
      if (cur.right != null ) {
        stack.offerFirst(cur.right) ;
      }
      if (cur.left != null ) {
        stack.offerFirst(cur.left) ;
      }
    }
    return result ;
  }
}
