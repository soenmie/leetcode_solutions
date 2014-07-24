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
    public ListNode mergeKLists(List<ListNode> lists) {
        int n = lists.size();
        if (n == 0) { return null; }
        PriorityQueue<Node> q = new PriorityQueue<Node>(n, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                return n1.length - n2.length;
            }
        });
        for (ListNode l : lists) {
            if (l != null) {
                int len = getLen(l);
                q.offer(new Node(l, len));
            }
        }
        while (q.size() >= 2) {
            Node n1 = q.poll();
            Node n2 = q.poll();
            ListNode l = merge(n1.ln, n2.ln);
            q.offer(new Node(l, n1.length + n2.length));
        }
        if (q.isEmpty()) { return null; }
        return q.poll().ln;
    }
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) { cur.next = l2; }
        if (l2 == null) { cur.next = l1; }
        return dummy.next;
    }
    private int getLen(ListNode l) {
        int i = 0;
        while (l != null) {
            ++i;
            l = l.next;
        }
        return i;
    }
}
class Node {
    ListNode ln;
    int length;
    public Node(ListNode ln, int length) {
        this.ln = ln;
        this.length = length;
    }
}