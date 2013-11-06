//http://n00tc0d3r.blogspot.com/2013/04/next-permutation.html
//1. find the longest descending sequence from the tail (or ascending if look from right to left)
//2. reverse the sequence
//3. if there is one element ahead of the tail, swap it with the munimum number in sequence that is larger than the element
public class Solution {
    public void nextPermutation(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num == null || num.length == 0) return;
        int cur = num.length - 1;
        while(cur != 0 && num[cur-1] >= num[cur]){
            --cur;
        }
        reverse(num, cur, num.length-1);
        if(cur == 0) return;//no element ahead of cur
        int largerIdx = -1; //the larger value is tricky, (.....................)
        for(int i = cur; i < num.length; i++){//have to scan from left to right, so that it always swap with the leftmost value if there are duplicate values
            if(num[i] > num[cur-1]){
                if(largerIdx == -1 || num[largerIdx] > num[i]){
                    largerIdx = i;
                }
            }
        }
        int tmp = num[largerIdx];
        num[largerIdx] = num[cur-1];
        num[cur-1] = tmp;
    }
    
    public void reverse(int[] num, int from, int to){
        if(num == null || from >= to || from >= num.length || to >= num.length) return;
        while(from < to){
            int tmp = num[from];
            num[from] = num[to];
            num[to] = tmp;
            ++from;
            --to;
        }
    }
}
