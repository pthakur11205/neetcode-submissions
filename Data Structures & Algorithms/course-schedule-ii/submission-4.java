class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            in[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        for(int i=0; i < in.length; i++) {
            if(in[i]==0) q.offer(i);
        }

        if(q.isEmpty()) return new int[0];

        int[] res = new int[numCourses];
        int finish = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[numCourses - finish - 1] = cur;
            for(int i: adj.get(cur)) {
                in[i]--;
                if(in[i] == 0) q.offer(i);
            }
            finish++;
        }

        return (finish==numCourses) ? res: new int[0];

    }
}
