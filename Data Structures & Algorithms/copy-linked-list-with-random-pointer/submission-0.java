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
       HashMap<Node, Node> map = new HashMap<>();
       Node curr = head;

       while(curr != null) {
        Node temp = new Node(curr.val);
        map.put(curr, temp);
        curr = curr.next;
       }

       curr = head;

       while(curr != null) {
        Node copyNode = map.get(curr);
        copyNode.next = map.get(curr.next);
        copyNode.random = map.get(curr.random);
        curr = curr.next;
       }

       return map.get(head);
    }
}
