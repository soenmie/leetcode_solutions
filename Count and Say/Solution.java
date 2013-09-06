public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String ret = "1";
        for(int i = 1; i < n; i++) {
            int k = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < ret.length(); j++) {
                if(ret.charAt(k) != ret.charAt(j)) {
                    sb.append(j - k).append(ret.charAt(k));
                    k = j;
                }
            }
            sb.append(ret.length() - k).append(ret.charAt(k));
            ret = sb.toString();
        }
        return ret;
    }
}