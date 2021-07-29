package DFS2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidPermutationsOfParenthesesII {

  private static char[] SYMBOL = {'(', ')', '<', '>', '{' ,'}'} ;

  public static void main(String[] args) {
    List<String> list = validParentheses(1,0,0) ;
    for (String s: list) {
      System.out.println(s);
    }
  }


  public static List<String> validParentheses(int l, int m, int n) {
    // Write your solution here
    int[] remain = new int[] {l, l, m, m, n, n} ;
    int total = 2 * l + 2 * m + 2 * n ;
    List<String> result = new ArrayList<>() ;
    StringBuilder buf = new StringBuilder() ;
    Deque<Character> stack = new ArrayDeque<>() ;

    DFS( stack, total, buf, remain, result)  ;
    return result ;
  }

  static void  DFS (Deque<Character> stack, int total ,StringBuilder buf, int[] remain, List<String> result ) {
    if (total == buf.length() ) {
      result.add(buf.toString() ) ;
      return ;
    }
    for (int i = 0 ; i < remain.length ; i++) {
      if ( i % 2 == 0 ) {
        if ( remain[i] > 0 ) {
          buf.append(SYMBOL[i]) ;
          stack.offerFirst(SYMBOL[i]) ;
          remain[i]-- ;
          DFS (stack, total, buf, remain, result) ;
          buf.deleteCharAt(buf.length() - 1) ;
          stack.pollFirst() ;
          remain[i]++ ;
        }
      } else {
        if ( !stack.isEmpty() && stack.peekFirst() == SYMBOL[i - 1] ) {
          buf.append(SYMBOL[i]) ;
          stack.pollFirst() ;
//          remain[i]-- ;   // ?
          DFS (stack, total, buf, remain, result) ;
          buf.deleteCharAt(buf.length() - 1) ;
          stack.offerFirst(SYMBOL[i - 1]) ;
//          remain[i]++ ;
        }
      }
    }
  }
}
