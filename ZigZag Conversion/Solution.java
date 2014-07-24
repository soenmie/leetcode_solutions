public class Solution {
    public String convert(String s, int nRows) {
        if (nRows <= 1 || s.length() <= 1) { return s; }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nRows; i++) {
            for(int j = 0, index = i; index < s.length(); j++, index = (2 * nRows - 2) * j + i) {
                sb.append(s.charAt(index));
                if(i == 0 || i == nRows - 1) { continue; }
                if(index + (nRows - i - 1) * 2 < s.length()) {
                    sb.append(s.charAt(index + (nRows - i - 1) * 2));
                }
            }
        }
        return sb.toString();
    }
}