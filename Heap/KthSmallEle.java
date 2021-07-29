package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallEle {

  public int kthSmallest(int[][] matrix, int k) {
    // Write your solution here
    PriorityQueue<Cell> minHeap = new PriorityQueue<>( k, new Comparator<Cell>() {
      @Override
      public int compare(Cell o1, Cell o2) {
        if (o1.value == o2.value) {
          return 0;
        }
        return o1.value < o2.value ? -1 : 1 ;
      }
    }) ;


    int rows = matrix.length ;
    int cols = matrix[0].length ;
    boolean[][] visited = new boolean[rows][cols] ;


    minHeap.offer( new Cell(0,0, matrix[0][0]) ) ;
    visited[0][0] = true ;
    int result = 0;
    while ( !minHeap.isEmpty() && k > 0 ) {
      Cell p = minHeap.poll() ;
      result = p.value ;
      k-- ;
      if (p.row + 1 <= rows - 1 && !visited[p.row + 1 ][p.col] ) {
        minHeap.offer(new Cell(p.row + 1, p.col, matrix[p.row + 1][p.col] ) ) ;
        visited[p.row + 1 ][p.col] = true;
      }
      if ( p.col + 1 <= cols - 1 && !visited[p.row  ][p.col + 1] ) {
        minHeap.offer(new Cell(p.row, p.col + 1, matrix[p.row][p.col + 1] ) ) ;
        visited[p.row][p.col + 1] = true;
      }
    }
    return result ;
  }

  static class Cell {

    public Cell(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }

    int row ;
    int col ;
    int value ;


  }
}
