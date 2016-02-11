
public class QueenBoard {
	int[][] board;

	public  QueenBoard(int n) {
		board = new int[n][n];
	}

	public boolean addQ(int r, int c) {
		if (board[r][c] != 0) {
			return false;
		}
		board[r][c] = 1;
		for (int x = c + 1; x < board.length; x++) {
			board[r][x] -= 1;
		}
		for (int x = 1; x < board.length - c; x++) {
			if (r + x < board.length) {
				board[r + x][c + x] -= 1;
			}
			if (r - x > -1) {
				board[r - x][c + x] -= 1;
			}

		}
		return true;

	}

	public boolean removeQ(int r, int c) {
		if (board[r][c] != 1) {
			return false;
		}
		board[r][c] = 0;
		for (int x = c + 1; x < board.length; x++) {
			board[r][x] += 1;
		}
		for (int x = 1; x < board.length - c; x++) {
			if (r + x < board.length) {
				board[r + x][c + x] += 1;
			}
			if (r - x > -1) {
				board[r - x][c + x] += 1;
			}

		}
		return true;
	}

	public void print() {
		String s = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				if (board[x][y] == 1) {
					s += " Q ";
				} else {
					s += " _ ";
				}
			}
			System.out.println(s);
			s = "";
		}

	}
    public void printSolution() {
	solve();
		String s = "";
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				if (board[x][y] == 1) {
					s += " Q ";
				} else {
					s += " _ ";
				}
			}
			System.out.println(s);
			s = "";
		}

	}
	public boolean solve() {

		return solver(0);
	}

	public boolean solver(int c) {
		if (c >= board.length) {
			return true;
		}
		for (int r = 0; r < board.length; r++) {
			if (addQ(r, c) && solver(c + 1)) {
				return true;
			}
			removeQ(r, c);
		}

		return false;
	}
    /* public static void main(String[]args){
	QueenBoard b=new QueenBoard(Integer.parseInt(args[0]));
	b.printSolution();
	}*/

}
