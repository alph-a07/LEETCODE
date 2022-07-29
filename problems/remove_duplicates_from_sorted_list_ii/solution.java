/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;

        ListNode p = head;
        ListNode q = dummy;

        while (p!=null&& p.next != null) {
            if (p.val != p.next.val) {
                q = q.next;
            } else {
                int tmp = p.val;
                while (p!=null && p.val == tmp) {
                    p = p.next;
                }
                
                if (p!=null&&p.next != null && p.val == p.next.val)
                    continue;
                
                q.next = p;
                q = p;
            }
            
            if(q==null)
                break;
            
            p = p.next;
        }
        return dummy.next;
    }
}