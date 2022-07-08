
class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.val);
        ListNode pointer = head.next;

        while (pointer != null) {
            ListNode temp = new ListNode(pointer.val);
            temp.next = newHead;
            newHead = temp;
            pointer = pointer.next;
        }
        return newHead;
    }
}

/*class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}*/
