package BinarySearch;

public class KthSmallestInTwoSortedArrays {

  public static void main(String [] args) {

    int[] a = new int[] {1,2,3,4} ;
    int[] b = new int[] {5} ;
    int k = kth(a, b , 0,0, 5) ;
    System.out.println(k);

  }
  private static int kth (int[] a, int [] b, int aLeft, int bLeft, int k) {
    if ( aLeft >= a.length) {
      return b[bLeft + k - 1] ;
    }
    if ( bLeft >= b.length) {
      return a[aLeft + k -1] ;
    }
    if (k == 1 ) {
      return Math.min( a[aLeft] , b[bLeft]) ;
    }
    int aMid = aLeft + k / 2 - 1;
    int bMid = bLeft + k / 2 - 1;

    int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid] ;
    int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid] ;

    if (aVal < bVal) {
      return kth(a, b, aMid + 1, bLeft, k - k / 2 ) ;
    } else {
      return kth(a, b, aLeft, bMid + 1, k - k / 2 ) ;
    }
  }
}
