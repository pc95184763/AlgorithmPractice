package CrossTraining4;

public class KthSmallestInTwo {


  public static void main(String[] args) {
      int[] a = {1,3,5,7,9} ;
      int[] b = {2,4,6,8};

      System.out.println( kth(a,b, 6)) ;
  }
  public static int kth(int[] a, int[] b, int k) {
    // Write your solution here
    return kth(a, 0, b, 0, k);

  }

  private static int kth(int[] a, int aLeft, int [] b, int bLeft ,int k) {
    if (aLeft >= a.length) {
      return b[bLeft + k - 1] ;
    }
    if (bLeft >= b.length) {
      return a[aLeft + k - 1] ;
    }
    if (k == 1) {
      return Math.min(a[aLeft], b[bLeft]);
    }
    int amid = aLeft + k / 2 - 1;
    int bmid = bLeft + k / 2 - 1;

    if (a[amid] < b[bmid]) {
      return kth(a, amid  + 1, b, bLeft, k / 2) ;
    } else {
      return kth(a, aLeft, b, bmid  + 1, k / 2) ;
    }
  }
}
