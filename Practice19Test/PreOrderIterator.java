package Practice19Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class PreOrderIterator implements Iterator<TreeNode> {

  Deque<TreeNode> deque ;

  PreOrderIterator (TreeNode root) {
    deque = new ArrayDeque<>() ;
    deque.offerFirst(root) ;
  }

  @Override
  public boolean hasNext() {
    return !deque.isEmpty() ;
  }

  @Override
  public TreeNode next() {
    if ( hasNext() ) {
      TreeNode node = deque.pollFirst() ;
      if (node.right != null ) {
        deque.offerFirst( node.right) ;
      }
      if (node.left != null) {
        deque.offerFirst(node.left) ;
      }
      return node ;
    }
    return null ;

  }

  public static  void main(String[] ar) {
    TreeNode node1 = new TreeNode(1)  ;
    TreeNode node2 = new TreeNode(2)  ;
    TreeNode node3 = new TreeNode(3)  ;
    TreeNode node4 = new TreeNode(4)  ;
    TreeNode node5 = new TreeNode(5)  ;
    node1.left = node2 ;
    node1.right = node3 ;
    node2.left = node4 ;
    node2.right = node5 ;
    PreOrderIterator it =  new PreOrderIterator(node1) ;
    while (it.hasNext()) {
      System.out.print( it.next() + " " ) ;
    }

  }


}



class TreeNode {
  int key ;
  TreeNode left ;
  TreeNode right;

  TreeNode( int key) {
    this.key = key ;
  }

  @Override
  public String toString() {
    return "Tree Node value:" + key +" \n";
  }
}