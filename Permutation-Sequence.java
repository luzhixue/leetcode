//calculate n!, (n-1)!,.....3!, 2!, 1!
//pick one by one progressively based on how many combinations are left 
//line 16

public class Solution {
    public String getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] perm = new int[n];
        for(int i = n-1; i >= 0; i--){//the number of perms
            perm[i] = (n-i)*((i==n-1)?1:perm[i+1]);
        }
        String str = "";
        HashSet<Integer> picked = new HashSet<Integer>();//we can actually use an array to do this
        for(int i = 0; i < n-1; i++){
        	int order = (k-1)/perm[i+1]+1;//pick up the order(th) number in this round based on how many combinations are there left
        	k -= (order-1)*perm[i+1];
            int number = pickNumber(n, order, picked);
            picked.add(number);
            str += String.valueOf(number);
        }
        str += String.valueOf(pickNumber(n, 1, picked));//pick the last remaining number;
        return str;
    }
    
    //pick  the order(th) number from [1,n] that are not in hashset
    private int pickNumber(int n, int order, HashSet<Integer> picked){
        if(order <= 0 || order + picked.size() > n) return -1;//cannot pick one
        for(int i = 1; i <= n; i++){
            if(picked.contains(i)) continue;
            if(order == 1) return i;
            --order;
        }
        return -1;
    }
}
