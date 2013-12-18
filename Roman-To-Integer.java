public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> dict = getDict();
        int ret = 0;
        int prev = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(!dict.containsKey(cur))//invalid
                return 0;
            int value = dict.get(cur);
            if(value > prev)
                ret -= 2*prev;//the previous value should be a minus
            ret += value;
            prev = value;
        }
        return ret;
    }
    
    public HashMap<Character, Integer> getDict(){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
