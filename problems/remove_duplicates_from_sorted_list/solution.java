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
        ListNode temp = head, list = head;

        while (temp != null) {
            if(temp.next==null){
               list.next=null;
               break;
            }
            if (temp.val != temp.next.val) {
                if (list.next != temp.next)
                    list.next = temp.next;
                list = list.next;
            }
            temp = temp.next;
        }
        return head;
    }
}