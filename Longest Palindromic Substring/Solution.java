public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int []dp = new int[2 * n + 1];
        int id = 0, mx = 0;
        for (int i = 0; i < 2 * n + 1; ++i) {
            int j = 2 * id - i;
            dp[i] = mx > i ? Math.min(dp[j], mx - i) : 1;
            int left = i - dp[i], right = i + dp[i];
            for (; left >= 0 && right <= 2 * n; left--, right++) {
                if (left % 2 == 0 || s.charAt(left / 2) == s.charAt(right / 2)) { // padding or char
                    dp[i]++;
                }
                else {
                    break;
                }
            }
            if (i + dp[i] > mx) {
                id = i;
                mx = id + dp[id];
            }
        }

        int res = 0;
        for (int i = 1; i < 2 * n + 1; ++i) {
            if (dp[i] > dp[res]) {
                res = i;
            }
        }
        return s.substring(res / 2 - (dp[res] - 1) / 2,
            res / 2 - (dp[res] - 1) / 2 + dp[res] - 1);
    }
}