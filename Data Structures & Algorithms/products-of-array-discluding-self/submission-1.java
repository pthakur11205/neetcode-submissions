class Solution {
    public int[] productExceptSelf(int[] nums) {
            // Keep track of prefix and postfix
            // multiply nums[i]'s prefix and postfix to
            //  get the output number

            // but you can actually compute these values and store
            //  in the output array
            // Pass through nums forward, compute each prefix and store
            // Pass through backward, compute each postfix and multiply
            // by prefix that was already stored in index

            // Example input: [1, 2, 4, 6]
            // Output after prefix pass-thru: [1*1=1, 1*1=1, 2*1=2, 4*2=8]
            // Output during postfix: [1*(24*2), 1*(6*4), 2 * (1*6), 8 * (1*1)]
            // Final output: [48, 24, 12, 8]
            
            int[] ans = new int[nums.length];
            int left = 1;
            int right = 1;
            for(int i = 0; i < nums.length; i++) {
                ans[i] = left;
                left *= nums[i];
            }
            
            // [1, 1, 2, 8]
            // [1, 1, 2, 8*1] , right = 1*6
            // [1, 1, 2*6, 8] , right = 6*4
            // [1, 1*24, 12, 8] , right = 24*2
            for(int j = nums.length-1; j>=0; j--) {
                ans[j] *= right;
                right *= nums[j];
            }
            return ans;
            
            
    }
}  
