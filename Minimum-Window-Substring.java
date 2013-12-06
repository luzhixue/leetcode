//Using two HashMap, one stores the original characters in T, the other stores the characters in the current windows of S

public class Solution {
    public String minWindow(String S, String T) {
        if(S == null || T == null || S.length() == 0 || T.length()== 0) return "";
        //the characters need to be find with a given number
        HashMap<Character, Integer> needFound = new HashMap<Character, Integer>();
        //the characters have been found in the current window, store the number
        HashMap<Character, Integer> hasFound = new HashMap<Character,Integer>();
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(!needFound.containsKey(c)){
                needFound.put(c, 1);
                hasFound.put(c, 0);
            }
            else{
                needFound.put(c, needFound.get(c)+1);
            }
        }
        int start = 0, match = 0;
        int minWindowStart = -1, minWindowEnd = -1;
        for(int end = 0; end < S.length(); end++){
            char c = S.charAt(end);
            //T does not contain c
            if(!needFound.containsKey(c))
                continue;
            hasFound.put(c, hasFound.get(c)+1);//found one more c
            if(hasFound.get(c) <= needFound.get(c)){//the one we just find (c) is not redundant
                ++match;//we find a new match
            }
            if(match == T.length()){//we have found all the characters
                //now try to move the start position of the window while make sure the number of matches is still met
                while(start <= end){
                    char ch = S.charAt(start);
                    if(!needFound.containsKey(ch)){//not a character in T
                        ++start;
                        continue;
                    }
                    if(needFound.get(ch) < hasFound.get(ch)){//still has enough redundant characters
                        ++start;
                        hasFound.put(ch, hasFound.get(ch)-1);
                        continue;
                    }
                    break;//the current character ch is not redundant, cannot move start any more
                }
                if(minWindowStart == -1 || minWindowEnd-minWindowStart > end-start){
                    minWindowStart = start;
                    minWindowEnd = end;
                }
            }

        }
        
        return (minWindowStart == -1)?"":S.substring(minWindowStart, minWindowEnd+1);
     }
}
