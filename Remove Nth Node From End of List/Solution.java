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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head, ptr = head;
        int i = 0;
        while(i < n) {
            p = p.next;
            i++;
        }
        if (p == null) {
            return ptr.next;
        }
        p = p.next;
        while(p != null) {
            q = q.next;
            p = p.next;
        }
        q.next = q.next.next;
        return ptr;
    }
}