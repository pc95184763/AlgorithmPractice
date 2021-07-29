package CrossTrainning2;

public class CountArray {


  public static void main(String[] args) {
      int[] arr = {4,1,3,2} ;
      arr = countArray(arr) ;
      for (int i : arr) {
        System.out.print( i+" " );
      }
  }

  public static int[] countArray(int[] array) {

    int[] indexArray = initialIndexArray(array) ;
    int[] countArray = new int[array.length] ;
    int[] helper = new int[array.length] ;

    mergeSort(array, indexArray, countArray, helper, 0 , array.length - 1) ;

    return countArray ;
  }


  private static int[] initialIndexArray(int[] array) {
    int[] indices = new int[array.length] ;
    for (int i = 0 ; i < array.length; i ++) {
      indices[i] = i ;
    }
    return indices ;
  }

  private static void mergeSort(int[] array, int[] indexArray, int[] countArray,
      int[] helper, int left, int right) {

    if (left >= right) {
      return ;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, indexArray, countArray, helper, left , mid) ;
    mergeSort(array, indexArray, countArray, helper, mid + 1 , right) ;
    merge(array, indexArray, countArray, helper, left, mid, right) ;
  }

  private static void merge (int[] array, int[] indexArray, int[] countArray, int[] helper,
      int left, int  mid, int right) {

    copyArray(indexArray, helper, left, right) ;

    int l = left ;
    int r = mid + 1;
    int cur = left ;
    //比较元素本身的大小，merge
    while (l <= mid ) {
      if ( r > right || array[ helper[l] ] <= array[ helper[r]]  ) {
        countArray[helper[l]] += (r - mid - 1) ;

        //    a{0,1}         b{0,1}
        indexArray[cur++] = helper[l++] ;
      } else {
        indexArray[cur++] = helper[r++] ;
      }
    }

  }

  private static void copyArray(int [] indexArray, int[] helper, int left, int right) {
    for (int i = left; i <= right ; i++) {
      helper[i] = indexArray[i] ;
    }
  }
}
