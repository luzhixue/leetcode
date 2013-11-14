//Better to use StringBuffer or StringBuilder, use string+string is inefficient
//Note the difference of this recursion:  use the result of subproblem, assmble at this point, and finish
//and the other way:  add one character, pass all the previous steps to subproblems, add to the list at exit:
//http://n00tc0d3r.blogspot.com/2013/03/generate-parentheses.html

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        if(n <= 0) return list;
        list = recurseParenthesis(0, 0, n);
        return list;
    }
    
    public ArrayList<String> recurseParenthesis(int left, int right, int n){
        ArrayList<String> list = new ArrayList<String>();
        if(left == n){//generate right only
            String res = "";
            for(int i = right; i < n; i++){
                res += ")";
            }
            list.add(res);
            return list;
        }
        if(right == left){//generate left at this step
            ArrayList<String> res = recurseParenthesis(left+1, right, n);
            for(String str: res){
                list.add("("+str);
            }
            return list;
        }
        ArrayList<String> res1 = recurseParenthesis(left+1, right, n);
        ArrayList<String> res2 = recurseParenthesis(left, right+1, n);
        for(String str: res1){
            list.add("("+str);
        }
        for(String str: res2){
            list.add(")"+str);
        }
        return list;
    }
}
