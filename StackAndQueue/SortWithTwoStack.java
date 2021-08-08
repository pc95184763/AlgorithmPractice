package StackAndQueue;

import java.util.LinkedList;

public class SortWithTwoStack {

  public static void main(String [] args) {
    LinkedList<Integer> s = new  LinkedList<>() ;
    s.offerFirst(2) ;
    s.offerFirst(1) ;
    s.offerFirst(4) ;
    s.offerFirst(3) ;
    s.offerFirst(2) ;

    sort(s) ;

    for (Integer i : s ) {
      System.out.print(i + " ") ;
    }
  }

  public static void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    Integer preMax = Integer.MAX_VALUE ;
    int counter = 0 ;

    while ( !s1.isEmpty() && s1.peekFirst() < preMax ) {
      Integer curMax = Integer.MIN_VALUE ;

      while ( !s1.isEmpty() && s1.peekFirst() < preMax  ) {
        Integer cur = s1.pollFirst() ;
        if (cur > curMax) {
          curMax = cur ;
          counter = 1 ;
        } else if ( cur == curMax)  {
          counter ++ ;
        }
        s2.offer(cur) ;
      }
      while ( counter > 0) {
        s1.offerFirst(curMax) ;
        counter-- ;
      }
      while ( !s2.isEmpty() ) {

        int cur = s2.pollFirst();
        if ( cur != curMax) {
          s1.offerFirst( cur ) ;
        }
      }
      preMax = curMax ;

    }


  }
}
