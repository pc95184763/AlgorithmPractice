package LinkedList;

public class CycleChecked {

  public boolean hasCycle(ListNode head) {
    // write your solution here
    if (head == null || head.next == null ) {
      return false ;
    }

    ListNode fast = head ;
    ListNode slow = head ;
    while ( fast != null && fast.next != null  ) {
      slow = slow.next ;
      fast = fast.next.next ;
      if ( slow == fast) {
        return true ;
      }
    }
    return false;
  }
}
