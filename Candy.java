public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int ret = 0;
        int[] candy = new int[ratings.length];
        //based on increasing sequence, assign candy from left to right, the start of an increasing sequence has one candy
        for(int i = 0; i < ratings.length; i++){
            if(i == 0 || ratings[i] <= ratings[i-1])
                candy[i] = 1;
            //Note taht if they are equal, the increasing sequency is done, don't assign same number of candy to them!!!    
            // else if (ratings[i] == ratings[i-1])  
            //     candy[i] = candy[i-1];
            else
                candy[i] = candy[i-1]+1;
        }
        //from right to left,
        for(int i = ratings.length-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1])
                candy[i] = candy[i+1] + 1;
        }
        return sum(candy);
    }
    
    private int sum(int[] candy){
        if(candy == null || candy.length <= 0) return 0;
        int ret = 0;
        for(int count : candy)
            ret += count;
        return ret;
    }
}
