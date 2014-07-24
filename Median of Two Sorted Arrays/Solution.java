public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = A.length;
        int n = B.length;
        int total = m + n;
        if (total % 2 == 0) {
            return (findKthSortedArrays(A, 0, m, B, 0, n, total / 2) + findKthSortedArrays(A, 0, m, B, 0, n, 1 + total / 2)) / 2;
        }
        else {
            return findKthSortedArrays(A, 0, m, B, 0, n, (total + 1) / 2);
        }
        
    }
    
    private double findKthSortedArrays(int A[], int a, int m, int B[], int b, int n, int k) {
        if (m > n) {
            return findKthSortedArrays(B, b, n, A, a, m, k);
        }
        
        if (m == 0) {
            return B[b + k - 1];
        }
        
        if (k == 1) {
            return Math.min(A[a], B[b]);
        }
        
        int i = Math.min(m, k / 2);
        int j = k - i;
        
        int x = A[a + i - 1];
        int y = B[b + j - 1];
        
        if (x > y) { return findKthSortedArrays(A, a, m, B, b + j, n - j, k - j); }
        else if (x < y) { return findKthSortedArrays(A, a + i, m - i, B, b, n, k - i); }
        
        return x;
        
    }
}