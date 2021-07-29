package CrossTraining;

import java.util.*;

public class ClosestNumber {
  public static void main(String[ ]args) {
    TreeNode n8 = new TreeNode(8) ;
    TreeNode n5 = new TreeNode(5) ;
    TreeNode n10 = new TreeNode(10) ;
    n8.left = n5 ;
    n8.right = n10 ;

    TreeNode n3 = new TreeNode(3) ;
    TreeNode n7 = new TreeNode(7) ;
    TreeNode n9 = new TreeNode(9) ;
    n10.left = n9 ;
    n5.left = n3;
    n5.right = n7;

    TreeNode n1 = new TreeNode(1) ;
    TreeNode n4 = new TreeNode(4) ;
    TreeNode n6 = new TreeNode(6) ;
    n3.left = n1 ;
    n3.right = n4 ;
    n7.left = n6;
    TreeNode n2 = new TreeNode(2) ;
    n1.right = n2 ;

    closestKValues(n8,100.0, 100) ;
  }
  public static int[] closestKValues(TreeNode root, double target, int k) {
// Write your solution here
    Queue<Integer> q = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();
    inorder(root, result);
    for (int i = 0; i < result.size(); i++) {
      if (i < k) {
        q.offer(result.get(i));
      } else {
        if (Math.abs(target - q.peek()) > Math.abs(target - result.get(i))) {
          q.poll();
          q.offer(result.get(i));
        }
      }
    }

    int length = q.size() ;
    int[] ans = new int[length];
    for (int i = 0; i < length; i++) {
      ans[i] = q.poll();
      System.out.print(ans[i] + " ") ;
    }
    return ans;
  }

  private static void inorder(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    inorder(root.left, result);
    result.add(root.key);
    inorder(root.right, result);
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
