class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        }
        
        for(int n: hand) {
            int start = n;
            while(map.getOrDefault(start-1, 0) > 0) start--;
            while(start <= n) {
                while(map.getOrDefault(start, 0) > 0) {
                    for(int i=start; i < start+groupSize; i++) {
                        if(map.getOrDefault(i, 0) == 0) return false;

                        map.put(i, map.get(i)-1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
