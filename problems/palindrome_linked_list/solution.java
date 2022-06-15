
import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        int size = 1;
        ListNode counter = head;
        while (counter.next != null) {
            size++;
            counter = counter.next;
        }

        if (size == 2 && !(head.val == head.next.val))
            return false;

        if (size == 1)
            return true;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }

        if (size % 2 == 1)
            head = head.next;

        while (!stack.isEmpty()) {
            if (stack.pop() == head.val)
                head = head.next;
            else
                return false;
        }
        return true;
    }
}
