public class Solution {
    public int[] searchRange(int[] A, int target) {
        int low = searchLow(A, target);
        int high = searchHigh(A, target);
        int[] res = new int[2];
        if(low > high) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        res[0] = low;
        res[1] = high;
        return res;
        
    }
    private int searchLow(int[] A, int target) {
        int n = A.length;
        int i = 0;
        int j = n - 1;
        while(i <= j) {
            int k = (i + j) / 2;
            if(A[k] >= target) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return i;
    }
    private int searchHigh(int[] A, int target) {
        int n = A.length;
        int i = 0;
        int j = n - 1;
        while(i <= j) {
            int k = (i + j) / 2;
            if(A[k] > target) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return j;
    }
}