class MyHashSet {

    private List<Integer>[] buckets;
    private int size = 1000;

    public MyHashSet() {
        buckets = new LinkedList[size];
        for(int i=0; i<size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        if(!contains(key)) buckets[hash(key)].add(key);
    }
    
    public void remove(int key) {
        if(contains(key)) buckets[hash(key)].remove((Integer)key);
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */