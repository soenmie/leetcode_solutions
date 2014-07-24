/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        while(cur.next != null && cur.next.next != null) {
            ListNode nextNext = cur.next.next;
            cur.next.next = nextNext.next;
            nextNext.next = cur.next;
            cur.next = nextNext;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}