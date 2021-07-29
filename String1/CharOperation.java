package String1;

import java.util.*;

public class CharOperation {

  void removeChar(StringBuilder input) {
    int i = 0;
    for (int j = 0; j < input.length() ; j++) {
      if(input.charAt(j) != 'u' && input.charAt(j) != 'n' ) {
        input.setCharAt(i, input.charAt(j) ) ;
        i++ ;
      }
    }
  }

  String removeSpaces(String input) {
    if (input.isEmpty() ) {
      return input ;
    }
    char[] array = input.toCharArray() ;

    int slow = 0;
    for(int i = 0 ; i < array.length ; i++) {
      if (array[i] == ' ' && (slow == 0 || array[slow - 1] == ' ' ) ) {
        continue ;
      }
      array[slow++] = array[i] ;
    }
    if (slow > 0 && array[slow - 1] == ' ') {
      slow -- ;
    }
    return new String(array, 0 , slow) ;
  }

  public String deDup(String input) {
    if (input == null || input.length() <= 1) {
      return input ;
    }
    char[] array = input.toCharArray() ;
    int slow = 1;
    for (int i = 1; i < array.length ; i++) {
      if (array[i] != array[slow - 1]) {
        array[slow++] = array[i];
      }
    }
    return new String(array,0, slow);
  }
  public String deduplicate(String input) {
    if (input == null || input.length() <= 1) {
      return input ;
    }
    char[] array = input.toCharArray() ;
    Deque<Character> stack = new ArrayDeque<>() ;
    int fast = 0;
    while ( fast < array.length) {
      char curChar = array[fast] ;
      if ( !stack.isEmpty() && stack.peekFirst() == curChar ) {
        while (fast < array.length && array[fast] == curChar ){
          fast++ ;
        }
        stack.pollFirst() ;
      } else {
        stack.offerFirst(curChar) ;
        fast++ ;
      }
    }
    int len = stack.size() ;
    for (int i = len - 1; i >= 0; i--) {
      array[i] = stack.pollFirst() ;
    }
    return new String(array, 0, len) ;
  }








}
