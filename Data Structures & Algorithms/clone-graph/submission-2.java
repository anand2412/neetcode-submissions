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
        HashMap<Node, Node> graphMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        graphMap.put(node, new Node(node.val)); 

        while(!q.isEmpty()) {
            Node curr = q.poll();

            for(Node child: curr.neighbors) {
                if(!graphMap.containsKey(child)) {
                    graphMap.put(child, new Node(child.val));
                    q.add(child);
                }
                graphMap.get(curr).neighbors.add(graphMap.get(child));
            }
        }

        return graphMap.get(node);
    }
}