public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> row = new ArrayList<Integer>();
        if(rowIndex < 0) return row;
        for(int i = 0; i <= rowIndex; i++){
            int left = 0, right = 1, j = 0;
            do{
                if(j<i)
                    row.set(j, left+right);
                else
                    row.add(left+right);
                ++j;
                left = right;
                right = (j>=i)?0:row.get(j);
            }while(j<=i);
        }
        return row;
    }
}
