class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<> (
            (a,b) -> {
                int diffA = Math.abs(a-x);
                int diffB = Math.abs(b-x);

                if(diffA != diffB) {
                    return diffB- diffA;
                }

                return b-a;
            }
        );
        for(int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
            
            if(pq.size() > k) {
                pq.poll();
            }
            
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        Collections.sort(res);

        return res;
    }
}