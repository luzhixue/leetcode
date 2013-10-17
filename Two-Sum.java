//O(n) with hash
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(numbers == null) return null;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                int[] res = new int[2];
                res[0] = map.get(target-numbers[i]);
                res[1] = i + 1;
                return res;
            }
            else{
                map.put(numbers[i], i+1);
            }
        }
        return null;
    }
}

//O(nlogn) with sort
