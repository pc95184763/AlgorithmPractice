package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeWithThreeStacks {

  Deque<Integer> left ;
  Deque<Integer> right ;
  Deque<Integer> buffer ;

  public DequeWithThreeStacks() {
    // Write your solution here.
    left = new ArrayDeque<Integer>() ;
    right = new ArrayDeque<Integer>() ;
    buffer = new ArrayDeque<Integer>() ;

  }

  public void offerFirst(int element) {
    left.offerFirst(element) ;
  }

  public void offerLast(int element) {
    right.offerFirst(element) ;
  }

  public Integer pollFirst() {
    if ( isEmpty() ) {
      return null ;
    }
    if ( left.isEmpty() ) {
      moveFromRight() ;
    }

    return left.pollFirst() ;
  }

  public Integer pollLast() {
    if ( isEmpty() ) {
      return null ;
    }
    if ( right.isEmpty() ) {
      moveFromLeft() ;
    }
    return right.pollFirst() ;
  }

  public Integer peekFirst() {
    if ( isEmpty() ) {
      return null ;
    }
    if ( left.isEmpty() ) {
      moveFromRight() ;
    }
    return left.peekFirst() ;
  }

  public Integer peekLast() {
    if ( isEmpty() ) {
      return null ;
    }
    if ( right.isEmpty() ) {
      moveFromLeft() ;
    }
    return right.peekFirst() ;
  }

  public int size() {
    return left.size() + right.size() ;
  }

  public boolean isEmpty() {
    return left.isEmpty() && right.isEmpty() ;
  }

  private void moveFromRight() {
    int size = right.size() ;
    if (size % 2 == 0) {
      size /= 2;
    } else {
      size = size / 2 + 1 ;
    }
    int remaining = right.size() - size ;
    while ( remaining != 0) {

      buffer.offerFirst( right.pollFirst() ) ;
      remaining--;
    }
    while ( size != 0) {
      left.offerFirst( right.pollFirst() ) ;
      size--;
    }
    while ( !buffer.isEmpty()) {
      right.offerFirst( buffer.pollFirst() ) ;
    }
  }

  private void moveFromLeft() {
    int size = left.size() ;
    if (size % 2 == 0) {
      size /= 2;
    } else {
      size = size / 2 + 1 ;
    }
    int remaining = left.size() - size ;
    while ( remaining != 0) {

      buffer.offerFirst( left.pollFirst() ) ;
      remaining--;
    }
    while ( size != 0) {
      right.offerFirst( left.pollFirst() ) ;
      size--;
    }
    while ( !buffer.isEmpty()) {
      left.offerFirst( buffer.pollFirst() ) ;
    }
  }
}
