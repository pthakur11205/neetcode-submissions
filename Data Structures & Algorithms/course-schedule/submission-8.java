class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int n=0; n < numCourses; n++) {
            map.put(n, new ArrayList<>());
        }

        for(int[] p: prerequisites) {
            map.get(p[0]).add(p[1]);
        }

        for(int c=0; c < numCourses; c++) {
            if(!dfs(c)) return false;
        }

        return true;
    }

    private boolean dfs(int c) {
        if(visited.contains(c)) return false;

        if(map.get(c).isEmpty()) return true;

        visited.add(c);
        for(int pre: map.get(c)) {
            if(!dfs(pre)) return false;
        }
        visited.remove(c);
        map.put(c, new ArrayList<>());
        return true;
    }
}
