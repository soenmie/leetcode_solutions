public class Solution {
    public String strStr(String source, String target) {
        int m = source.length(), n = target.length();
        int offset = 0;
        while (true) {
            int i = offset, j = 0;
            while (i < m && j < n && source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) { return source.substring(offset); }
            if (i == m) { return null; }
            offset++;
        }
    }
}