public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return true;
        Stack<String> par = new Stack<String>();
        for(int i = 0; i < s.length(); i++){
            String str = s.substring(i,i+1);
            if(str.equals("(") || str.equals("[") || str.equals("{")){
                par.push(str);
            }
            else{
                if(par.empty()) return false;
                String p = par.pop();
                if(!match(p,str)) return false;
            }
        }
        if(!par.empty()) return false;
        return true;
    }
    
    public boolean match(String left, String right){
        if(left.equals("{") && right.equals("}")) return true;
        if(left.equals("(") && right.equals(")")) return true;
        if(left.equals("[") && right.equals("]")) return true;
        return false;
    }
}
