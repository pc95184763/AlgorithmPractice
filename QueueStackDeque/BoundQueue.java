package QueueStackDeque;

public class BoundQueue {
  private int head ;
  private int tail ;
  int size ;
  int[] array ;

  public BoundQueue(int cap) {
    array = new int[cap] ;
  }

  public boolean offer(int data) {
    if ( isFull() ) {
      return false;
    }
    size++ ;
    array[tail] = data ;
    tail = (tail + 1) % array.length ;
    return true ;
  }

  public Integer poll() {
    if ( isEmpty() ) {
      return null ;
    }
    int res = array[head] ;
    head = (head + 1) % array.length ;
    size--;
    return res ;
  }



  public boolean isFull() {
    return size == array.length ;
  }
  public boolean isEmpty() {
    return size == 0;
  }
}
