public class Solution {
    public double pow (double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (x == 0.0) {
            return 0.0;
        }
        else if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }

        double y = pow(x, n / 2);
        
        if (n % 2 == 0) {	
            return y * y;
        }
        else {
            return y * y * x;
        }   
    }
}