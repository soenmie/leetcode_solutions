public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        Arrays.sort(num);
        int minGap = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while(l < r) {
                int sum = num[l] + num[r];
                if(sum < target - num[i]) {
                    l++;
                } else if(sum > target - num[i]) {
                    r--;
                } else {
                    return target;
                }
                int gap = target - num[i] - sum;
                if(Math.abs(minGap) > Math.abs(gap)) {
                    minGap = gap;
                }
            }
        }
        return target - minGap;
    }
}