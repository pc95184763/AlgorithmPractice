package TreeTraversal;
import java.util.* ;

public class PostOrder {

  public static void main(String [] args) {
      TreeNode node1 = new TreeNode(1) ;
    TreeNode node2 = new TreeNode(2) ;
    TreeNode node3 = new TreeNode(3) ;
    node1.left = node2 ;
    node1.right = node3 ;

    List<Integer> result = postOrder(node1) ;
    for (int i : result) {
      System.out.print(i+" ") ;
    }
  }

  public static List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>() ;
    helper(root, result) ;

    return result;
  }

  private static void helper(TreeNode root, List<Integer> result) {
    TreeNode pre = null ;
    Deque<TreeNode> stack = new ArrayDeque<>() ;
    stack.offerFirst(root) ;
    while ( !stack.isEmpty() ){
      TreeNode cur = stack.peekFirst() ;
      if ( pre == null || pre.left == cur || pre.right == cur) {
        if (cur.left != null) {
          stack.offerFirst(cur.left) ;
        }
        else if ( cur.right != null) {
          stack.offerFirst(cur.right) ;
        }
        else {
          result.add( stack.pollFirst().key ) ;
        }
      } else if ( pre == cur.left) {
        if (cur.right != null) {
          stack.offerFirst(cur.right) ;
        }else {
          result.add( stack.pollFirst().key ) ;
        }
      } else {
        result.add( stack.pollFirst().key ) ;
      }
      pre = cur;
    }
  }
}

class TreeNode {

    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
}


