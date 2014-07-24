public class Solution {
    public int atoi(String str) {
        str = str.trim();
        int n = str.length();
        if (n == 0) { return 0; }
        int sign = 1;
        int i = 0;
        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        for (;i < n; i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            if (num > Integer.MAX_VALUE / 10) { return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; }
            if (num == Integer.MAX_VALUE / 10) {
                if (sign == 1) {
                    if (str.charAt(i) - '0' > Integer.MAX_VALUE % 10) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (str.charAt(i) - '0' > -(Integer.MIN_VALUE % 10)) {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            num = num * 10 + str.charAt(i) - '0';
        }
        return sign * num;
    }
}