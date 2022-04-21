class Solution {
    public void reorderList(ListNode head) {
        // base condition
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middle(head); // middle node for second half
        ListNode hf = head;
        ListNode hs = reverse(mid); // second half of list with reverse
        while (hf != null && hs != null) {
            // assign second list element to first list and update it to next using temp.
            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;
            // same as above.
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        // first half may be not null, so we check for it and make it null to it next.
        if (hf != null) {
            hf.next = null;
        }
    }

    // Reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode aft = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = aft;
            if (aft != null) {
                aft = aft.next;
            }
        }
        head = pre;
        return head;
    }

    // Finding middle node
    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}