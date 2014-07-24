public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            while (A[i] > 0 && A[i] <= n && A[i] != A[A[i] - 1]) {
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != i + 1) { return i + 1; }
        }
        return n + 1;
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}