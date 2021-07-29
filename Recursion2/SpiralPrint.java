package Recursion2;

import MyUtil.PrintUtil;
import java.util.*;

public class SpiralPrint {

  public static void main(String[] args) {
    int[][] array = new int[5 ][] ;
    for (int i = 0 ; i < array.length ; i ++) {
      array[i] =new int[5] ;
    }
    spiralPrint(array,0, 5, 0) ;
//    PrintUtil.print(array) ;

    List<Integer> result = spiral(array) ;
    for (int i : result) {
      System.out.print(i + " ") ;
    }
  }




  public static void spiralPrint(int[] [] a, int offset, int size, int counter ) {
    if (size <=1 ) {
      if (size == 1) {
        a[offset][offset] = counter ;
      }
      //PrintUtil.print(a) ;
      return ;
    }
    for (int i = 0 ; i < size - 1 ; i ++) {
      a[ offset] [i + offset] = counter ++ ;
    }
    for (int i = 0 ; i < size - 1; i ++) {
      a[i + offset][ size - 1 + offset] = counter++ ;
    }
    for (int i = size - 1 ; i >= 1; i--) {
      a [size - 1 + offset] [offset + i] = counter++ ;
    }
    for (int i = size - 1 ; i >= 1; i--) {
      a[offset + i] [offset] = counter++ ;
    }

    spiralPrint(a, offset + 1 , size - 2, counter) ;
  }

  public static List<Integer> spiral(int[][] matrix) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    traverse(matrix, 0, matrix.length, result) ;
    return result;
  }

  public static void traverse(int[][] matrix, int offset, int size , List<Integer> result) {
    if ( size == 0) {
      return ;
    }
    if ( size == 1) {
      result.add( matrix[offset][offset] );
      return ;
    }
    for (int i = 0 ; i < size - 1 ; i ++) {
      result.add(matrix[offset][offset + i]) ;
    }
    for (int i = 0 ;  i < size - 1 ; i ++) {
      result.add( matrix[offset + i][ size - 1 + offset] ) ;
    }
    for ( int i = size - 1 ; i >=1 ; i--) {
      result.add( matrix[size - 1 + offset][ offset + i]) ;
    }
    for ( int i = size - 1; i >= 1; i--) {
      result.add( matrix[offset + i][ offset]) ;
    }
    traverse(matrix, offset + 1, size - 2, result) ;

  }



}
