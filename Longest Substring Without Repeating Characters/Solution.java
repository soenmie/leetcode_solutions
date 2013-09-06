public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean flag[] = new boolean[256];
        // Arrays.fill(flag, false);
        int start = 0, end = 0;
        int max = 0;
        int len = s.length();
        
        while (start + max < len && end < len) {
            if (!flag[s.charAt(end)]) { flag[s.charAt(end++)] = true; }
            else { flag[s.charAt(start++)] = false; }
            max = Math.max(max, end - start);
        }
        return max;
    }
}