public class Solution {
    public void nextPermutation(int[] num) {
        int n = num.length;
        int i = n - 1;
        for (; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                break;
            }
        }
        reverse(num, i, n);
        if (i == 0) { return; }
        for (int j = i; j < n ; j++) {
            if (num[j] > num[i - 1]) {
                int tem = num[j];
                num[j] = num[i - 1];
                num[i - 1] = tem;
                break;
            }
        }
        return;
    }
    
    void reverse(int[] array, int m, int n) {
        for (int i = m; i < (m + n) / 2; i++) {
            int tem = array[i];
            array[i] = array[n - 1 + m - i];
            array[n - 1 + m - i] = tem;
        }
    }
}