class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String token: tokens) {
            if(token.equals("+")) {
                int a = s.pop();
                int b = s.pop();
                s.push(a+b);
            } else if(token.equals("-")){
                int a = s.pop();
                int b = s.pop();
                s.push(b-a);
            } else if(token.equals("*")){
                int a = s.pop();
                int b = s.pop();
                s.push(a*b);
            } else if(token.equals("/")){
                int a = s.pop();
                int b = s.pop();
                s.push(b/a);
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}
