public class Solution {
    public int search(int[] A, int target) {
        int n = A.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = (i + j + 1) / 2;
            if (target == A[mid]) { return mid; }
            if (A[i] < A[mid]) {
                if (A[i] <= target && target < A[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }
}