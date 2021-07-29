package HashTableAndString;

import java.util.*;

public class DeduplicateRepeatly {

  public static void main(String[] args) {
    String s = "abbbbazw" ;
    s.substring(2);
    //s = deduplicate1(s) ;
    System.out.println(s);
  }


  public String deduplicate(String s) {

    char []  input = s.toCharArray() ;
    Deque<Character> stack = new ArrayDeque<>() ;
    int fast = 0;

    while (fast < input.length) {
      if ( stack.isEmpty() || stack.peekFirst() != input[fast]) {
        stack.offerFirst(input[fast++]) ;
      } else {
        while (fast < input.length && stack.peekFirst() == input[fast]){
          fast++;
        }
        stack.pollFirst() ;
      }

    }
    int len = stack.size();
    for (int i = len - 1; i >= 0; i --) {
      input[i] = stack.pollFirst() ;
    }
    return new String(input, 0, len) ;
  }

//  public static String deduplicate1(String s) {
//    char[] input = s.toCharArray() ;
//    int top = 0;
//    int fast = 1;
//
//    while (fast < input.length) {
//      if ( top == 0 || input[top - 1] != input[fast] ) {
//        input[top++] = input[fast++] ;
//      }
//      else {
//        while(fast < input.length && input[fast] ) {
//          fast ++ ;
//        }
//        top--;
//      }
//    }
//
//    return new String(input, 0 , slow) ;
//  }


}
