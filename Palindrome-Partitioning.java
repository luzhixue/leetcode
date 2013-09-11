public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length() == 0) return new ArrayList<ArrayList<String>>();
        boolean[][] isPal = new boolean[s.length()][s.length()];
        ArrayList<ArrayList<ArrayList<String>>> pal = new ArrayList<ArrayList<ArrayList<String>>>();
        for(int i = 0; i < s.length(); i++){//consider a sequence ends at i
            ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
            pal.add(list);
            for(int j = i; j >= 0; j--){//from j to i
                if(j == i){
                    isPal[i][j] = true;
                }
                else if(j == i-1){
                    isPal[i][j] = s.substring(j,j+1).equals(s.substring(i,i+1));
                }
                else{
                    isPal[i][j] = (s.substring(j,j+1).equals(s.substring(i,i+1)) && isPal[i-1][j+1]);
                }
                if(isPal[i][j]){
                    if(j-1 < 0){
                        ArrayList<String> str = new ArrayList<String>();
	                str.add(s.substring(j,i+1));
	                list.add(str);
                    }else{
                        for(ArrayList<String> str: pal.get(j-1)){
                            ArrayList<String> newStr = (ArrayList<String>)str.clone();
                            newStr.add(s.substring(j,i+1));
                            list.add(newStr);
                        }
                    }
                    
                }
                
            }
        }
        return pal.get(s.length()-1);
    }
}
