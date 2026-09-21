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
    ListNode node = null, head = null, q = null;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                create(list1);
                list1 = list1.next;
            }
            else{ 
                create(list2);
                list2 = list2.next;
            }
        }
        while(list1 != null){
            create(list1);
            list1 = list1.next;
        }
        while(list2 != null){
            create(list2);
            list2 = list2.next;
        }
        return head;
    }

    public void create(ListNode list){
        if(head == null){
            q = list;
            head = q;
        }
        else{
            q.next = list;
            q = q.next;
        }
    }
}