package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubtrees {

  static HashMap<String, Integer> memo = new HashMap<>() ;
  static LinkedList<TreeNode> res = new LinkedList<>() ;

  public static void main( String[] args) {
    TreeNode p1 = new TreeNode(-1) ;
    TreeNode p2 = new TreeNode(1) ;
    TreeNode p3 = new TreeNode(1) ;
    p1.left = p2 ;
    p1.right = p3 ;

    List<TreeNode> result = findDuplicateSubtrees (p1) ;
    for (TreeNode p : result) {


      System.out.print( p.key) ;
    }
  }
  public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {

    StringBuilder prefix = new StringBuilder() ;
    traverse(root,prefix)     ;
    return res ;

  }

  static String traverse1(TreeNode root) {
    if ( root == null) {
      return "#" ;
    }
    String left = traverse1(root.left) ;
    String right = traverse1(root.right) ;
    String subTree = left + "," + right + "," + root.key ;
    int freq = memo.getOrDefault(subTree, 0) ;
    if ( freq == 1) {
      res.add(root) ;
    }
    memo.put( subTree, freq + 1) ;
    return subTree ;
  }

  static void  traverse(TreeNode root, StringBuilder prefix) {
    if ( root == null  ) {
      prefix.append("#") ;
      return ;
    }

    traverse(root.left, prefix) ;
    prefix.append(",") ;
    traverse(root.right, prefix) ;
    prefix.append(",") ;

    prefix.append(root.key ) ;

    String subTree = prefix.toString() ;

    int freq = memo.getOrDefault(subTree, 0) ;
    if ( freq == 1) {
      res.add(root) ;
    }
    memo.put( subTree, freq + 1) ;
    prefix.deleteCharAt(prefix.length() - 1) ;
    prefix.deleteCharAt(prefix.length() - 1) ;
    prefix.deleteCharAt(prefix.length() - 1) ;
    prefix.deleteCharAt(prefix.length() - 1) ;
    prefix.deleteCharAt(prefix.length() - 1) ;

  }
}
