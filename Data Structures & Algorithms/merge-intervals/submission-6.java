class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for(int[] in: intervals) {
            int start = in[0];
            int end = in[1];
            int lastEnd = res.get(res.size()-1)[1];

            if(start <= lastEnd) {
                res.get(res.size()-1)[1] = Math.max(end, lastEnd);
            } else {
                res.add(new int[]{start, end});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
