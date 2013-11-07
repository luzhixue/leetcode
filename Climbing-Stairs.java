public class Solution {
    public int climbStairs(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n <= 0) return 0;
        if(n == 1 || n == 2) return n;
        int prepre = 1, pre = 2, cur = 0;
        for(int i = 3; i <= n; i++){
            cur = prepre + pre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
