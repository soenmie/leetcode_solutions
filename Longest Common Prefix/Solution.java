public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder res = new StringBuilder();
        if (strs == null || strs.length == 0) {
            return res.toString();
        }
        for(int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != a) {
                    return res.toString();
                }
            }
            res.append(a);
        }
        return res.toString();
    }
}