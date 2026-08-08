class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);

        int l = 0, r = list.size() - 1;
        String res = "";

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (list.get(m).timestamp <= timestamp) {
                res = list.get(m).value; // valid candidate
                l = m + 1;              // try to find a later one
            } else {
                r = m - 1;
            }
        }

        return res;
    }

    private static class Pair {
        int timestamp;
        String value;

        Pair(int t, String v) {
            timestamp = t;
            value = v;
        }
    }
}