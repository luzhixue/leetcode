//get the lowest and highest digits, and compare
public class Solution {
    public boolean isPalindrome(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(x < 0) return false;
        if(x < 10) return true;
        int divs = 1;
        while(x/divs >= 10)
            divs *= 10;
        while(x >= 10){
            int high = x/divs;
            int low = x%10;
            if(high != low) return false;
            x = x/10;
            divs = divs/10;
            x = x%divs;
            divs = divs/10;
        }
        return true;
    }
}
