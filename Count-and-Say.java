//iterative solution:

public class Solution {
    public String countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n <= 0) return "";
        if(n == 1) return "1";
        String curStr = "1";
        for(int i = 2; i <= n; i++){
            int curIdx = 0, count = 1;
            StringBuilder sb = new StringBuilder();
            while(curIdx < curStr.length()){
                if(curIdx + 1 < curStr.length() && curStr.charAt(curIdx+1) == curStr.charAt(curIdx)){
                    ++curIdx;
                    count += 1;
                }
                else{
                    sb.append(String.valueOf(count));
                    sb.append(curStr.charAt(curIdx));
                    ++curIdx;
                    count = 1;
                }
            }
            curStr = sb.toString();
        }
        return curStr;
    }
}



//recursive solution: more space

public class Solution {
    public String countAndSay(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(n <= 0) return "";
        if(n == 1) return "1";
        String subStr = countAndSay(n-1);
        //String str = "";
        StringBuilder sb = new StringBuilder();
        int curIdx = 0, count = 1;
        while(curIdx < subStr.length()){
            if(curIdx + 1 < subStr.length() && subStr.charAt(curIdx+1) == subStr.charAt(curIdx)){
                ++curIdx;
                count += 1;
            }
            else{
                sb.append(String.valueOf(count));
                sb.append(subStr.charAt(curIdx));
                ++curIdx;
                count = 1;
            }
        }
        return sb.toString();
        
    }
}
