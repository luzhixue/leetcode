//Please be noticed of the for loop in line 21

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list.add(new ArrayList<Integer>());
        if(S == null || S.length == 0) return list;
        Arrays.sort(S);
        recurseSubset(S, 0, list);
        return list;
    }
    
    private void recurseSubset(int[] S, int idx, ArrayList<ArrayList<Integer>> list){
        if(idx >= S.length)
            return;
        int curSize = list.size();
        //NOTE: since we are adding elements in the for-loop, we cannot use for(ArrayList<Integer> subList: list)
        //also, we cannot use for(int i=0; i<list.size(); i++) ------which will result in a infinite loop
        for(int i = 0; i < curSize; i++){
            ArrayList<Integer> newList = new ArrayList<Integer>();//create a new list
            newList.addAll(list.get(i));
            newList.add(S[idx]);//append a value
            list.add(newList);
        }
        recurseSubset(S, idx+1, list);
    }
}
