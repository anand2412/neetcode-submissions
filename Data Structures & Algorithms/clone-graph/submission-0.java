/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        oldToNew.put(node, new Node(node.val));

        while(!queue.isEmpty()) {
           Node currNode = queue.poll();
           for(Node child : currNode.neighbors) {
               if (!oldToNew.containsKey(child)) {
                   oldToNew.put(child, new Node(child.val));
                   queue.add(child);
                }
                oldToNew.get(currNode).neighbors.add(oldToNew.get(child));
            }
       }
       return oldToNew.get(node);
    }
}