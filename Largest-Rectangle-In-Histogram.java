public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //use stack to hold elements that have not found a right boundary (no element on right smaller than it, yet)
        //if the right boundary is found, pop and calculate the area
        if(height.length == 0) return 0;
        Stack<Integer> leftBounds = new Stack<Integer>(); 
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            if(leftBounds.empty() || height[leftBounds.peek()] <= height[i]){
                leftBounds.push(i);
            }
            else{
                while(!leftBounds.empty() && height[leftBounds.peek()] > height[i]){
                    int idx = leftBounds.pop();
                    int width = leftBounds.empty()?i:(i-leftBounds.peek()-1);
                    maxArea = Math.max(maxArea, width*height[idx]);
                }
                leftBounds.push(i);
            }
        }
        while(!leftBounds.empty()){
            int idx = leftBounds.pop();
            int width = leftBounds.empty()?height.length:(height.length-leftBounds.peek()-1);
            maxArea = Math.max(maxArea, width*height[idx]);
        }
        return maxArea;
        
    }
}  







//The following is a n^2 solution that originally came to me.
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length==0) return 0;
        int[][] smallest = new int[height.length][height.length];
        for(int i = 0; i < height.length; i++){
            for(int j = 0; j <= i; j++){
                if(j==i){
                    smallest[i][j] = height[i];
                    break;
                } 
                smallest[i][j] = Math.min(smallest[i-1][j],height[i]);
            }
        }
        
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++){
            for(int j = 0; j <=i; j++){
                maxArea = Math.max(maxArea,(i-j+1)*smallest[i][j]);
            }
        }
        return maxArea;
        
    }
}
