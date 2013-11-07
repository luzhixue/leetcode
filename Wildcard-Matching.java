//DP, construct a n*m matrix
//could be optimized by using only one row (size n): i.e., consider String s and move pointer on String p m times

public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null || p == null) return false;
        int count = 0;  
        for (Character c : p.toCharArray()) {
            if (c != '*') ++count;
        }  
        // the count should not be larger than that of s  
        if (count > s.length()) return false;  
        
        
        int len1 = s.length(), len2 = p.length();
        boolean[][] match = new boolean[len1+1][len2+1];//if s of size i matches p of size j
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0){//first string is empty
                    if(j == 0){//second is also empty
                        match[i][j] = true;
                        continue;
                    }
                    char c2 = p.charAt(len2-j);//get the character of second string
                    match[i][j] = (match[i][j-1] && (c2 == '*'));
                }
                else{
                    char c1 = s.charAt(len1-i);//char of s
                    if(j == 0){//second is empty
                        match[i][j] = false;
                        continue;
                    }
                    char c2 = p.charAt(len2-j);
                    if(c1 == c2 || c2 == '?'){
                        match[i][j] = match[i-1][j-1];
                    }
                    else if(c1 != c2 && c2 != '*'){
                        match[i][j] = false;
                    }
                    else if(c2 == '*'){
                        for(int k = i; k >= 0; k--){
                            if(match[k][j-1]){
                                match[i][j] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return match[len1][len2];
    }
}
