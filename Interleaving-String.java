//dynamic programming problem

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s1 == null && s2 == null && s3 == null) return true;
        if(s1 == null || s1.length() == 0) return s2.equals(s3);
        if(s2 == null || s2.length() == 0) return s1.equals(s3);
        if(s1.length() + s2.length() != s3.length()) return false;
        //if string s1 with length i and s2 with length j interleaves s3 (with length i+j)
        boolean[][] inter = new boolean[s1.length()+1][s2.length()+1];
        for(int i = 0; i < s1.length(); i++){
            inter[i+1][0] = (s1.charAt(i) == s3.charAt(i));
        }
        for(int j = 0; j < s2.length(); j++){
            inter[0][j+1] = (s2.charAt(j) == s3.charAt(j));
        }
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                inter[i+1][j+1] = (s1.charAt(i) == s3.charAt(i+j+1) && inter[i][j+1] || s2.charAt(j) == s3.charAt(i+j+1) && inter[i+1][j]);
            }
        }
        return inter[s1.length()][s2.length()];
    }
}


//Recursive Solution: expensive, 
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s1 == null && s2 == null && s3 == null) return true;
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;//do not forget string length of 0
        if(s3 == null || s3.length() == 0) return false;
        if(s1 == null || s1.length() == 0) return s2.equals(s3);
        if(s2 == null || s2.length() == 0) return s1.equals(s3);
        if(s3.substring(0,1).equals(s1.substring(0,1))){
            if(s3.substring(0,1).equals(s2.substring(0,1))){
                return isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1));
            }
            else{
                return isInterleave(s1.substring(1), s2, s3.substring(1));
            }
        }
        if(s3.substring(0,1).equals(s2.substring(0,1))){
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return false;
    }
}
