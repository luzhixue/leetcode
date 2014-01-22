public class Solution {
    public int sqrt(int x) {
        if(x < 0) return -1;//it is not legal
        if(x == 0 || x == 1) return x;
        int min = 1, max = x/2, mid = min + (max-min)/2, ret = mid;
        while(min <= max){
            if(mid == x/mid){
                ret = mid;
                break;
            }
            else if(mid > x/mid){
                max = mid - 1;
            }
            else{
                ret = mid;
                min = ret + 1;
            }
            mid = min + (max-min)/2;
        }
        return ret;
    }
}
