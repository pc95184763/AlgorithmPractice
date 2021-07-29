package Heap;

import java.util.Arrays;

public class MyHeapIm {
  private int[] array ;
  private int size ;

  public MyHeapIm(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Input array can NOT be null or empty") ;
    }
    this.array =array ;
    size = array.length ;
    heapify( ) ;
  }

  public MyHeapIm(int cap) {
    if (cap <= 0) {
      throw new IllegalArgumentException("Capacity can NOT be <= 0") ;
    }
    array = new int[cap] ;
    size = 0;
  }

  public int size () {
    return size ;
  }

  public boolean isEmpty() {
    return size == 0 ;
  }
  public boolean isFull() {
    return size == array.length ;
  }

  private void percolateUp(int index) {

      while (index > 0) {
        int parent = (index - 1) / 2 ;
        if ( array[index] < array[parent] ) {
          swap(  index, parent) ;
          index = parent ;
        } else {
          break;
        }
      }
  }
  private void percolateDown(int index) {
    while (index <= size / 2 - 1) {
      int left = index * 2 + 1;
      int right = index * 2 + 2;
      int swapCandidate = left ;
      if (right <= size - 1 && array[right] < array[left] ) {
        swapCandidate  =right ;
      }

      if ( array[index] > array[swapCandidate] ) {
        swap(  index, swapCandidate );
        index = swapCandidate ;

      } else {
        break ;
      }
    }
  }

  private void swap ( int i, int j) {
    int temp = array[i] ;
    array[i] = array[j] ;
    array[j] = temp ;
  }

  public int peek() {
    if ( size == 0 ) {
      throw new IllegalArgumentException("No element in heap") ;

    }
    return array[0] ;
  }
  public int poll() {
    if ( size == 0 ) {
      throw new IllegalArgumentException("No element in heap") ;

    }
    int result = array[0] ;
    swap(  0 , size - 1 ) ;
    size -- ;
    percolateDown(0);
    return result ;
  }

  public void offer(int ele) {
    if ( size == array.length ) {
      array = Arrays.copyOf(array, (int) (array.length * 1.5) ) ;
    }
    array[size++] = ele ;
    percolateUp(size - 1);
  }
  private void heapify() {
    for (int i = size / 2 - 1 ; i >= 0; i--) {
      percolateDown(i);
    }
  }
  public int update (int index, int ele) {
    if (index < 0 || index > size - 1) {
      throw new ArrayIndexOutOfBoundsException("Invalid index range") ;
    }
    int result = array[index] ;
    array[index] = ele ;
    if (result > ele) {
      percolateUp(index);
    } else {
      percolateDown(index);
    }
    return result ;
  }




}
