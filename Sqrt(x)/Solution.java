public class Solution {
    public int sqrt(int x)
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x == 0)
            return 0;
        double res = 1;
        double last = -1;
        while(Math.abs(res - last) > .99)
        {
            last = res;
            res = (x - res * res) / (2 * res ) + res;
        }
        return (int)res;
    }
}