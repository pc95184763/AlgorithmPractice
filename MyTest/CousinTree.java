package MyTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class CousinTree {


  public boolean isCousins(TreeNode root, TreeNode a, TreeNode  b) {
    if (root == null || a == null || b == null || root == a || root == b) {
      return false ;
    }
    Queue<TreeNode> queue = new ArrayDeque<>() ;
    queue.offer(root) ;

    while ( !queue.isEmpty()) {
      int size = queue.size() ;
      TreeNode cur = queue.poll() ;
//      if ( cur.left)
    }

    return false ;
  }
}


class TreeNode {

  public int key;
  public  TreeNode left;
  public  TreeNode right;
  public TreeNode(int key) {
    this.key = key;
  }
}
