public class IntersectionOfTwoLinkedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (first != null && second != null) {
            first = first.next;
            second = second.next;
        }
        
        if (first == null) {
            while (second != null) {
                headB = headB.next;
                second = second.next;
            }
        } else {
            while (first != null) {
                headA = headA.next;
                first = first.next;
            }
        }
        
        while (headA != null) {
            if (headB == headA) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
