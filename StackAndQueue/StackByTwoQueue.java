package StackAndQueue;

import java.util.ArrayDeque;
import java.util.*;

public class StackByTwoQueue {

  Queue<Integer> q1 ;
  Queue<Integer> q2 ;

  /** Initialize your data structure here. */
  public StackByTwoQueue() {
    q1 = new ArrayDeque<>() ;
    q2 = new ArrayDeque<>() ;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    q1.offer(x) ;
  }

  /** Removes the element on top of the stack and returns that element. */
  public Integer pop() {
    Integer pre = q1.poll() ;
    Integer cur = q1.poll() ;
    while (cur != null ) {
      q2.offer(pre) ;
      pre = cur ;
      cur = q1.poll() ;
    }
    Queue<Integer> tmp = q1;
    q1 = q2;
    q2 = tmp ;
    return pre ;
  }

  /** Get the top element. */
  public Integer top() {
    if ( q1.isEmpty() ) {
      return null ;
    }
    Integer cur = pop() ;
    q1.offer(cur) ;
    return cur ;
  }

  /** Returns whether the stack is empty. */
  public boolean isEmpty() {
    return q1.isEmpty() ;
  }
}
