public class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return true;
        int i = 0, j = s.length()-1;
        while(i<s.length() && !isAlphaNum(s.charAt(i))) i++;
        while(j>=0 && !isAlphaNum(s.charAt(j))) j--;
        while(i <= j){
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            else{
                ++i;
                --j;
            }
            while(i<s.length() && !isAlphaNum(s.charAt(i))) i++;
            while(j>=0 && !isAlphaNum(s.charAt(j))) j--;
        }
        return true;
    }
    
    private boolean isAlphaNum(char c){
        return (('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || ('A' <= c && c <='Z'));
    }
}
