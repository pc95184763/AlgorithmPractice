package LinkedList;

public class ReverseLinkedListRecursive {

  public ListNode reverse(ListNode head) {
    // Write your solution here
    if (head == null ) {
      return null ;
    }
    if (head.next == null ) {
      return head ;
    }
    //   1 --> 2  --> 4 -->   7
    //   1 <-- 2 <-- 4 <-- 7
    ListNode nxt = head.next ;
    ListNode newHead = reverse(head.next) ;
    nxt.next = head ;
    head.next = null ;

    return newHead ;
  }
}
