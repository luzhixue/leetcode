public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A ==  null && B == null) return -1;
        int m = (A == null)?0:A.length;
        int n = (B == null)?0:B.length;
        if(((m+n)&1) == 0){//even
            double a1 = kthElement(A, 0, m-1, B, 0, n-1, (m+n)/2);
            double a2 = kthElement(A, 0, m-1, B, 0, n-1, (m+n)/2+1);
            return (a1+a2)/2;
        }
        return kthElement(A, 0, m-1, B, 0, n-1, (m+n+1)/2);//odd
    }
    
    
    private int kthElement(int[] A, int startA, int endA, int[] B, int startB, int endB, int k){
        if(A == null && B == null || k <= 0) return -1;
        int m = (endA - startA < 0)?0:endA-startA+1;
        int n = (endB - startB < 0)?0:endB-startB+1;
        if(k > m + n) return -1;
        if(m == 0) return B[startB+k-1];
        if(n == 0) return A[startA+k-1];
        if(k == 1) return Math.min(A[startA], B[startB]);//......if looking for the first element, then cannot find both i and j
        int i = Math.min(m-1, k/2);
	    //int i = Math.min(Math.min(m-1, k/2),k-2); 
        int j = k-2-i;//trying to keep   i+1+j+1=k
        if(j < 0){//...............................if one is out of boundary, make sure do adjustment
	        i = i - (0-j);
	        j = 0;
	    }
	    else if(j > n-1){
	    	i = (i+(j-n+1));
	    	j = n - 1;
	    }
        if(A[startA+i] >= B[startB+j] && (startB+j==endB || B[startB+j+1] >= A[startA+i]))//no next in B, or next in B is higher than A
	        return A[startA+i];//this is the kth
	    if(B[startB+j] >= A[startA+i] && (startA+i==endA || A[startA+i+1] >= B[startB+j]))
	        return B[startB+j];
        if(A[startA+i] <= B[startB+j])//throw away A[startA..startA+i] and B[startB+j..endB]
            return kthElement(A, startA+i+1, endA, B, startB, startB+j-1, k-i-1);
        else//throw away B[startB..startB+j]
            return kthElement(A, startA, startA+i-1, B, startB+j+1, endB, k-j-1);
    }
}
