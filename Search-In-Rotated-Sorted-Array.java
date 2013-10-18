//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//You may assume no duplicate exists in the array.

//based on if (target > lastValue of Array), then determine to search from head or tail

public class Solution {
    public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A == null || A.length == 0) return -1;
        if(target == A[A.length-1]) return A.length-1;
        if(target > A[A.length-1]){
            int curIdx = 0;
            while(A[curIdx] < target && curIdx+1 < A.length && A[curIdx] < A[curIdx+1]){
                ++curIdx;
            }
            return (A[curIdx] == target)?curIdx:-1;
        }
        else{
            int curIdx = A.length - 1;
            while(A[curIdx] > target && curIdx-1 >= 0 && A[curIdx] > A[curIdx-1]){
                --curIdx;
            }
            return (A[curIdx] == target)?curIdx:-1;
        }
    }
}

/*
actually we can still do a binary search.
see the analysis 
http://n00tc0d3r.blogspot.com/2013/05/search-in-rotated-sorted-array.html
*/
