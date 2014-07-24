public class Solution {
	public int longestValidParentheses(String s) {
		Stack<Integer> stk = new Stack<Integer>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; ++i) {
			if (c[i] == '(') {
				stk.push(i);
			} else if (!stk.empty()) {
				c[stk.peek()] = '*';
				c[i] = '*';
				stk.pop();
			}
		}

		int res = 0, part = 0;
		for (int i = 0; i < c.length; ++i) {
			if (c[i] == '*') {
				part++;
			} else {
				res = Math.max(res, part);
				part = 0;
			}
		}
		res = Math.max(res, part);
		return res;
	}
}