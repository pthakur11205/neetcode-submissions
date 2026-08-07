class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int[] pre: prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for(int crs=0; crs < numCourses; crs++) {
            if(!dfs(crs)) return false;
        }

        return true;
    }

    private boolean dfs(int crs) {
        if(map.get(crs).isEmpty()) {
            return true;
        }
        if(visited.contains(crs)) {
            return false;
        }
        visited.add(crs);
        for(int pre: map.get(crs)) {
            if(!dfs(pre)) return false;
        }
        visited.remove(crs);
        map.put(crs, new ArrayList<>());
        return true;
    }
}
