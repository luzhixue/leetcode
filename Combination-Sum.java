//every number in the candidates can be used unlimited # of times
//the idea is, to use the first number 0---target/number times, and recurse


public class Solution {
    
    ArrayList<ArrayList<Integer>> result;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);

        ArrayList<Integer> sofar = new ArrayList<Integer>();
        recurseCombine(candidates, 0, target, sofar);
        return result;
    }
    
    public void recurseCombine(int[] candidates, int cur, int target, ArrayList<Integer> sofar){
        if(target == 0){
            result.add(sofar);
            return;
        }
        if(candidates.length - cur <= 0) return;//no number remains
        if(candidates[cur] > target) return;
	    int numCur = 0;
	    while(numCur * candidates[cur] <= target){
	        ArrayList<Integer> newsofar = (ArrayList<Integer>) sofar.clone();//need to clone this result, so that they do not mess up in the fina result
	        for(int i = 0; i < numCur; i++)
	        	newsofar.add(candidates[cur]);
	        recurseCombine(candidates, cur+1, target-numCur*candidates[cur], newsofar);
	        ++numCur;
        }
    }
}
