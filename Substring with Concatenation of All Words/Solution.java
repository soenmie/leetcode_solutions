public class Solution {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (S.isEmpty() || L.length == 0)
			return res;
		int M = S.length(), N = L.length;
		int K = L[0].length();
		Map<String, Integer> need = new HashMap<String, Integer>();
		Map<String, Integer> found = new HashMap<String, Integer>();
		for (int i = 0; i < N; ++i) {
			if (need.get(L[i]) == null) {
				need.put(L[i], 1);
			} else {
				need.put(L[i], need.get(L[i]) + 1);
			}

		}
		for (int i = 0; i <= M - N * K; ++i) {
			if(i == 13) {
				System.out.print("");
			}
			found.clear();
			int j;
			for (j = 0; j < N; ++j) {
				String s = S.substring(i + j * K, i + j * K + K);
				Integer it = need.get(s);
				if (it == null) { break; }
				if (found.get(s) != null && it <= found.get(s)) { break; }
				if (found.get(s) == null) {
				    found.put(s, 1);
				} else {
                    found.put(s, found.get(s) + 1);  
				}
			}
			if (j == N)
				res.add(i);
		}
		return res;
	}
}