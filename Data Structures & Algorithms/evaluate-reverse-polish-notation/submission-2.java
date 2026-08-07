class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> helper = new Stack<>();
        for(String str: tokens) {
            if(str.equals("+")) {
                int a = helper.pop();
                int b = helper.pop();
                helper.push(b+a);
            } else if(str.equals("-")) {
                int a = helper.pop();
                int b = helper.pop();
                helper.push(b-a);
            } else if(str.equals("*")) {
                int a = helper.pop();
                int b = helper.pop();
                helper.push(b*a);
            } else if(str.equals("/")) {
                int a = helper.pop();
                int b = helper.pop();
                helper.push(b/a);
            } else {
                helper.push(Integer.parseInt(str));
            }
        }
        return helper.pop();
    }
}
