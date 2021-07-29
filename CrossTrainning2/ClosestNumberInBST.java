package CrossTrainning2;

public class ClosestNumberInBST {

  public int closest(TreeNode root, int target) {
    // Write your solution here
    if (root == null) {
      return 0 ;
    }
    if ( root.key == target) {
      return root.key ;
    }
    else if ( root.key < target) {
      //当前层得到最小差值
      int curDiff = Math.abs(root.key - target ) ;
      //assume right subtree would be able to return m
      int rightDiff = Math.abs( closest(root.right, target) - target );
      return curDiff < rightDiff? root.key : root.right.key ;
    }
    else {
      int curDiff = Math.abs( root.key - target) ;
      int leftDiff = Math.abs( closest(root.left, target) - target );
      return curDiff < leftDiff? root.key : root.left.key ;
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

