package QueueStackDeque;


public class StackWithList {

  ListNode head ;
  int size ;

  public void push(int data) {
    size++ ;
    ListNode tmp = new ListNode( data ) ;
    tmp.next = head ;
    head = tmp ;
  }
  public Integer pop() {
    if( head == null) {
      return null ;
    }
    size--;
    ListNode res = head ;
    head = head.next ;
    res.next = null ;
    return res.data ;
  }
  public int size () {
    return size ;
  }
  public boolean isEmpty() {
    return size == 0;
  }


}
