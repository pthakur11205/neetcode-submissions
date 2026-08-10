class TimeMap {

    private Map<String, List<Pair>> cache;

    public TimeMap() {
        cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        cache.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!cache.containsKey(key)) return "";
        List<Pair> values = cache.get(key);
        String res = "";
        int l=0, r=values.size()-1;
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
