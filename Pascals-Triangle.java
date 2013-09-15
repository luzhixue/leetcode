public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0) return tri;
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            tri.add(row);
            int left = 0, right = 0;
            for(int j = 0; j <= i; j++){
                left = right;
                if(i!=0){
                    right = (j==i)?0:tri.get(i-1).get(j);
                }
                else{
                    right = 1;
                }
                row.add(left+right);
            }
        }
        return tri;
    }
}
