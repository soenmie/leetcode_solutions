public class Solution {
    public int trap(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            left[i] = max;
        }
        max = 0;
        for(int i = n - 1; i >= 0; i--) {
            max = Math.max(max, A[i]);
            right[i] = max;
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - A[i];
        }
        return res;
    }
}