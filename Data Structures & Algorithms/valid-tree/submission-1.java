class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        for(int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        if(!dfs(0, -1)) return false;

        return visited.size() == n;
    }

    private boolean dfs(int node, int prev) {
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int nei: map.get(node)) {
            if(nei==prev) continue;
            if(!dfs(nei, node)) return false;
        }
        return true;
    }
}
