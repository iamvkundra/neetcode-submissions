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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length-1);
    }

    private ListNode solve(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int middle = (start + end)/2;
        ListNode left = solve(lists, start, middle);
        ListNode right = solve(lists, middle+1, end);

        return merge(left, right);
    }
    private ListNode merge(ListNode first, ListNode second) {
        ListNode temp = new ListNode(0);
        ListNode ans = temp;
        while(first != null && second != null) {
            if (first.val <= second.val) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }

        if(first != null) {
            temp.next = first;
        }
        if (second != null) {
            temp.next = second;
        }
        return ans.next;
    }
}
