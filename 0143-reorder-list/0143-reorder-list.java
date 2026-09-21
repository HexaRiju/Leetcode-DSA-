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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, p = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        p = slow.next;
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        slow.next = null;
        slow = head;
        while(!stack.isEmpty()){
            ListNode k = slow.next;
            ListNode a = stack.pop();
            a.next = k;
            slow.next = a;
            slow = k;
        }
    }
}