import java.math.BigInteger;

public class Solution {
	public int divide(int dividend, int divisor) {
		boolean sign = dividend > 0 && divisor < 0 || dividend < 0
				&& divisor > 0;
		BigInteger un_dividend = new BigInteger(dividend + "").abs(),  un_divisor = new BigInteger(divisor + "").abs();
		int res = divideRe(un_dividend, un_divisor);
		return sign ? -res : res;
	}

	private int divideRe(BigInteger dividend, BigInteger divisor) {
		if (dividend.compareTo(divisor) < 0) {
			return 0;
		}
		BigInteger tem = divisor;
		int shift = 0;
		while ((tem.shiftLeft(1)).compareTo(dividend) < 0) {
			tem = tem.shiftLeft(1);
			shift++;
		}
		return (1 << shift) + divideRe(dividend.subtract(tem), divisor);
	}
}