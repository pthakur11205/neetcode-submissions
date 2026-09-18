class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            in[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < numCourses; i++) {
            if(in[i]==0) q.add(i);
        }

        int finish = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[numCourses-finish-1] = cur;
            for(int i: adj.get(cur)) {
                in[i]--;
                if(in[i]==0) q.offer(i);
            }
            finish++;
        }

        if(finish != numCourses) return new int[0];
        return res;
    }
}
