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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int carry = 0;
        ListNode head = null;
        ListNode prior = null;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            ListNode cur = new ListNode(val);
            if (prior == null) {
                head = cur;
            }
            else {
                prior.next = cur;
            }
            prior = cur;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest;
        if (l1 == null) {
            rest = l2;
        }
        else {
            rest = l1;
        }
        if (rest == null) {
            if (carry == 0) {
                return head;
            }
            prior.next = new ListNode(carry);
            return head;            
        }
         while (rest != null && carry != 0){
            int sum = rest.val + carry;           
            int val = sum % 10;
            ListNode cur = new ListNode(val);
            prior.next = cur;
            prior = cur;
            carry = sum / 10;    
            rest = rest.next;
        }
        if (carry == 0) {
            prior.next = rest;
            return head;
        }
        prior.next = new ListNode(carry);
        return head;
    }
}