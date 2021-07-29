package Recursion2;

public class reverseLinkedList {

  public static void main(String[] args) {
    ListNode dummy = new ListNode(-1) ;
    ListNode head =dummy;
    for(int i = 1; i < 6; i ++) {
      head.next = new ListNode(i) ;
      head = head.next ;
    }
    dummy = reverseInPairs(dummy.next) ;
    while (dummy != null) {
      System.out.print( dummy.value+" ");
      dummy = dummy.next ;
    }

  }


  static ListNode  reverseInPairs(ListNode head) {
    if ( head == null || head.next == null ) {
      return head;
    }

    head.next = reverseInPairs(head.next.next) ;
    ListNode next = head.next ;

    next.next = head ;



    return next;
  }

}




class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}
