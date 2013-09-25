public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S == null || T == null) return 0;
        if(T.length() == 0) return 1;
        if(S.length() == 0) return 0;
        int[][] numSub = new int[S.length()][T.length()];
        for(int i = 0; i < T.length(); i++){
            for(int j = 0; j < S.length(); j++){
                if(!T.substring(i,i+1).equals(S.substring(j,j+1))){
                    numSub[j][i] = (j-1<0)?0:numSub[j-1][i];
                }
                else{
                    int sub1 = (i-1<0)?1:0;//the substring (0,i) is empty
                    sub1 = (j-1<0 && i-1>=0)?0:sub1;
                    numSub[j][i] = ((j-1>=0 && i-1>=0)?numSub[j-1][i-1]:sub1) + ((j-1<0)?0:numSub[j-1][i]);
                }
            }
        }
        return numSub[S.length()-1][T.length()-1];
    }
}

//The code could be improved: we do not need S.length()*T.length() so much space.
//Line 15, 16, 6, 7, could be saved if we define S.length()+1 array, and assign 1 to it.
//The transitive function is f(i, j) = f(i - 1, j) + S[i] == T[j]? f(i - 1, j - 1) : 0 Where f(i, j) is the number of distinct sub-sequence for T[0:j] in S[0:i]
//We can use O(T) space since the ith-iteration only depends on the i-1th iteration and when we calculate from f(i, j) to f(i, 0) for the ith iteration.
