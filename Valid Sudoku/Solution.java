public class Solution {
	public boolean isValidSudoku(char[][] board) {
		final int n = 9;
		int row;
		int[] col = new int[n], box = new int[n];
		for (int i = 0; i < n; i++) {
			row = 0;
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == '.') {
					continue;
				}

				int bit = 1 << (board[i][j] - '1');
				int box_index = i / 3 * 3 + j / 3;

				if ((row & bit | col[j] & bit | box[box_index] & bit) != 0) {
					return false;
				}

				row |= bit;
				col[j] |= bit;
				box[box_index] |= bit;
			}
		}
		return true;
	}
}