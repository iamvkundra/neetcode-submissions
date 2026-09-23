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
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next !=  null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        return next;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode getMiddleNode = reverse(getMiddle(head));

        ListNode temp = new ListNode(0);
        ListNode ans = temp;

        while(head != null && getMiddleNode != null) {
            ans.next = head;
            ans = ans.next;
            head = head.next;

            ans.next = getMiddleNode;
            getMiddleNode = getMiddleNode.next;
            ans = ans.next;
        }

        if (head != null) {
            ans.next = head;
        }
        if (getMiddleNode != null) {
            ans.next = getMiddleNode;
        }

        head = temp.next;
    }
}
