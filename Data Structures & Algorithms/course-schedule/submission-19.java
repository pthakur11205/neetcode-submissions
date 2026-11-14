class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            in[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i < numCourses; i++) {
            if(in[i]==0) q.add(i);
        }

        int finish = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            finish++;
            for(int nei: adj.get(cur)) {
                in[nei]--;
                if(in[nei]==0) q.add(nei);
            }
        }

        return finish==numCourses;
         
    }
}
