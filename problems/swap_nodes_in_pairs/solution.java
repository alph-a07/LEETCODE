
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next == null)
            return head;
        
        ListNode p2 = head.next;
        ListNode p3 = p2.next;

        head.next = p3;
        p2.next = head;

        if (head.next != null)
            head.next = swapPairs(p3);

        return p2;
    }
}
