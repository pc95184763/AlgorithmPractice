package String2;

import java.util.*;

public class RemoveRepeatChar {
  public static void main(String [] args) {
    String test = new String("aabaabab") ;

    System.out.println( deDup(test ) ) ;
  }

  public static String deDup(String input) {
    // Write your solution here
    char[] array = input.toCharArray() ;
    Deque<Character> stack = new ArrayDeque<>() ;
    int fast = 0;

    while( fast < array.length ) {
      if ( stack.isEmpty() || array[fast] != stack.peekFirst() ) {
        stack.offerFirst( array[fast++] ) ;
      }else {
        while ( fast < array.length && array[fast] ==  stack.peekFirst() ) {
          fast ++ ;
        }
        stack.pollFirst() ;

      }

    }

    int len = stack.size() ;
    for (int i = len - 1; i >= 0 ;i--) {
      array[i] = stack.pollFirst();
    }
    return new String(array, 0, len) ;
  }
}
