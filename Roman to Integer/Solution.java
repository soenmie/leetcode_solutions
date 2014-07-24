public class Solution {
	public int romanToInt(String s) {
		Map<Character, Integer> roman = new HashMap<Character, Integer>();
		roman.put('M', 1000);
		roman.put('D', 500);
		roman.put('C', 100);
		roman.put('L', 50);
		roman.put('X', 10);
		roman.put('V', 5);
		roman.put('I', 1);

		int res = 0;
		for (int i = 0; i < s.length() - 1; ++i) {
			if (roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1)))
				res -= roman.get(s.charAt(i));
			else
				res += roman.get(s.charAt(i));
		}
		res += roman.get(s.charAt(s.length() - 1));
		return res;
	}
}