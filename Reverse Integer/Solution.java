public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x > 0) {
            int res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return res;
        }
        else {
            x = - x;
            int res = 0;
            while (x != 0) {
                res = res * 10 + x % 10;
                x = x / 10;
            }
            return -res;
        }
    }
}