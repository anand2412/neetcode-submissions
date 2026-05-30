class PrefixTree {
    
    Node root;
    class Node {
        Node [] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    public PrefixTree() {
        root = new Node();
         
    }

    public void insert(String word) {
        Node curr = root;
        for(int i=0; i< word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if(i == word.length() - 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i< word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            Node child = curr.children[idx];
            if(child == null) {
                return false;
            }

            if(i == word.length() - 1 && !child.eow) {
                return false;
            }

            curr = child;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i< prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            Node child = curr.children[idx];
            if(child == null) {
                return false;
            }

            curr = child;
        }
        return true;
    }
}
