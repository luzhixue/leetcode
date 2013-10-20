public class Solution {
    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        long res = 0;
        while(x != 0){
            res = res * 10 + x%10;
            x = x/10;
        }
        return (int)res;
    }
}
