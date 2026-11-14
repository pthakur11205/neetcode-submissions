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
        for(int i=0; i < numCourses; i++) {
            if(in[i]==0) q.offer(i);
        }

        int[] res = new int[numCourses];
        int finish = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[numCourses-finish-1] = cur;
            for(int nei: adj.get(cur)) {
                in[nei]--;
                if(in[nei]==0) q.offer(nei);
            }
            finish++;
        }

        return (finish==numCourses) ? res: new int[0];

    }
}
