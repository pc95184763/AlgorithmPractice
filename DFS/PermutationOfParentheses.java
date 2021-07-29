package DFS;
import java.util.* ;

public class PermutationOfParentheses {

  public static void main(String[] arg) {
    List<String> result = validParentheses(2 ) ;
    for (String i: result){
      System.out.print(i + " ") ;
    }
  }


  public static List<String> validParentheses(int n) {
    // Write your solution here
    List<String> result = new ArrayList<>() ;
    StringBuilder sb = new StringBuilder();

    helper(0, 0, sb, n, result) ;

    return result;

  }

  static void helper(int leftP, int rightP, StringBuilder sb, int n, List<String> result) {
    if ( leftP == n && rightP == n) {
      result.add( sb.toString() ) ;
      return ;
    }
    if ( leftP < n) {
      sb.append('(') ;
      helper(leftP + 1, rightP, sb, n, result) ;
      sb.deleteCharAt( sb.length() - 1) ;
    }
    if (rightP < leftP) {
      sb.append(')') ;
      helper(leftP , rightP + 1, sb, n, result) ;
      sb.deleteCharAt( sb.length() - 1) ;
    }
  }
}

/*
                                {}
                             /       \
                           (
                        /      \
                      ((         ()
                      \          /
										 (()        ()(
                        \         \
												(())      ()()
 */
