class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c: tasks) {
            count[c-'A']++;
        }

        PriorityQueue<Integer> mh = new PriorityQueue<>(Collections.reverseOrder());
        for(int cnt: count) {
            if(cnt>0) mh.offer(cnt);
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!mh.isEmpty() || !q.isEmpty()) {
            time++;

            if(mh.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = mh.poll()-1;
                if(cnt > 0) q.offer(new int[]{cnt, time+n});
            }

            if(!q.isEmpty() && q.peek()[1] == time) mh.offer(q.poll()[0]);
        }
        return time;
    }
}
