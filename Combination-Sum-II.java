//similar to combination-sum.java
//first sort the set of numbers
//then, for first number, use it 0,1,...Min(target/number, # times appear in the num[]) times, do it recursively


public class Solution {
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) return ret;
        Arrays.sort(num);
        recurseCombination(num, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }
    
    public void recurseCombination(int[] num, int curIdx, int target, ArrayList<Integer> sofar, ArrayList<ArrayList<Integer>> result){
        if(target == 0){
            result.add(sofar);
            return;
        }
        if(curIdx >= num.length) return;//no number left
        if(num[curIdx] > target) return;//cannot combine to give target
        int nextIdx = curIdx;
        while(nextIdx < num.length && num[nextIdx] == num[curIdx]) ++nextIdx;//find the first place of the next number
        int numCur = 0;
        while(numCur <= nextIdx - curIdx && numCur * num[curIdx] <= target){
            ArrayList<Integer> nextSofar = (ArrayList<Integer>)sofar.clone();
            for(int i = 0; i < numCur; i++)//try to use numCur times of current number
                nextSofar.add(num[curIdx]);
            recurseCombination(num, nextIdx, target-numCur*num[curIdx], nextSofar, result);
            ++numCur;
        }
    }
    
}
