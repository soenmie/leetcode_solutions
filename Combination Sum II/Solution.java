public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        combinationSum2Re(num, target, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    private void combinationSum2Re(int[] num, int target, int start, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i = start; i < num.length; i++) {
            if (i == start || num[i] != num[i - 1]) { // exclude the same element
                if(num[i] > target) { return; }
                cur.add(num[i]);
                combinationSum2Re(num, target - num[i], i + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}