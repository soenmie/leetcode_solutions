public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        genParenthesisRe("", n, n, res);
        return res;
    }
    
    private void genParenthesisRe(String str, int left, int right, ArrayList<String> res) {
        if(left == 0 && right == 0) {
            res.add(str);
        }
        if(left > 0) {
            genParenthesisRe(str + "(", left - 1, right, res);
        }
        if(right > left) {
            genParenthesisRe(str + ")", left, right - 1, res); 
        }
        
    }
}