//We can apply greedy strategy as follows:
//We always move the shorter boundary of the two.  By moving the shorter one, we may arrive at a higher boundary so as to get a greater volume (although width decreased); it is not necessary to move the higher one since no matter if the next height is greater or smaller, it won't change the volume -- the shorter boundary is the limit for a container.

public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(height == null || height.length <= 1) return 0;
        int maxArea = 0;
        int minIdx = 0, maxIdx = height.length-1;
        while(minIdx < maxIdx){
            int curArea = (maxIdx - minIdx)*Math.min(height[minIdx],height[maxIdx]);
            if(curArea > maxArea) maxArea = curArea;
            if(height[minIdx] < height[maxIdx])
                ++minIdx;
            else
                --maxIdx;
        }
        return maxArea;
    }
}

//Prove by contradiction:
//Suppose the returned result is not the optimal solution. Then there must exist an optimal solution, say a container with a_ol and a_or (left and right respectively), such that it has a greater volume than the one we got. Since our algorithm stops only if the two pointers meet. So, we must have visited one of them but not the other.
//WLOG, let's say we visited a_ol but not a_or.
//When a pointer stops at a_ol, it won't move until
//    1. The other pointer also points to a_ol;
//    In this case, iteration ends. But the other pointer must have visited a_or on its way from right end to a_ol. Contradiction to our assumption that we didn't visit a_or.
//    2. The other pointer arrives at a value, say a_rr, that is greater than a_ol before it reaches a_or.
//    In this case, we does move a_ol. But notice that the volume of a_ol and a_rr is already greater than  a_ol and a_or (as it is wider and heigher), which means that a_ol and a_or is not the optimal solution -- Contradiction!

//Both cases arrive at a contradiction.
