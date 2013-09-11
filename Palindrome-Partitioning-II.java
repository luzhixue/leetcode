public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return 0;
        boolean[][] isPal = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            cut[i] = i;//at least i cuts
            for(int j = i; j >= 0; j--){
                if(j == i)
                    isPal[i][j] = true;
                else if(j == i-1)
                    isPal[i][j] = s.substring(j,j+1).equals(s.substring(i,i+1));
                else
                    isPal[i][j] = s.substring(j,j+1).equals(s.substring(i,i+1)) && isPal[i-1][j+1];
                if(isPal[i][j]){
                    if(j-1 < 0)
                        cut[i] = 0;
                    else
                        cut[i] = (cut[j-1]+1 < cut[i])? cut[j-1]+1:cut[i];
                }
            }
        }
        return cut[s.length()-1];
    }
}
