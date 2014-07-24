public class Solution {
	public void solveSudoku(char[][] board) {
		Pair<Integer, Integer> next = (board[0][0] == '.') ? new Pair<Integer, Integer>(
				0, 0) : getNextMissing(board, 0, 0);
		solveSudokuRe(board, next.a, next.b);
	}

	private boolean solveSudokuRe(char[][] board, int row, int col) {
		if (row == 9)
			return true;
		Pair<Integer, Integer> next = getNextMissing(board, row, col);
		ArrayList<Character> possible = new ArrayList<Character>();
		getPossibleValues(board, row, col, possible);
		for (int i = 0; i < possible.size(); ++i) {
			board[row][col] = possible.get(i);
			if (solveSudokuRe(board, next.a, next.b))
				return true;
		}
		board[row][col] = '.';
		return false;
	}

	private Pair<Integer, Integer> getNextMissing(char[][] board, int row,
			int col) {
		while (true) {
			row = (col == 8) ? row + 1 : row;
			col = (col + 1) % 9;
			if (row == 9 || board[row][col] == '.')
				return new Pair<Integer, Integer>(row, col);
		}
	}

	private void getPossibleValues(char[][] board, int row, int col,
			ArrayList<Character> possible) {
		boolean[] value = new boolean[9];
		for (int i = 0; i < 9; ++i) {
			if (board[i][col] != '.')
				value[board[i][col] - '1'] = true;
			if (board[row][i] != '.')
				value[board[row][i] - '1'] = true;
			char c = board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3];
			if (c != '.')
				value[c - '1'] = true;
		}
		for (int i = 0; i < 9; ++i)
			if (!value[i])
				possible.add((char) (i + '1'));
	}
}

class Pair<T1, T2> {
	T1 a;
	T2 b;

	public Pair(T1 a, T2 b) {
		this.a = a;
		this.b = b;
	}

}