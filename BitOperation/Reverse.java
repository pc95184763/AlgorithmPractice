package BitOperation;

public class Reverse {

  public static void main(String[] args)
  {
    System.out.println(reverseBits( 253)) ;
  }
  public static long reverseBits(long n) {
    // Write your solution here

    int left = 31;
    int right = 0;

    while (left > right) {
      n =  swapPairs(n, left, right);
      right++;
      left--;
    }
    return n;
  }

  public static long swapPairs(long num, int left, int right) {
    long leftBit = (num >> left) & 1;
    long rightBit = (num >> right) & 1;
    if (leftBit != rightBit) {
      num ^= (1L << left) | (1L << right) ;
    }
    return num ;
  }




}
