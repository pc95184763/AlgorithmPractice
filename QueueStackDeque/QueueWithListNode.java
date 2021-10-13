package QueueStackDeque;





public class QueueWithListNode {

  ListNode tail ;
  ListNode head ;
  int size ;


  public void offer(int data) {
    if ( tail == null) {
      tail = new ListNode(data) ;
      head = tail ;
    }
    else {
      tail.next = new ListNode(data) ;
      tail = tail.next ;
    }
    size++ ;
  }

  public ListNode poll() {
    if (head == null) {
      return null ;
    }
    ListNode res = head ;
    head = head.next ;
    if ( head == null) {
      tail = null ;
    }
    res.next = null;
    size--;
    return res ;
  }
  public int size() {
    return size ;
  }
  public boolean isEmpty() {
    return size == 0;
  }

}

