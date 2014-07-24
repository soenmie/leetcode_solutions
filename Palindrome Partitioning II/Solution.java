public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[] isPa = new boolean[n];
        int [] dp = new int[n];
        dp[n - 1] = 0;
        isPa[n - 1] = true;
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            isPa[i] = true;
            for(int j = n - 1; j > i; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    isPa[j] = (j == i + 1) ? true : isPa[j - 1];
                }
                else {
                    isPa[j] = false;
                }
                if(isPa[j]){
                    if(j == n -1) {
                        dp[i] = 0;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                    }
                }
            }
        }
        return dp[0];
    }
}