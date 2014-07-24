public class Solution {
    private static String[] mapping = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        letterCombinationsRe(digits, "", res, 0);
        return res;
    }
    
    private void letterCombinationsRe(String digits, String line, ArrayList<String> res, int start) {
        int n = digits.length();
        if(n == start) {
            res.add(line);
            return;
        }

        String m = mapping[digits.charAt(start) - '2'];
        for(int j = 0; j < m.length(); j++) {
            letterCombinationsRe(digits, line + m.charAt(j), res, start + 1);
        }
    }
}