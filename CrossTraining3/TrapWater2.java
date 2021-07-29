package CrossTraining3;

import java.util.*;
import java.util.List;
import java.util.PriorityQueue;

public class TrapWater2 {

  public static void main(String[] args) {

    int[][] matrix = { { 5,8,7,7},

        { 5,2,1,5 },

        { 7,1,7,1 },
        {8,9,6,9},
        {9,8,9,9}
    } ;
    System.out.println(maxTrapped(matrix) ) ;
  }

  public static int maxTrapped(int[][] matrix) {
    int rows = matrix.length ;
    int cols = matrix[0].length ;

    if (rows < 3 || cols < 3) {
      return 0;
    }

    PriorityQueue<Pair> minHeap = new PriorityQueue<Pair> () ;

    boolean[][] visited = new boolean[rows][cols] ;
    processBorder(matrix, visited, minHeap, rows, cols) ;
    int result = 0;
    while(!minHeap.isEmpty() ) {
      Pair cur = minHeap.poll() ;
      List<Pair> neighbors = allNeighbors(cur, matrix, visited) ;
      for (Pair nei: neighbors) {
        if (visited[nei.x][nei.y] ) {
          continue ;
        }
        visited[nei.x][nei.y] = true;
        result += Math.max( cur.height - nei.height , 0) ;
        nei.height = Math.max(cur.height, nei.height) ;
        minHeap.offer(nei) ;
      }

    }
    return result ;

  }

  private static void processBorder(int[][] matrix, boolean [][] visited,
      PriorityQueue<Pair> minHeap, int rows, int cols) {

    for (int j = 0 ; j < cols; j++) {
      minHeap.offer(new Pair(0, j, matrix[0][j] ) ) ;
      minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j] ) ) ;
      visited[0][j] = true ;
      visited[rows - 1][j] = true ;

    }
    for (int i = 1 ; i < rows - 1 ; i ++) {
      minHeap.offer(new Pair(i, 0, matrix[i][0] ) ) ;
      minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1] ) ) ;
      visited[i][0] = true ;
      visited[i][cols - 1] = true ;
    }

  }

  private static List<Pair> allNeighbors (Pair cur, int[][] matrix, boolean[][] visited) {
    List<Pair> neis = new ArrayList<>() ;
    if (cur.x + 1 < matrix.length) {
      neis.add(new Pair(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y] ) );
    }
    if (cur.x - 1 >= 0) {
      neis.add(new Pair(cur.x - 1, cur.y, matrix[cur.x - 1][cur.y] ) );
    }
    if (cur.y + 1 < matrix[0].length) {
      neis.add(new Pair(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1] ) );
    }
    if (cur.y - 1 >= 0) {
      neis.add(new Pair(cur.x , cur.y - 1, matrix[cur.x][cur.y - 1] ) );
    }
    return neis ;
  }


  static class Pair implements Comparable<Pair> {
    int x ;
    int y ;
    int height ;

    Pair(int x, int y, int height) {
      this.x = x ;
      this.y = y ;
      this.height = height ;
    }
    public int compareTo(Pair another) {
      if (this.height == another.height ) {
        return 0;
      }
      return this.height < another.height ? -1 : 1;
    }
  }
}
