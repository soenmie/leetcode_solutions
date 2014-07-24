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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLen(head);
        int n = len / k;
        ListNode headPtr = new ListNode(0);
        headPtr.next = head;
        ListNode ptr = headPtr;
        ListNode cur = head;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < k; j++) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = ptr.next;
                ptr.next = next;
            }
            ptr = cur;
            cur = ptr.next;
        }
        return headPtr.next;
    }
    
    private int getLen(ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}