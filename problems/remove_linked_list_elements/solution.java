
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(-1);
        start.next = head;

        ListNode pointer = start;

        while (pointer != null) {
            if (pointer.next != null && pointer.next.val == val) {
                ListNode temp = pointer.next;
                while (temp != null && temp.val == val)
                    temp = temp.next;

                pointer.next = temp;
            }
            pointer = pointer.next;
        }
        return start.next;
    }
}
