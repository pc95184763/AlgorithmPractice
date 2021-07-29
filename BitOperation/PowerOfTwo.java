package BitOperation;

public class PowerOfTwo {
  public boolean isPowerOfTwo(int number) {
    // Write your solution here
    if (number < 1) {
      return false;
    }
    int count = 0;
    for ( int shift = 31; shift >= 0; shift --) {
      count += ( number >> shift ) & 1;
    }
    return count == 1;
  }

  public boolean isPowerOfTwo1(int number) {

    boolean b = (number >= 1) && (number & (number - 1) ) == 0;
    return b;
  }
}
