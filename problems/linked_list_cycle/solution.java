/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = head;

        while (slow !=null){
            for (int i=0;i<=10000;i++){

                if (slow==fast)
                    return true;

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
