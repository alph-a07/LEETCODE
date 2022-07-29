
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        ListNode res = null;

        while (p != null) {
            p.val *= -1;
            p = p.next;
        }

        while (q != null) {
            if (q.val < 0) {
                q.val *= -1;
                res = new ListNode(q.val);
                break;
            }
            q = q.next;
        }

        p = headA;
        while (p != null) {
            p.val = Math.abs(p.val);
            p = p.next;
        }
        return res;
    }
}
