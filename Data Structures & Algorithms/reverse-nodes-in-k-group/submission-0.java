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
    private ListNode tempHead;
    private ListNode tempTail;

    private ListNode originalHead;
    private ListNode originalTail;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        int length = getLength(head);

        while(length >= k) {
            int tempK = k;
            while (tempK-- > 0) {
                ListNode next = current.next;
                current.next = null;
                add(current);
                current = next;
            }

            if (originalHead == null) {
                originalHead = tempHead;
                originalTail = tempTail;
            } else {
                originalTail.next = tempHead;
                originalTail = tempTail;
            }
            tempHead = null;
            tempTail = null;

            length -=k;
        }

        originalTail.next = current;
        return originalHead;
    }

    private void add(ListNode node) {
        if (tempHead == null) {
            tempHead = node;
            tempTail = node;
        } else {
            node.next = tempHead;
            tempHead = node;
        }
    }

    private int getLength(ListNode head) {
        int counter = 0;
        while(head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }
}
