public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        final ArrayList<Pair> pairs = new ArrayList<Pair>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < target) {
                pairs.add(new Pair(numbers[i], i));
            }
        }
        Collections.sort(pairs, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.a - p2.a;
            } 
        });

        int l = 0, r = pairs.size() - 1;
        while( l < r ) {
            int sum = pairs.get(l).a + pairs.get(r).a;
            if (sum == target) { break; }
            if (sum < target) { l++; }
            else { r--; }
        }
        int res[] = new int[2];
        res[0] = Math.min(pairs.get(l).b, pairs.get(r).b) + 1;
        res[1] = Math.max(pairs.get(l).b, pairs.get(r).b) + 1;
        return res;
        
    }

    class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}