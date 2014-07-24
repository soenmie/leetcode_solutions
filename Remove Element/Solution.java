public class Solution {
    public int removeElement(int[] A, int elem) {
        int j = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] != elem) {
                A[j++] = A[i];
            }
        }
        return j;
    }
}