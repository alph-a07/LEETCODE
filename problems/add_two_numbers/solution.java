
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode ans = new ListNode(-1);
        ListNode pointer = ans;
        boolean carry = false;

        while (!(pointer1 == null && pointer2 == null)) {
            ListNode temp = new ListNode();

            if (pointer1 != null) {
                temp.val += pointer1.val;
                pointer1 = pointer1.next;
            }
            if (pointer2 != null) {
                temp.val += pointer2.val;
                pointer2 = pointer2.next;
            }

            if (carry)
                temp.val += 1;

            if (temp.val > 9) {
                temp.val -= 10;
                carry = true;
            } else
                carry = false;

            pointer.next = temp;
            pointer = pointer.next;
        }
        if (carry) {
            pointer.next = new ListNode(1);
        }
        return ans.next;
    }

    private int getSize(ListNode l) {
        ListNode p = l;
        int size = 0;

        while (p != null) {
            p = p.next;
            size++;
        }
        return size;
    }
}
