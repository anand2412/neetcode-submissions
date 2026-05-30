class WordDictionary {
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

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, Node node) {
        Node curr = node;
        for(int i=j; i< word.length(); i++) {
            if(word.charAt(i)== '.') {
                for (Node child : curr.children) {
                    if(i == word.length() - 1 && child != null && !child.eow) {
                       return false;
                    }
                    if(child != null && dfs(word, i+1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null) {
                    return false;
                }
                if(i == word.length() - 1 && !curr.children[idx].eow) {
                    return false;
                }
                curr = curr.children[idx];
            }
        }
        return true;
    }
}
