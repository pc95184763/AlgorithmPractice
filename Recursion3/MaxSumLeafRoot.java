package Recursion3;

import java.util.Set;

public class MaxSumLeafRoot {

  public static void main(String[] args) {
    int [] arr = new int[]  {} ;
  }

  public int maxPathSumLeafToRoot(TreeNode root) {
    // Write your solution here
    int prefixSum = 0 ;
    int[] max = new int[] { Integer.MIN_VALUE} ;
    helper(root, prefixSum, max) ;
    return max[0] ;
  }

  void helper( TreeNode root,int prefixSum, int[] max) {
    if (root == null ) {
      return ;
    }
    if (root.left == null && root.right == null ) {
      max[0] = Math.max(max[0], prefixSum) ;
    }

    helper(root.left, prefixSum + root.key, max) ;
    helper(root.right, prefixSum + root.key, max) ;
  }


}
