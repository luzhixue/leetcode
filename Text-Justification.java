//for each line, need to count the number of words, and gaps (between words) separately, with the number of gap being at least one (line 34)
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> ret = new ArrayList<String>();
        if(words == null || words.length == 0 || L <= 0){
            ret.add("");
            return ret;  
        } 
        int curStart = 0, curEnd = 0;
	while(curStart < words.length ){//not ended
		int totalLen = words[curStart].length();//the length of current line
		int numGaps = 0;
		while(curEnd + 1 < words.length && totalLen + numGaps + 1 + words[curEnd+1].length() <= L){
			curEnd += 1;
			totalLen += words[curEnd].length();//move the end of word
			numGaps += 1;
		}
		if(curEnd + 1 == words.length){//we are done!
			StringBuilder sb = new StringBuilder();
			for(int i = curStart; i <= curEnd; i++){
				sb.append(words[i]);
				if(i != curEnd)
				sb.append(" ");
			}
			for(int i = totalLen + numGaps + 1; i <= L; i++)
				sb.append(" ");//append space at the end
			ret.add(sb.toString());
			break;
		}
		else{//not finished yet
			int totalSpace = L - totalLen;
			int gaps = Math.max(1, numGaps);//at least 1 gap
			int spacePerGap = totalSpace/(gaps);
			int remainSpace = totalSpace%(gaps);
			StringBuilder sb = new StringBuilder();
			for(int i = curStart; i <= curEnd; i++){
				sb.append(words[i]);
				if(i != curEnd || (i == curEnd && curEnd == curStart)){//not the last word, or there is only one word
					int numSpace = spacePerGap + ((i - curStart + 1 <= remainSpace)?1:0);//how many spaces do we need to insert
					for(int j = 0; j < numSpace; j++)
						sb.append(" ");
				}
			}
	              ret.add(sb.toString());
		}
		curStart = curEnd + 1;
		curEnd = curStart;
	}
	return ret;
    }
}
