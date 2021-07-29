package CrossTraining;

public class LCAParent {

  public static void main (String [] args) {
    System.out.println(null == null);
  }

  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    int heightOne = height(one) ;
    int heightTwo = height(two) ;

    while (heightOne > heightTwo) {
      one = one.parent ;
      heightOne--;

    }
    while (heightTwo > heightOne) {
      two = two.parent ;
      heightTwo--;
    }

    while (heightOne > 0  ) {
      if (one == two) {
        return one ;
      }
      one = one.parent ;
      two = two.parent ;
      heightOne -- ;
    }

    return null ;
  }

  public int height (TreeNodeP root) {
    int height = 0;
    if( root != null) {
      height++ ;
      root = root.parent ;
    }
    return height ;
  }
}

class TreeNodeP {
  public int key;
  public TreeNodeP left;
  public TreeNodeP right;
  public TreeNodeP parent;
  public TreeNodeP(int key, TreeNodeP parent) {
    this.key = key;
    this.parent = parent;
  }
}
