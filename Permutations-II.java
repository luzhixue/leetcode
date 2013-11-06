public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (num == null) return null;
        //sort and skip the duplicate elements at each step, we can also use a hashset to filter duplicates
        Arrays.sort(num);
        return recurPermute(num);
    }
    
    public ArrayList<ArrayList<Integer>> recurPermute(int[] num){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            ArrayList<Integer> subList = new ArrayList<Integer>();
            list.add(subList);
            return list;
        }
        int cur = 0;
        while(cur < num.length){
            //copy subset
            int[] subNum = new int[num.length-1];
            for(int j = 0; j < cur; j++) subNum[j] = num[j];
            for(int j = cur+1; j < num.length; j++) subNum[j-1] = num[j];
            ArrayList<ArrayList<Integer>> subList = recurPermute(subNum);
            for(ArrayList<Integer> per: subList){
                per.add(num[cur]);
                list.add(per);//current permutation
            }
            while(cur + 1 < num.length && num[cur+1] == num[cur]){//skip the duplicate elements
                ++cur;
            }
            ++cur;//move the pointer to the next element
        }
        return list;
    }
}
