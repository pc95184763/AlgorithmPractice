package LinkedList;

public class CheckPalindrom {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1) ;
    ListNode l2 = new ListNode(1) ;
    l1.next = l2;
    System.out.println(isPalindrome(l1));
  }

  public static boolean isPalindrome( ListNode head) {
    // Write your solution here
    if ( head == null || head.next == null) {
      return true ;
    }
    ListNode mid = findMid(head) ;
    ListNode last = reverse(mid) ;
    while ( head != mid) {
      if ( head.value != last.value ) {
        return false ;
      }
      head = head.next ;
      last = last.next ;
    }
    return head == last ;
  }
  public static ListNode findMid( ListNode head) {
    ListNode fast = head ;
    ListNode slow = head ;
    while ( fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next ;
      fast = fast.next.next ;
    }
    return slow ;
  }

  public static ListNode reverse( ListNode head) {
    ListNode pre = null ;
    while (head != null) {
      ListNode nxt = head.next ;
      head.next = pre ;
      pre = head ;
      head = nxt ;
    }
    return pre ;
  }
}
