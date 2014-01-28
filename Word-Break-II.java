//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//Return all such possible sentences.
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//A solution is ["cats and dog", "cat sand dog"].


public class Solution {
	HashMap<Integer, ArrayList<String>> hist = new HashMap<Integer, ArrayList<String>>();
	
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
    	ArrayList<String> ret = new ArrayList<String>();
    	if(s == null || dict == null || s.length() == 0) return ret;
    	ret = wordBreakHelper(s, 0, dict);
    	return ret;
    } 
    
    
    private ArrayList<String> wordBreakHelper(String s, int idx, Set<String> dict){
    	ArrayList<String> ret = new ArrayList<String>();
    	if(idx >= s.length()){
    		ret.add("");
    		return ret;
    	}
    	if(hist.containsKey(idx))
    		return hist.get(idx);
    	for(int i = idx; i < s.length(); i++){
    		String sub = s.substring(idx, i+1);
    		if(dict.contains(sub)){
    			ArrayList<String> subRet = wordBreakHelper(s, i+1, dict);
    			for(String ss : subRet){
    				String spc = (ss.length()==0)?"":" ";
    				ret.add(sub+spc+ss);
    			}
    		}
    	}
    	hist.put(idx, ret);
    	return ret;
    }
}
