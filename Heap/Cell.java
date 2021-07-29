package Heap;

import java.util.*;

public class Cell implements Comparable<Cell> {
  public int row ;
  public int col ;
  public int value ;

  @Override
  public int compareTo(Cell e) {
    if (this.value == e.value) {
      return 0 ;
    }
    return this.value < e.value? -1 : 1;
  }



  public Cell(int row, int col, int value ) {
    this.row = row ;
    this.col = col ;
    this.value = value ;
  }


  public static void main(String[] args) {
    PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>( Collections.reverseOrder() ) ;
    PriorityQueue<Cell> testMin = new PriorityQueue<Cell> (new Comparator<Cell> () {
      public int compare(Cell o1, Cell o2) {
        if (o1.value == o2.value) {
          return 0 ;
        }
        return o1.value < o2.value? -1 : 1;
      }

    } );

    Cell c1 = new Cell(0,0,0) ;
    Cell c2 = new Cell(0,1,2) ;

    minHeap.offer(c1) ;
    minHeap.offer(c2) ;

    while (!minHeap.isEmpty() ) {
      System.out.println(minHeap.poll().value );
    }
  }



}

class MyComparetor implements Comparator<Cell> {


  @Override
  public int compare(Cell o1, Cell o2) {
    if (o1.value == o2.value) {
      return 0 ;
    }
    return o1.value < o2.value? 1 : -1 ;
  }

}

