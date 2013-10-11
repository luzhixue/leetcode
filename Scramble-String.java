public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        //if s1(i-->j) is a scramble of s2(k, k+(j-i)) of same length;
        boolean[][][] scramble = new boolean[s1.length()][s2.length()][s2.length()];

        for(int i = 0; i < s1.length(); i++){
            for(int k = 0; k < s2.length(); k++){
                scramble[i][i][k] = (s1.charAt(i) == s2.charAt(k));
            }
        }
        
        for(int subLen = 2; subLen <= s1.length(); subLen++){
            for(int i = 0; i <= s1.length() - subLen; i++){
                int j = i + subLen -1;
                for(int k = 0; k <= s2.length() - subLen; k++){
                    for(int cut = i+1; cut <= j; cut++){
                    	if(scramble[i][j][k]) break;//do not forget this break
                        scramble[i][j][k] = scramble[i][cut-1][k] && scramble[cut][j][k+cut-i];
                        if(!scramble[i][j][k]){
                            scramble[i][j][k] = scramble[i][cut-1][k+j-cut+1] && scramble[cut][j][k];
                        }
                    }
                }
            }
        }
        return scramble[0][s1.length()-1][0];
        
    }
}
