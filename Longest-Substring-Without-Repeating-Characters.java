//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
//For "bbbbb" the longest substring is "b", with the length of 1.

//Solution: use a sliding window, and keep a hashtable of characters in the window

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> curSet = new HashSet<Character>();
        int max = 0, start = 0, len = 0;
        for(int i = start; i < s.length(); i++){
            char cur = s.charAt(i);
            if(!curSet.contains(cur)){
                curSet.add(cur);
                ++len;
                max = Math.max(max, len);
                continue;
            }
            char fst;
            do{
                fst = s.charAt(start);
                curSet.remove(fst);
                ++start;
                --len;
            }while(fst != cur);
            curSet.add(cur);
            ++len;
        }
        return max;
    }
}
