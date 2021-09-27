package RecursionAndSorting;

import java.util.*;

public class Quick {

  public static void main(String []args) {
    int[ ]arr = new int[] {-500, -500, -498, -497, -496, 100,101, 88, -10} ;
    arr = quickSort(arr) ;
    for (int i : arr) {
      System.out.println(i) ;
    }
  }

  public static int[] quickSort(int[] array) {
    // Write your solution here
    if (array == null || array.length == 0) {
      return array ;
    }
    Random rand = new Random() ;
    quickSort(array, rand, 0, array.length - 1) ;
    return array ;
  }

  private static void quickSort(int[] array, Random rand, int left, int right) {
    if (left >= right) {
      return ;
    }
    int pivot = left + rand.nextInt( right - left + 1) ;
    sort(array, pivot, left, right) ;
    quickSort(array, rand, left, pivot - 1) ;
    quickSort(array, rand, pivot + 1, right) ;

  }

  private static void sort(int[] array, int pivot, int left, int right) {

    swap(array, pivot, right) ;
    int i = left ;
    int j = right - 1;
    while ( i <= j) {
      if ( array[i] <= array[right]) {
        i++ ;
      }
      else {
        swap(array, i, j--);
      }
    }
    swap(array, i, right) ;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i] ;
    array[i] = array[j] ;
    array[j] = temp ;
  }



}
