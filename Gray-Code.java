//append one more bit based on (n-1) solution
//for example: given n=1:    0  1
//when n = 2,   append 0 to the list:  00 01, then reversely append 1 to it: 11, 10
//could do it recursively or iteratively
public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> codeList = new ArrayList<Integer>();
        if(n < 0) return codeList;
        if(n == 0){
            codeList.add(0);
            return codeList;
        }
        for(int i = 0; i < n; i++){
            if(i == 0){//the first bit, make the list non-empty
                codeList.add(0);
                codeList.add(1);
            }
            else{
                Stack<Integer> stack = new Stack<Integer>();
                for(int code : codeList){//append one bit i reversely
                    int appendOne = code | (1 << i);
                    stack.push(appendOne);
                }
                while(!stack.empty()){
                    int code = stack.pop();
                    codeList.add(code);
                }
            }
        }
        return codeList;
    }
}
