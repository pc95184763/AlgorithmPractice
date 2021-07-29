package MyTest;

public class ChainTest {
//        "abc"
//    /     |      \
//  "abc"  "bac"     "cba"


  // "abc" "cd"
  public static void main(String [] args) {
    ChainTest solution = new ChainTest() ;
    String[] arr = new String[] {"abc", "bac" ,"cawdbyawidb","anubrigbb"} ;
    System.out.println( solution.isChained(arr) ) ;
  }


  boolean isChained(String[] arr) {
    StringBuilder buf = new StringBuilder() ;
    boolean[] flag = new boolean[]{false} ;
    DFS( flag,0 ,arr) ;
    return flag[0] ;
  }
  boolean valid(String[] arr) {

    for (int i = 0 ; i < arr.length - 1 ; i ++) {
      if (arr[i].charAt(arr[i].length() - 1) != arr[i + 1].charAt(0)) {
        return false;
      }
    }
    return true ;
  }


  void DFS( boolean[] flag, int index, String[] arr ) {
    if ( index == arr.length) {
      if ( valid(arr) ) {
        flag[0] = true ;
      }
      return ;
    }

    for (int i = index; i < arr.length ; i++) {
      swap(arr, i, index) ;
      DFS( flag,index + 1, arr) ;
      swap(arr, i, index) ;
    }
  }


  void swap(String[] array, int i , int j) {
      String s = array[i] ;
      array[i] = array[j] ;
      array[j] = s ;
  }
}
