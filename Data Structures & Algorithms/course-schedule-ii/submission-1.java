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
            if(in[i]==0) {
                q.offer(i);
            }
        }

        int finish = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()) {
            int node = q.poll();
            res[numCourses-finish-1] = node;
            finish++;
            for(int nei: adj.get(node)) {
                in[nei]--;
                if(in[nei]==0) {
                    q.add(nei);
                }
            }
        }

        if(finish != numCourses) return new int[0];
        return res;
    }
}
