public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || s.length() == 0) return true;
        boolean[] breakAble = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){//for the substring ends at i
            for(int j = i-1; j >= -1; j--){
                if(dict.contains(s.substring(j+1,i+1)) && (j == -1 || breakAble[j])){
                    breakAble[i] = true;
                    break;
                }
            }
        }
        return breakAble[s.length()-1];
    }
}
