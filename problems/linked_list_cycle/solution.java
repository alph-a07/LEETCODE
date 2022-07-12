
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // \U0001f4a1: Slow will iterate through each node while fast will go next and next
    // \U0001f4a1: At some point if cycle is present slow and fast will collide at its starting point
    public boolean hasCycle(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = head;

        while (slow != null) {

            // 10000: Maximum possible number of nodes
            for (int i = 0; i <= 10000; i++) {

                // cycle detected
                if (slow == fast)
                    return true;

                // if there is a cycle fast can never be null
                if (fast == null)
                    return false;

                fast = fast.next;
            }
            fast = slow;
            slow = slow.next;
        }
        return false;
    }
}
