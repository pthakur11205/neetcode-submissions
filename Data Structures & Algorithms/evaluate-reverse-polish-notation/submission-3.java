class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> helper = new Stack<>();
        for(String token: tokens) {
            if(token.equals("+")) {
                helper.push(helper.pop()+helper.pop());
            } else if(token.equals("-")) {
                int a = helper.pop();
                int b = helper.pop();
                helper.push(b-a);
            } else if(token.equals("*")) {
                helper.push(helper.pop()*helper.pop());
            } else if(token.equals("/")) {
                int a = helper.pop();
                int b = helper.pop();
                helper.push(b/a);
            } else { 
                helper.push(Integer.parseInt(token));
            }
        }
        return helper.pop();
    }
}
