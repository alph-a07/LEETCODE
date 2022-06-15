

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

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        
        int size = 1;
        ListNode counter = head;
        while (counter.next != null) {
            size++;
            counter = counter.next;
        }

        for (int i = 0; i < k % size; i++) {
            ListNode pointer = head;
            while (pointer.next.next != null) {
                pointer = pointer.next;
            }
            ListNode newHead = pointer.next;
            newHead.next = head;
            head = newHead;
            pointer.next = null;
        }

        return head;
    }
}
