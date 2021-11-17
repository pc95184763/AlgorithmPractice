package Heap;

import java.util.Arrays;

public class MyHeapIm {
  private int[] array ;
  private int size ;

  public MyHeapIm(int cap) {
    array = new int[cap] ;
  }
  public void offer(int data) {
    if ( size == array.length ) {
      array = Arrays.copyOf(array, (int) (array.length * 1.5) ) ;
    }
    array[size++] = data ;
    percolateUp(size - 1) ;
  }
  public Integer poll() {
    if ( size == 0) {
      return null ;
    }
    Integer i = array[0] ;
    swap(0, --size);
    percolateDown(0);
    return i;
  }


  public MyHeapIm(int[] data) {
    array = data ;
    size = data.length ;
    heapify() ;
  }
  private void heapify() {
    for (int i = size/2 - 1 ; i >= 0 ; i--) {
      percolateDown( i ) ;
    }
  }

  private void percolateDown(int index) {
    int candidate = 0 ;
    while ( index * 2 + 1 < size ) {
      candidate = index * 2 + 1 ;
      if ( candidate + 1 < size && array[candidate + 1] < array[candidate] ) {
        candidate += 1;
      }
      if ( array[candidate] < array[index]) {
        swap(candidate, index) ;
      }

      index = candidate ;
    }
  }
  // minHeap
  private void percolateUp(int index) {
    int parent = 0 ;
    while ( index > 0  ) {
      parent = (index - 1) / 2;
      if ( array[index] >= array[parent] ){
        break ;
      }
      swap(parent, index) ;
      index = parent ;
    }
  }
  private void swap(int i , int j) {
    int temp = array[i];
    array[i] = array[j] ;
    array[j] = temp ;
  }
  public int update(int index, int element) {
    if (index < 0 || index > size - 1 ) {
      throw new ArrayIndexOutOfBoundsException("Invalid Parameter") ;
    }
    int result = array[index] ;
    array[index] = element ;
    if ( array[index] > result) {
      percolateDown(index);
    } else {
      percolateUp(index);
    }
    return result ;
  }
  public boolean isEmpty() {
    return size == 0;
  }




}
