public class Solution {
	private final String[][] rom = {
			{ "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
			{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
			{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
			{ "", "M", "MM", "MMM" } };

	public String intToRoman(int num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
        String res = "";
        int i = 3;
        while (num > 0)
        {
            int divisor = (int)Math.pow(10, i);
            res += rom[i][num / divisor];
            num %= divisor;
            i--;
        }
        return res;
	}
}