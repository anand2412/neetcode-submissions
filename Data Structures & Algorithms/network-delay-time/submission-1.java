class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
           adj.add(new ArrayList<>());
        }

        for(int[] time : times) {
           int u = time[0];
           int v = time[1];
           int w = time[2];

           adj.get(u).add(new int[]{v, w});
        }

        int [] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], node = curr[1];

            if(d > dist[node]) continue;

            for(int [] neigbour : adj.get(node)) {
                int newDist = dist[node] + neigbour[1];
                if(newDist < dist[neigbour[0]]) {
                    dist[neigbour[0]] = newDist;
                    pq.offer(new int[]{newDist, neigbour[0]});
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {

        if(dist[i] == Integer.MAX_VALUE) {
            return -1;
        }

        ans = Math.max(ans, dist[i]);
    }

    return ans;
    }
}
