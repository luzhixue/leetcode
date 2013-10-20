//stack function  empty(), push(), pop(), peek()

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int height = matrix.length;
        int width = matrix[0].length; 
        int[] hisHeight = new int[width];
        int max = 0;
        //update the hisHeight with line i as the bottom line
        for(int i = 0; i < height; i++){//for each row
            for(int j = 0; j < width; j++){
                if(matrix[i][j] == '0')
                    hisHeight[j] = 0;
                else
                    hisHeight[j] += 1;
            }
            max = Math.max(max, maxRect(hisHeight));
        }
        return max;
    }
    
    private int maxRect(int[] hisHeight){
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int idx = 0; idx < hisHeight.length; idx++){
            if(stack.empty() || hisHeight[idx] >= hisHeight[stack.peek()]){
                stack.push(idx);
            }
            else{
                while(!stack.empty() && hisHeight[stack.peek()] > hisHeight[idx]){
                    int curIdx = stack.pop();
                    while(!stack.empty() && hisHeight[stack.peek()] == hisHeight[curIdx]){//remove elements of the same value
                        stack.pop();
                    }
                    int leftBound = (stack.empty())?-1:stack.peek();
                    int area = (idx - leftBound -1)*hisHeight[curIdx];
                    max = Math.max(max, area);
                }
                stack.push(idx);
            }
        }
        while(!stack.empty()){
            int curIdx = stack.pop();
            while(!stack.empty() && hisHeight[stack.peek()] == hisHeight[curIdx]){//remove elements of the same value
                stack.pop();
            }
            int leftBound = (stack.empty())?-1:stack.peek();
            int area = (hisHeight.length - leftBound -1)*hisHeight[curIdx];
            max = Math.max(max, area);
        }
        return max;
    }
    
    
    
}
