package Recursion3;

public class LeafToLeaf {

  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0 ;
    }

    int left = helper(root.left, max) ;
    int right = helper(root.right, max) ;
    int currSum = left + right + root.key;

    if ( currSum > max[0]  && root.left != null && root.right != null ) {
        max[0] = currSum ;
//      return Math.max(left, right) + root.key ;
    }

    return root.left == null? right + root.key : left + root.key ;

//    if (root.left == null) {
//      return root.key + right ;
//    } else  {
//      return root.key + left ;
//    }

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
