
public class KnightBoard {
	int[][] board;

	public KnightBoard(int r, int c) {
		board = new int[r][c];
	}

	public boolean move(int m, int a, int b, int c) {
		if (m == 0 && a - 2 >= 0 && b - 1 >= 0 && board[a - 2][b - 1] == 0) {
			board[a - 2][b - 1] = c;
			return solver(a - 2, b - 1, c + 1);

		}
		if (m == 1 && a - 2 >= 0 && b + 1 < board[0].length && board[a - 2][b + 1] == 0) {
			board[a - 2][b + 1] = c;
			return solver(a - 2, b + 1, c + 1);

		}
		if (m == 2 && a + 1 < board.length && b + 2 < board[0].length && board[a + 1][b + 2] == 0) {
			board[a + 1][b + 2] = c;
			return solver(a + 1, b + 2, c + 1);

		}
		if (m == 3 && a + 1 < board.length && b - 2 >= 0 && board[a + 1][b - 2] == 0) {
			board[a + 1][b - 2] = c;
			return solver(a + 1, b - 2, c + 1);

		}
		if (m == 4 && a + 2 < board.length && b - 1 >= 0 && board[a + 2][b - 1] == 0) {
			board[a + 2][b - 1] = c;
			return solver(a + 2, b - 1, c + 1);

		}
		if (m == 5 && a + 2 < board.length && b + 1 < board[0].length && board[a + 2][b + 1] == 0) {
			board[a + 2][b + 1] = c;
			return solver(a + 2, b + 1, c + 1);

		}
		if (m == 6 && a - 1 >= 0 && b + 2 < board[0].length && board[a - 1][b + 2] == 0) {
			board[a - 1][b + 2] = c;
			return solver(a - 1, b + 2, c + 1);

		}
		if (m == 7 && a - 1 >= 0 && b - 2 >= 0 && board[a - 1][b - 2] == 0) {
			board[a - 1][b - 2] = c;
			return solver(a - 1, b - 2, c + 1);
		}
		return false;
	}

	public void print() {
		String s = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (board.length * board[0].length > 10 && board[x][y] < 10) {
					s += " ";
				}
				s += " ";
				s += board[x][y] + " ";
			}
			System.out.println(s);
			s = "";
		}

	}

	public void printSolution() {
		solve();
		print();
	}

	public boolean solve() {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				board[x][y] = 1;
				if (solver(x, y, 2)) {
					return true;
				}
				board[x][y] = 0;
			}
		}
		return false;
	}

	public boolean solver(int x, int y, int c) {
		if (c > board.length * board[0].length) {
			return true;
		}
		for (int m = 0; m < 8; m++) {
			if (move(m, x, y, c)) {
				return true;
			}
		}
		board[x][y] = 0;
		return false;
	}
}