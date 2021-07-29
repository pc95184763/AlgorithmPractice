package Heap;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.tree.TreeNode;

public class KSmallest {
  public int[] kSmallest(int[] array, int k) {
    // Write your solution here
    if ( array.length == 0 ) {
      return array;
    }
    if (k == 0) {
      return new int []{} ;
    }


    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k , Collections.reverseOrder() ) ;
    int [] result = new int[k] ;
    for (int i = 0 ; i < k ; i ++) {
      maxHeap.offer(array[i]) ;
    }

    for (int i = k ; i < array.length ; i++) {
      if (array[i] < maxHeap.peek() ) {
        maxHeap.poll() ;
        maxHeap.offer(array[i]) ;
      }
    }
    for (int i = 0 ; i < k ; i++) {
      result[k - i - 1] = maxHeap.poll() ;
    }
    return result ;
  }
}
