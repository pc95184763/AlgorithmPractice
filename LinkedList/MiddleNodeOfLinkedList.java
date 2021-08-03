package LinkedList;

public class MiddleNodeOfLinkedList {

  public ListNode middleNode(ListNode head) {
    // Write your solution here
    if (head == null) {
      return null ;
    }
    ListNode fast = head ;
    ListNode slow = head ;
    while ( fast != null && fast.next != null && fast.next.next != null ) {
      slow = slow.next ;
      fast = fast.next.next ;
    }
    return slow;
  }
}
