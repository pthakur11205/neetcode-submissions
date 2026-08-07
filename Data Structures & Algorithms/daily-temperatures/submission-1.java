class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> helper = new Stack<>();
        for(int i = temperatures.length - 1; i >= 0; i--) {
            while(!helper.isEmpty() && temperatures[i] >= temperatures[helper.peek()]) {
                helper.pop();
            }

            if(!helper.isEmpty()) {
                result[i] = helper.peek() - i;
            }

            helper.push(i);
        }
        return result;
    }
}
