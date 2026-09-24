class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    private int res = 0;
    public int countComponents(int n, int[][] edges) {
        for(int i=0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i=0; i < n; i++) {
            if(!visited.contains(i)) {
                res++;
                dfs(i);
            } 
        }

        return res;
    }

    private void dfs(int node) {
        if(visited.contains(node)) return;
        visited.add(node);
        for(int nei: adj.get(node)) {
            dfs(nei);
        }
    }
}
