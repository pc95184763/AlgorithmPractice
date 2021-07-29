package BFS2;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import java.util.*;

public class SevenPuzzle {

  public static void main(String[] args) {
    int[] arr = new int[] {6,7,3,5,4,2,1,0} ;
    System.out.println( numOfSteps(arr) ) ;

  }

  static class Board {
    static final int R = 2;
    static final int C = 4;
    private int[] [] board = new int[R][C] ;

    Board() {}

    Board(int[] arr) {
      for (int i = 0 ; i < R ; i++) {
        for (int j = 0 ; j < C; j++) {
          board[i][j] = arr[i * C + j] ;
        }
      }
    }
    @Override
    public int hashCode() {
      int code = 0 ;
      for (int i = 0 ; i < R; i++) {
        for (int j = 0 ; j < C ; j++) {
          code = code * 10 + board[i][j];
        }
      }
      return code ;
    }
    @Override
    public boolean equals(Object o) {
      if ( ! (o instanceof Board) ) {
        return false ;
      }
      Board b = (Board) o ;
      for (int i = 0 ; i < R; i++) {
        for (int j = 0 ; j < C ; j++) {
          if (board[i][j] != b.board[i][j] ) {
            return false;
          }
        }
      }
      return true ;
    }


    int[] findZeroIndex() {
      for (int i = 0 ; i < R ; i++) {
        for (int j = 0 ; j < C; j++) {
          if( board[i][j] == 0 ) {
            return new int[] {i , j} ;
          }
        }
      }
      return null ;
    }

    void swap(int i1, int j1, int i2, int j2) {
      int temp = board[i1][j1] ;
      board[i1][j1] = board[i2][j2] ;
      board[i2][j2] = temp ;
    }
    boolean outOfBound(int i , int j) {
      if (i < 0 || i >= R || j < 0 || j >= C) {
        return true ;
      }
      return false ;
    }
    @Override
    public Board clone() {
      Board result = new Board();
      for (int i = 0 ; i < R ; i ++) {
        for (int j = 0; j < C ; j++) {
          result.board[i][j] = board[i][j] ;
        }
      }
      return result ;
    }

  }

  final static int[][] DIRS = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}} ;


  public static int numOfSteps(int[] values) {
    // Write your solution here
    HashMap<Board, Integer> boardSteps = new HashMap<Board, Integer>() ;
    Board start = new Board(new int[] {0,1,2,3,4,5,6,7} ) ;

    Queue<Board> queue = new ArrayDeque<>() ;

    boardSteps.put(start, 0) ;
    queue.offer(start) ;

    while ( !queue.isEmpty()) {
      Board cur = queue.poll() ;
      int step = boardSteps.get(cur) ;
      int[] zeroIndex = cur.findZeroIndex() ;
      int zeroI = zeroIndex[0] ;
      int zeroJ = zeroIndex[1] ;
      for ( int [] dir : DIRS) {
        int i = zeroI + dir[0] ;
        int j = zeroJ + dir[1] ;
        if ( !cur.outOfBound(i, j) ) {
          cur.swap(zeroI, zeroJ, i , j) ;
          if ( !boardSteps.containsKey( cur) ) {
            Board newBoard = cur.clone() ;
            queue.offer(newBoard) ;
            boardSteps.put(newBoard, step + 1) ;
          }
          cur.swap(zeroI, zeroJ, i , j) ;
        }
      }
    }
    return boardSteps.getOrDefault( new Board(values) , -1) ;


  }



}
