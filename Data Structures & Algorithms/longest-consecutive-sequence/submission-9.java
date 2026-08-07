class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> numeros = new HashSet<>();
        for(int num: nums) {
            numeros.add(num);
        }
        int length = 0;
        for(int n: numeros) {
            if(!numeros.contains(n-1)) {
                length = 1;
                while(numeros.contains(n+length)) {
                    length++;
                }
                res = Math.max(res, length);
            } 
            
        }
        return res;
    }
}
