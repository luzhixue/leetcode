//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n. 
//For example, If n = 4 and k = 2, a solution is: 
/*[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
//solve it recursively: consider a number n, n might be in/not-in the result,
//then combine(n,k) = [combine(n-1,k)] + [combine(n-1,k-1),k]

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || k <= 0 || k > n){
            list.add(new ArrayList<Integer>());
            return list;
        }
        if (n == k){
            ArrayList<Integer> combine = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                combine.add(i+1);
            }
            list.add(combine);
            return list;
        }
        if (k == 1){
            for(int i = 0; i < n; i++){
                ArrayList<Integer> combine = new ArrayList<Integer>();
                combine.add(i+1);
                list.add(combine);
            }
            return list;
        }
        ArrayList<ArrayList<Integer>> subList = combine(n-1, k);
        list.addAll(subList);
        subList = combine(n-1, k-1);
        for(ArrayList<Integer> combine: subList){
            combine.add(n);
            list.add(combine);
        }
        return list;
    }

}
