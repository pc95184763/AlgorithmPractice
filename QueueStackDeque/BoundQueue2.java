package QueueStackDeque;

public class BoundQueue2 {
  private int head ;
  private int tail ;
  private int[] array ;

  public BoundQueue2(int cap) {
    head = 0;
    tail = 1;
    array = new int[cap] ;
  }

  public boolean offer(int data) {
    if ( isFull() ) {
      return false ;
    }
    array[tail] = data ;
    tail = (tail + 1) % array.length ;
    return true ;
  }

  public Integer poll() {
    if ( isEmpty() ) {
      return null ;
    }
    head = (head + 1) % array.length ;
    return array[head] ;
  }

  public boolean isFull() {
    return tail == head ;
  }
  public boolean isEmpty() {
    return (head + 1 ) % array.length == tail ;
  }
  public int size() {
    return tail - head - 1;
  }
}
