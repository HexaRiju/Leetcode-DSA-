/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node q = head, newHead = null, prev = null;
        while(q != null){
            Node curr = new Node(q.val);
            if(newHead == null){
                newHead = curr;
                prev = curr;
            }
            else{
                prev.next = curr;
                prev = curr;
            }
            map.put(q, curr);
            q = q.next;
        }
        for(Node node : map.keySet()){
            if(node.random == null)
                map.get(node).random = null;
            else{
                map.get(node).random = map.get(node.random);
            }
        }
        return newHead;
    }
}