/**
 *  Definition for singly-linked list.
 *  class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode(int x) {
 *          val = x;
 *          next = null;
 *      }
 *  }
 *  hasCycle1: Time Limit Exceeded
 */
public class LinkedListCycle {
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        int i = 2;
        ListNode end = head.next;
        while (end != null) {
            ListNode current = head;
            for (int j = 0; j < i-1; j++) {
                if (current == end) {
                    return true;
                }
                current = current.next;
            }
            end = end.next;
            i++;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        int i = 0;
        while (current != null && current.next != null) {
            if (prev == current) {
                return true;
            }

            if (current.val >= current.next.val) {
                prev = current;
            }
            current.val = i;
            current = current.next;
            i++;
        }
        return false;
    }
}
