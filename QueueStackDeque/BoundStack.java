package QueueStackDeque;

public class BoundStack {
  int[] array ;
  int head ;

  public BoundStack (int cap ) {
    array = new int[cap] ;
    head = 0 ;
  }
  public boolean push(int data) {
    if ( isFull() ) {
      return false ;
    }
    array[head++] = data ;
    return true ;
  }
  public Integer pop() {
    if (isEmpty() ) {
      return null ;
    }
    return array[--head] ;
  }


  public int size() {
    return head ;
  }
  public boolean isEmpty() {
    return head == 0;
  }
  public boolean isFull() {
    return head == array.length ;
  }

}
