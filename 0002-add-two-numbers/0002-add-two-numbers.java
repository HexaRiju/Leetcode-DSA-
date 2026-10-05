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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int d = 0, r = 0;
        ListNode head = null, prev = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + d;
            ListNode curr = new ListNode();
            if (head == null) {
                curr.val = sum % 10;
                head = curr;
                prev = curr;
            } else {
                curr.val = sum % 10;
                prev.next = curr;
                prev = curr;
            }
            d = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + d;
            ListNode curr = new ListNode();
            curr.val = sum % 10;
            prev.next = curr;
            prev = curr;
            d = sum / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + d;
            ListNode curr = new ListNode();
            curr.val = sum % 10;
            prev.next = curr;
            prev = curr;
            d = sum / 10;
            l2 = l2.next;
        }
        if(d == 0)
            return head;
        ListNode curr = new ListNode(d);
        prev.next = curr;
        return head;
    }
}