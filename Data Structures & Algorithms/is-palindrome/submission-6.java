class Solution {
    public boolean isPalindrome(String s) {
        int i = s.length()-1;
        int j = 0;
        while (j < i) {
            while(!Character.isLetterOrDigit(s.charAt(i)) && j < i) {
                i--;
            }
            while(!Character.isLetterOrDigit(s.charAt(j)) && j < i) {
                j++;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            j++;
            i--;

        }
        return true;
    }
}
