public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //Using BFS to construct a tree from start to end, save the tree with HashMap<parent, list of children>
        //Then, using DFS to print all the paths. Note the push/pop stack-style DFS printing.
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        if(start == null || end == null || start.length() == 0) return paths;
        if(start.equals(end)){
            ArrayList<String> list = new ArrayList<String>();
            list.add(start);
            paths.add(list);
            return paths;
        }
        HashMap<String, ArrayList<String>> nextHop = new HashMap<String, ArrayList<String>>();
        ArrayList<String> curLevel = new ArrayList<String>();
        curLevel.add(start);
        boolean find = false;
        while(curLevel.size()>0){
            ArrayList<String> nextLevel = new ArrayList<String>();
            for(String word:curLevel)//create an entry for all the nodes in this level
                nextHop.put(word, new ArrayList<String>());
            for(String word:curLevel){
                ArrayList<String> nextWords = nextHop.get(word);
                for(int i = 0; i < word.length(); i++){
                    StringBuffer sb = new StringBuffer(word);
                    String newWord;                    
                    char ch = 'a';
                    while(ch <= 'z'){
                        sb.setCharAt(i,ch);
                        newWord = sb.toString();
                        if(newWord.equals(end)){
                            find = true;
                            nextWords.add(newWord);
                         }
                        else if(!nextHop.containsKey(newWord) && dict.contains(newWord)) { //in the dict && not an ancestor/sibling node
                            nextWords.add(newWord);
                            if(!nextLevel.contains(newWord)) nextLevel.add(newWord);//using if to void duplicate keywords in the same level
                        }
                        ch += 1;
                    }
                }

            }
            if(find) break;
            curLevel = nextLevel;
        }
        
        ArrayList<String> curPath = new ArrayList<String>();
        DFS(paths, start, end, nextHop, curPath);
        return paths;
   
    }
    
    private void DFS(ArrayList<ArrayList<String>> paths, String curWord, String end,  HashMap<String, ArrayList<String>> nextHop, ArrayList<String> curPath){
        if(curWord.equals(end)){
            curPath.add(curWord);
            paths.add((ArrayList<String>)curPath.clone());
            curPath.remove(curPath.size()-1);//Note: need to pop the keyword in DFS
            return;
        }
        else{
            ArrayList<String> nextWords = nextHop.get(curWord);
            if(nextWords == null || nextWords.size() == 0) return;
            curPath.add(curWord);
            for(String newWord: nextWords)
                DFS(paths, newWord, end, nextHop, curPath);
            curPath.remove(curPath.size()-1);//Note: need to pop the keyword in DFS
        }
    }
}
