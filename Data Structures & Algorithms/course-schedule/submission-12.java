class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for(int[] pre: prerequisites) {
            preMap.get(pre[0]).add(pre[1]);
        }
        for(int c=0; c < numCourses; c++) {
            if(!dfs(c)) return false;
        }
        return true;
    }

    private boolean dfs(int c) {
        if(visited.contains(c)) return false;
        if(preMap.get(c).isEmpty()) return true;
        visited.add(c);
        for(int nei: preMap.get(c)) {
            if(!dfs(nei)) return false;
        }
        visited.remove(c);
        preMap.put(c, new ArrayList<>());
        return true;
    }
}
