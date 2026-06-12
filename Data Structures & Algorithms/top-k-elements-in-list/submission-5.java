class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length <= k) return nums;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }
        return result;
    }
}
