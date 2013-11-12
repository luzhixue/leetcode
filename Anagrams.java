//we can sort each string, and use the sorted result as the key in hash table
//or we can create a labeled statistics of each array:  "aab"-->a2b1
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> anaList = new ArrayList<String>();
        if(strs == null || strs.length <= 1) return anaList;
        HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ArrayList<String> res = map.get(key);
            if(res == null){
                res = new ArrayList<String>();
                map.put(key, res);
            }
            res.add(str);
        }
        for(ArrayList<String> list: map.values()){
            if(list.size()>1)
                anaList.addAll(list);
        }
        return anaList;
    }
}
