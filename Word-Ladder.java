public class Solution {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(dict.isEmpty()) return 0;
		if(start.equals(end)) return 0;
		HashSet<String> searched = new HashSet<String>();
		ArrayList<String> curList = new ArrayList<String>();
		curList.add(start);
		searched.add(start);
		int step = 1;
		while(curList.size()>0){
			step++;
			ArrayList<String> nextList = new ArrayList<String>();
			for(String word: curList){
				for(int k = 0; k < word.length(); k++){
				StringBuffer sb = new StringBuffer(word);//faster
				char newCh = 'a';
					while(newCh <= 'z'){
					//String newWord = word.substring(0,k) + String.valueOf(newCh) + word.substring(k+1);
						sb.setCharAt(k, newCh);
						String newWord = sb.toString();
		    	     			if(newWord.equals(end))	return step;
						if (dict.contains(newWord) && !searched.contains(newWord)){
							nextList.add(newWord);
							searched.add(newWord);
						}        
						newCh += 1;
					}
				}
			}
			curList = nextList;
		}
		return 0;
    }
}
