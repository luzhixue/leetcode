public class Solution {
    public int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int cur = 0;
        while(cur < str.length() && str.charAt(cur) == ' '){
            ++cur;
        }
        if(cur == str.length()) return 0;
        int sign = 1;//sign = -1 means negative and sign = 1 means positive
        if(str.charAt(cur) == '+'){
            sign = 1;
            ++cur;
        }
        else if(str.charAt(cur) == '-'){
            sign = -1;
            ++cur;
        }
        long val = 0;
        while(cur < str.length() && numericChar(str.charAt(cur))){
            int number = str.charAt(cur) - '0';
            val = val * 10 + number;
            if(sign == -1 && val > Integer.MAX_VALUE){
                return Integer.MIN_VALUE;
            }
            if(sign == 1 && val >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            ++cur;
        }
        return (int)val*sign;
    }
    
    private boolean numericChar(char c){
        return (c >= '0' && c <= '9');
    }
    
}
