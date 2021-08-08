package StackAndQueue;

import java.util.*;

public class StackByQueue {

  Queue<Integer> q ;
  /** Initialize your data structure here. */
  public StackByQueue() {
    q = new ArrayDeque<Integer>() ;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    q.offer(x) ;
  }

  /** Removes the element on top of the stack and returns that element. */
  public Integer pop() {
    if (q.isEmpty() ) {
      return null ;
    }
    int size = q.size() ;
    while ( --size != 0) {
      q.offer ( q.poll () ) ;
    }
    Integer cur = q.poll () ;

    return cur ;
  }

  /** Get the top element. */
  public Integer top() {
    Integer cur = this.pop() ;
    q.offer(cur) ;
    return cur ;
  }

  /** Returns whether the stack is empty. */
  public boolean isEmpty() {
    return q.isEmpty() ;
  }
}
