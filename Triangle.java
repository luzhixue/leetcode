public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle.size() == 0) return 0;
        int[] minPath = new int[triangle.size()];
        for(ArrayList<Integer> list:triangle){
            int leftPath = minPath[0];
            int rightPath = minPath[0];
            for(int i = 0; i < list.size(); i++){
                minPath[i] = Math.min(leftPath+list.get(i), rightPath+list.get(i));
                leftPath = rightPath;
                rightPath = (i+1>=list.size()-1)?leftPath:minPath[i+1];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int len:minPath){
            min = Math.min(len,min);
        }
        return min;
    }
}
