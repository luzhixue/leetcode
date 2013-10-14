//Iterative Solution
public class Solution {
    public int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(digits == null || digits.length == 0){
            int[] res = {1};
            return res;
        }
        int curDigit = digits.length - 1;
        int resCurDigit = digits[curDigit] + 1;
        while(resCurDigit == 10 && curDigit > 0){
            digits[curDigit] = 0;
            --curDigit;
            resCurDigit = digits[curDigit] + 1;
        }
        if(resCurDigit < 10){
            digits[curDigit] = resCurDigit;
            return digits;
        }
        else{
            digits[0] = 0;
            return increaseOneDigit(digits);
        }
    }
    
    private int[] increaseOneDigit(int[] digits){
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int i = 0; i < digits.length; i++){
            newDigits[i+1] = digits[i];
        }
        return newDigits;
    }
}




//Recursively add one
public class Solution {
    public int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(digits == null || digits.length == 0){
            int[] res = {1};
            return res;
        }
        return plusOneAtIdx(digits, digits.length-1);
    }
    
    
    private int[] plusOneAtIdx(int[] digits, int idx){
        if(idx < 0){
            return increaseOneDigit(digits);
        }
        if(digits[idx] == 9){
            digits[idx] = 0;
            return plusOneAtIdx(digits, idx-1);
        }
        else{
            digits[idx] += 1;
            return digits;
        }
    }
    
    private int[] increaseOneDigit(int[] digits){
        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(int i = 0; i < digits.length; i++){
            newDigits[i+1] = digits[i];
        }
        return newDigits;
    }
}
