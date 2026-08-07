class Solution {
    public boolean isValid(String s) {
        Stack<Character> helper = new Stack<>();
        if(s.length() == 1){
            return false;
        }
        for(Character c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                helper.push(c);
            } else {
                if(helper.isEmpty()) return false;

                char top = helper.pop();

                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
            
        
        }
        return helper.isEmpty();
    }
}
