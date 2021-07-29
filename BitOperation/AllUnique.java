package BitOperation;

public class AllUnique {

  public static void main(String[ ] args) {

    System.out.println(allUnique("bcdkowa") ) ;
  }

  public static boolean allUnique(String word) {

    char[] array = word.toCharArray() ;
    int[] base = new int[8] ;

    for (char c : array) {
      if ( (base[c / 32 ] >>> c % 32 ) != 0  ) {
        return false;
      }
      base[c / 32] |= (1 << (c % 32) ) ;
    }

    return true;
  }
}
