class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> twee = new TreeSet<>();
        for(Integer i: nums) {
            twee.add(i);
        }

        int sequence = 1;
        int max = 0;
        for(Integer j: twee) {
            if(twee.contains(j+1)) {
                sequence++;
            } else {
                if(sequence > max) {
                    max = sequence;
                }
                sequence=1;
            }
        }

    return max;

    }
}
