package BitOperation;

public class NumOfDifferentBit {
  public int diffBits(int a, int b) {
    // Write your solution here
    int c = a ^ b ;
    int count = 0;

    for ( int i = 0 ; i <= 31 ; i ++) {
      count += ( c >> i ) & 1;
    }

    return count ;
  }

  public int diffBits1(int a, int b) {

    a ^= b ;
    int count = 0;
    while ( a != 0 ) {
      count += a & 1;
      a >>>= 1 ;
    }
    return count;

  }

  public int diffBits2(int a, int b) {
    // Write your solution here
    int count = 0;
    for ( int c = a ^ b ; c != 0 ; c >>>= 1 ) {
      count +=  c  & 1 ;
    }
    return count;
  }
}
