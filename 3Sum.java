//Note: for a 2sum subproblem, there might be multiple solutions!

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3) return ret;
        Arrays.sort(num);
        for(int i = 0; i < num.length-2; i++){
            ArrayList<ArrayList<Integer>> list = twoSum(num, i+1, 0-num[i]);
            if(list != null){
                for(ArrayList<Integer> solution: list){
                    solution.add(0,num[i]);
                    ret.add(solution);
                }
            }
            while(i+1 < num.length && num[i+1] == num[i])//skip duplicates
                ++i;
        }
        return ret;
    }
    
    //could return multiple results
    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int start, int target){
        if(num == null || num.length - start <= 1) return null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int firstNum = start, secondNum = num.length - 1;
        while(firstNum < secondNum){
            if(num[firstNum]+num[secondNum] == target){
                ArrayList<Integer> solution = new ArrayList<Integer>();
                solution.add(num[firstNum]);
                solution.add(num[secondNum]);
                list.add(solution);
                while(firstNum+1 < num.length && num[firstNum] == num[firstNum+1])//skip duplicates
                    ++firstNum;
                while(secondNum-1 >= start && num[secondNum] == num[secondNum-1])
                    --secondNum;
                ++firstNum;
                --secondNum;
            }
            else if(num[firstNum]+num[secondNum] > target){
                --secondNum;
            }
            else{
                ++firstNum;
            }
        }
        return (list.size()>0)?list:null;
    }
}
