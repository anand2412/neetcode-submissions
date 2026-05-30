class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int n = intervals.length;
        LinkedList<int[]> res = new LinkedList<>();

        res.add(intervals[0]);
        for(int[] interval: intervals) {
            if(res.getLast()[1] >= interval[0]) {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
