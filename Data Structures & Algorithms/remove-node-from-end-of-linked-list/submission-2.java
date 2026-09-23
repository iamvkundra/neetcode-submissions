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
    private int getLength(ListNode head) {
        int counter = 0;
        while(head != null) {
            head = head.next;
            counter++;
        }
        return counter;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
    
        ListNode ans = head;
        int length = getLength(head);
        int deletedNoded = length - n;

        ListNode prev = null;
        while(deletedNoded-- > 0) {
            prev = ans;
            ans = ans.next;
        }
        if (prev == null) {
            return ans.next;
        }
        prev.next = ans.next;
        return head;
    }
}
