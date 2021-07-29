package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestMain {
  public static void main(String[] ar){
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>() ;

    minHeap.offer(4) ;
    minHeap.offer(5) ;
    minHeap.offer(2) ;
    minHeap.offer(3) ;
    minHeap.offer(1) ;
    while (!minHeap.isEmpty()) {
      System.out.print(minHeap.poll() + " " ) ;
    }
  }
}
