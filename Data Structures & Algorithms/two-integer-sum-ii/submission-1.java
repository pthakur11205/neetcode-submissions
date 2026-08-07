class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length-1;
        int l = numbers[leftIndex];
        int r = numbers[rightIndex];

        while(l < r) {
            int sum = l + r;
            if(sum > target) {
                rightIndex--;
                r = numbers[rightIndex];
            } else if (sum < target) {
                leftIndex++;
                l = numbers[leftIndex];
            } else {
                break;
            }
        }
        return new int[]{leftIndex+1, rightIndex+1};
    }
}
