class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i <= n; i++) {
            while(!stack.isEmpty() && (i==n || heights[stack.peek()] >= heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i: i - stack.peek() - 1;
                res = Math.max(res, (height*width));
            }
            stack.push(i);
        }
        return res;
    }
}
