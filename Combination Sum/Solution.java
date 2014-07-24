public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combinationSumRe(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void combinationSumRe(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int start) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) { return; }
            cur.add(candidates[i]);
            combinationSumRe(candidates, target - candidates[i], res, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
}