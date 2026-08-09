class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> values = map.get(key);
        int l = 0;
        int r = values.size()-1;
        String res = "";
        while(l<=r) {
            int m = l + (r-l)/2;
            if(values.get(m).timestamp <= timestamp) {
                res = values.get(m).val;
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return res;
    }

    private static class Pair {
        int timestamp;
        String val;

        Pair(int t, String v) {
            timestamp = t;
            val = v;
        }
    }
}
