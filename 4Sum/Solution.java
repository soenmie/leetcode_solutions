public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4) {
			return res;
		}
		uniqueAndCount(num);
		buildTwoSum();
		searchResult(target, res);
		return res;
	}

	private void uniqueAndCount(int[] num) {
		count = new HashMap<Integer, Integer>();
		uni = new ArrayList<Integer>();
		for (int i : num) {
			if (count.get(i) == null) {
				uni.add(i);
				count.put(i, 0);
			}
			count.put(i, count.get(i) + 1);
		}
	}

	private void buildTwoSum() {
		sum = new ArrayList<TwoSum>();
		for (int i = 0; i < uni.size(); i++) {
			for (int j = i + 1; j < uni.size(); j++) {
				sum.add(new TwoSum(uni.get(i), uni.get(j)));
			}
		}
		for (Map.Entry<Integer, Integer> c : count.entrySet()) {
			if (c.getValue() > 1) {
				sum.add(new TwoSum(c.getKey(), c.getKey()));
			}
		}
		Collections.sort(sum, new Comparator<TwoSum>() {
			@Override
			public int compare(TwoSum s1, TwoSum s2) {
				return s1.sum - s2.sum;
			}
		});
	}

	private void searchResult(int target, ArrayList<ArrayList<Integer>> res) {
		int i = 0;
		int j = sum.size() - 1;
		while (i < j) {
			int s = sum.get(i).sum + sum.get(j).sum;
			if (s == target) {
				int m = i, n = j;
				while (sum.get(m).sum == sum.get(i).sum) {
					n = j;
					while (m < n && sum.get(n).sum == sum.get(j).sum)
						pushResult(sum.get(m), sum.get(n--), res);
					m++;
				}
				i = m;
				j = n;
			} else if (s < target) {
				i++;
			} else {
				j--;
			}
		}
		for (Map.Entry<Integer, Integer> c : count.entrySet()) {
			if (c.getValue() >= 4 && c.getKey() * 4 == target) {
				pushResult(new TwoSum(c.getKey(), c.getKey()),
						new TwoSum(c.getKey(), c.getKey()), res);
			}
		}
	}

	private void pushResult(TwoSum a, TwoSum b,
			ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> quadruplet = new ArrayList<Integer>();
		quadruplet.add(a.a);
		quadruplet.add(a.b);
		quadruplet.add(b.a);
		quadruplet.add(b.b);

		Map<Integer, Integer> used = new HashMap<Integer, Integer>();
		for (int i : quadruplet) {
			if (used.get(i) == null) {
				used.put(i, 0);
			}
			used.put(i, used.get(i) + 1);
		}
		for (Map.Entry<Integer, Integer> u : used.entrySet()) {
			if (u.getValue() > count.get(u.getKey())) {
				return;
			}
		}
		Collections.sort(quadruplet);
		boolean found = false;
		for (ArrayList<Integer> r : res) {
			if (r.get(0).equals(quadruplet.get(0)) && r.get(0).equals(quadruplet.get(0))
					&&r.get(2).equals(quadruplet.get(2))
					&& r.get(3).equals(quadruplet.get(3))) {
				found = true;
				break;
			}
		}
		if (!found) {
			res.add(quadruplet);
		}
	}

	private Map<Integer, Integer> count;
	private ArrayList<Integer> uni;
	private ArrayList<TwoSum> sum;
}

class TwoSum {
	int sum;
	int a;
	int b;

	public TwoSum(int a, int b) {
		this.a = a;
		this.b = b;
		sum = a + b;
	}
}