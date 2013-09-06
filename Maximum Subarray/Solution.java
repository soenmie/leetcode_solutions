public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A == null || A.length == 0) {
            return 0;
        }
        int sum = A[0];
        int res = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(sum + A[i], A[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}