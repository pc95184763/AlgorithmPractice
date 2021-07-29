package DFS;
import java.util.* ;

public class PermutationOfIf {


  public static void main(String [] args) {
//    solution( 2 ) ;

    String test = new String("Alibaba") ;
    System.out.println(test.hashCode() );
  }

  static List<String> mySolution(int n) {

    List<String> result = new ArrayList<>() ;
    StringBuilder buf = new StringBuilder() ;
    DFS(0, 0 , n, buf, result) ;
    return result;
  }

  //l: number of left if block
  //r: number of right if block
  static void DFS (int l, int r, int n, StringBuilder buf, List<String> result) {
    if( l == n && r == n) {
      result.add( buf.toString() ) ;
      return ;
    }
    if (l < n) {
      buf.append("  if {\n") ;  // there is a space between if and {  ; exist two spaces before each if statement;
      DFS( l + 1, r, n, buf, result) ;
      buf.delete( buf.length() - 7, buf.length() ) ;
    }
    if (r < l) {
      buf.append("\n}") ;
      DFS( l, r + 1, n, buf, result) ;
      buf.delete( buf.length() - 2 , buf.length() ) ;  //吃多少吐多少
    }
  }

  public static void solution(int n) {
    if ( n <= 0){
      return ;
    }
    char[] cur = new char[2 * n] ;
    helper(n, n, 0, cur) ;
  }

  private static void helper( int leftR, int rightR, int index, char[] cur ) {
    if (leftR == 0 && rightR == 0) {
      printBlock(cur) ;
      return ;
    }
    if (leftR > 0) {
      cur[index] = '{' ;
      helper(leftR - 1, rightR , index + 1, cur) ;
    }
    if (rightR > leftR) {
      cur[index] = '}' ;
      helper(leftR, rightR - 1, index + 1, cur) ;
    }
  }

  private static void printBlock( char[] cur) {
    int space = 0;
    for (int i = 0 ; i < cur.length; i ++) {
      if (cur[i] == '{') {
        printSpace(space) ;
        System.out.println("if {") ;
        space += 2;
      } else {
        space -= 2;
        printSpace(space) ;
        System.out.println("}") ;
      }
    }
    System.out.println() ;
  }

  private static void printSpace(int n) {
    for (int i = 0; i < n; i++) {
      System.out.print(' ') ;
    }
  }

}
