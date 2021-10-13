package QueueStackDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class test {

  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>() ;
    deque.offerFirst(1);
    deque.offerFirst(2);
    deque.offerFirst(3);
    deque.offerLast(4);
    deque.offerLast(5);
    deque.offerLast(6);

    while ( !deque.isEmpty() ) {
      System.out.print( deque.peekFirst() ) ;
      System.out.print( deque.pollFirst() ) ;
    }
    System.out.print( deque.peekFirst() ) ;
    System.out.print( deque.pollFirst() ) ;

  }
}
