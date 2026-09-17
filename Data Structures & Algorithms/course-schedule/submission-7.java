class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visit = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites) {
            map.get(p[0]).add(p[1]);
        }

        for(int c=0; c < numCourses; c++) {
            if(!dfs(c)) return false;
        }

        return true;
    }

    private boolean dfs(int course) {
        if(visit.contains(course)) return false;
        if(map.get(course).isEmpty()) return true;
        visit.add(course);
        for(int pre: map.get(course)) {
            if(!dfs(pre)) return false;
        }
        visit.remove(course);
        map.put(course, new ArrayList<>());
        return true;
    }
}
