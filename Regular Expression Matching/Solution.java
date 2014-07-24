public class Solution {
	public boolean isMatch(String s, String p) {
		int m = s.length(), n = p.length();
		if (n == 0) {
			return m == 0;
		}
		if (m != 0 && s.charAt(0) == p.charAt(0) || m != 0
				&& p.charAt(0) == '.') {
			return n <= 1 || p.charAt(1) != '*' ? isMatch(s.substring(1),
					p.substring(1)) : isMatch(s.substring(1), p)
					|| isMatch(s, p.substring(2));
		} else {
			return n > 1 && p.charAt(1) == '*' && isMatch(s, p.substring(2));
		}
	}
}