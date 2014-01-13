//It is better to do it with an int[] array.
// int[] ret = new int[num1.length()+num2.length()];
//finally, convert back from the array to String
//http://gongxuns.blogspot.com/2013/01/leetcode-multiply-strings.html
//http://discuss.leetcode.com/questions/221/multiply-strings


public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return null;
        String ret = "0";//init to 0
        int len1 = num1.length();
        for(int i = 0; i < len1; i++){
            int curDigit = num1.charAt(len1 - 1 - i) - '0';
            for(int j = 0; j < curDigit; j++){
                ret = add(ret, num2, i);
            }
        }
        return ret;
    }
    
    private String add(String exist, String toAdd, int shift){
        StringBuilder sb = new StringBuilder();
        int len1 = exist.length(), len2 = toAdd.length();
        for(int i = 0; i < shift; i++){
            sb.insert(0, (len1-1-i >= 0)?exist.charAt(len1-1-i):'0');
        }
        int pre = 0;
        for(int i = shift; i < Math.max(len1, len2+shift); i++){
            char a = (len1 - 1 - i >= 0)?exist.charAt(len1 - 1 - i):'0';
            char b =  (len2 -1 - i + shift >= 0)?toAdd.charAt(len2-1-i+shift):'0';
            int curV = addOneDigit(a,b) + pre;
            pre = curV / 10;
            curV = curV % 10;
            sb.insert(0,Character.toChars('0'+curV));  //use the insert method to make sure the significant bit on the left
        }
        if (pre > 0)
            sb.insert(0,Character.toChars('0'+pre));
        while(sb.length() > 1 && sb.charAt(0) == '0') //delete the 0s at the beginning
        	sb.delete(0,1);
        return sb.toString();
    }
    
    private int addOneDigit(char a, char b){
        int n1 = a - '0', n2 = b - '0';
        return n1 + n2;
    }
}
