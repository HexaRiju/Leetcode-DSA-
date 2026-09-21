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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode r = head;
        int count = 0;
        if(head == null)
            return null;
        if(n == 1){
            while(r.next != null && r.next.next != null)
                r = r.next;
            if(r.next == null)
                return null;
            r.next = null;
            return head;
        }
        while(r != null){
            count++;
            r = r.next;
        }
        r = head;
        ListNode r1 = null;
        int i = 0;
        while(count - i != n){
            r1 = r;
            r = r.next;
            i++;
        }
        ListNode t = r.next;
        r.next = null;
        if(r1 == null){
            head = t;
            return head;
        }
        r1.next = t;
        return head;
    }
}