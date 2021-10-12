package LinkedList;

public class RotateListByKplaces {

  public static void main(String[] args) {
      ListNode L1 = new ListNode(1) ;
    ListNode L2 = new ListNode(2) ;
    ListNode L3 = new ListNode(3) ;
    ListNode L4 = new ListNode(4) ;
    ListNode L5 = new ListNode(5) ;
    L1.next = L2 ;
    L2.next = L3 ;
    L3.next = L4 ;
    L4.next = L5 ;

    ListNode result = rotateKplace(L1, 2) ;
    while ( result != null) {
        System.out.println(result.value) ;
        result = result.next ;
    }
  }


  public static ListNode rotateKplace(ListNode head, int n) {
    // Write your solution here
    int count = 0;
    ListNode cur = head ;
    while ( cur != null ) {
      count++ ;
      cur = cur.next ;
    }
    n = n % count ;
    int left = count - n ;
    ListNode mid = findKthElement(head, left) ;
    ListNode right = mid.next ;
    mid.next = null ;
    right.next = head ;
    return right ;
  }
  //find the num-th number in the LinkedList head
  private static ListNode findKthElement(ListNode head, int num) {

    while ( num > 1) {
      head = head.next ;
      num--;
    }
    return head ;
  }
}
