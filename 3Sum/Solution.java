public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3) {
            return ret;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[j] + num[k];
                if (sum == -num[i]) {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(num[i]);
                    triplet.add(num[j]);
                    triplet.add(num[k]);
                    boolean dup = false;
                    for (int l = 0; l < ret.size(); l++) {
                        if (triplet.get(0) == ret.get(l).get(0) && triplet.get(1) == ret.get(l).get(1) && triplet.get(2) == ret.get(l).get(2)) {
                            dup = true;
                            break;
                        }
                    }
                    if (!dup) {
                        ret.add(triplet);
                    }
                }
                if (sum < -num[i]) { j++; }
                else { k--; }
            }
        } 
        return ret;
    }
}