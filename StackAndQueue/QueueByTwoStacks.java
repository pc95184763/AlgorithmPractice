package StackAndQueue;

import java.util.ArrayDeque;

public class QueueByTwoStacks {

  ArrayDeque<Integer> in ;
  ArrayDeque<Integer> out ;

  public QueueByTwoStacks() {
    // Write your solution here.
    in = new ArrayDeque<Integer>() ;
    out = new ArrayDeque<Integer>() ;
  }

  public Integer poll() {
    if (  isEmpty() ) {
      return null;
    }
    if ( out.isEmpty() ) {
      transfer() ;
    }
    Integer cur = out.pollFirst() ;
    return cur ;

  }

  public void offer(int element) {
    in.offerFirst(element) ;
  }

  public Integer peek() {
    if (  isEmpty() ) {
      return null;
    }
    if ( out.isEmpty() ) {
      transfer() ;
    }
    return out.peekFirst() ;
  }

  public int size() {
    return in.size() + out.size() ;
  }

  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty( ) ;
  }

  private void transfer() {
    while ( !in.isEmpty() ) {
      out.offerFirst( in.pollFirst()) ;
    }
  }

}
