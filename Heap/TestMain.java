package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TestMain {
  public static void main(String[] ar){
    int[] arr = new int[] {38, -1,1,23,88} ;
    MyHeapIm minHeap = new MyHeapIm(arr) ;


    while (!minHeap.isEmpty()) {
      System.out.print(minHeap.poll() + " " ) ;
    }
  }
}
