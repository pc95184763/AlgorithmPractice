package StackAndQueue;

import java.util.ArrayDeque;

public class StackWithMin {

  ArrayDeque<Integer> stack ;
  int  min = Integer.MAX_VALUE ;

  public StackWithMin() {
    // write your solution here
    stack = new ArrayDeque<Integer>() ;

  }

  public int pop() {
    if ( stack.isEmpty() ) {
      return -1;
    }
    int cur = stack.pollFirst() ;
    return cur ;
  }

  public void push(int element) {
    min = Math.min(min, element) ;
    stack.offerFirst(element) ;
  }

  public int top() {
    if ( stack.isEmpty() ) {
      return -1;
    }
    return stack.peekFirst() ;
  }

  public int min() {
    if (stack.isEmpty() ) {
      return -1;
    }
    return min ;

  }
}
