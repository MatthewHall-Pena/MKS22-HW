import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BetterMaze {
	private class Node {
		int r, c;
		Node prev;

		public Node(int row, int col, Node previous) {
			r = row;
			c = col;
			prev = previous;
		}

		public Node getPrev() {
			return prev;
		}

		public int[] get() {
			int[] coordinates = { r, c };
			return coordinates;
		}
	}

	private char[][] maze;
	private int[] solution;
	private int startRow, startCol;
	private Frontier<Node> frontier;
	private boolean animate;// default to false
	private Node Solution;

	/**
	 * return a COPY of solution. This should be : [x1,y1,x2,y2,x3,y3...] the
	 * coordinates of the solution from start to end. Precondition : one of the
	 * solveXXX methods has already been called (solveBFS OR solveDFS OR
	 * solveAStar) (otherwise an empty array is returned) Postcondition: the
	 * correct solution is in the returned array
	 **/
	public int[] solutionCoordinates() {
		return solution;
	}

	public boolean solveBFS() {
		frontier = new FrontierQueue<Node>();
		return solve();
	}

	public boolean solveDFS() {
		frontier = new FrontierStack<Node>();
		return solve();
	}

	private boolean solve() {
		frontier.add(new Node(startRow, startCol, null));
		while (frontier.hasNext()) {
			for (Node n : getNexts(frontier.next())) {
				if (animate) {
					System.out.println(toString());
				}
				if (maze[n.get()[0]][n.get()[1]] == 'E') {
					Solution = n;
					showPath();
					return true;
				}
				maze[n.get()[0]][n.get()[1]] = '.';
				frontier.add(n);
			}
		}
		return false;
	}

	private void showPath() {
		ArrayList<Node> answer = new ArrayList<Node>();
		answer.add(Solution);
		Node current = Solution.getPrev();

		while (current.getPrev() != null) {
			answer.add(current);
			maze[current.get()[0]][current.get()[1]] = '@';
			current = current.getPrev();
		}

		solution = new int[answer.size() * 2];
		for (int x = 0; x < answer.size(); x += 2) {
			solution[x] = answer.get(answer.size() - x - 1).get()[0];
			solution[x + 1] = answer.get(answer.size() - x - 1).get()[1];
		}

	}

	private LinkedList<Node> getNexts(Node current) {
		LinkedList<Node> nexts = new LinkedList<Node>();
		int r = current.get()[0];
		int c = current.get()[1];
		for (int a = -1; a < 2; a++) {
			for (int b = -1; b < 2; b++) {
				if (a != b && a != -b) {
					if (r + a > -1 && r + b > -1 && r + a < maze.length && r + b < maze[0].length
							&& maze[r + a][c + b] != '#' && maze[r + a][c + b] != '.' && maze[r + a][c + b] != 'S') {
						nexts.add(new Node(r + a, c + b, current));
					}
				}

			}
		}
		return nexts;
	}

	public void setAnimate(boolean b) {
		animate = b;
	}

	public BetterMaze(String filename) {
		animate = false;
		int maxc = 0;
		int maxr = 0;
		startRow = -1;
		startCol = -1;

		String ans = "";
		try {
			Scanner in = new Scanner(new File(filename));
			while (in.hasNext()) {
				String line = in.nextLine();
				if (maxr == 0) {
					maxc = line.length();
				}
				maxr++;
				ans += line;
			}
		} catch (Exception e) {
			System.out.println("File: " + filename + " could not be opened.");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(maxr + " " + maxc);
		maze = new char[maxr][maxc];
		for (int i = 0; i < ans.length(); i++) {
			char c = ans.charAt(i);
			maze[i / maxc][i % maxc] = c;
			if (c == 'S') {
				startCol = i % maxc;
				startRow = i / maxc;
			}
		}
	}

	private static final String CLEAR_SCREEN = "\033[2J";
	private static final String HIDE_CURSOR = "\033[?25l";
	private static final String SHOW_CURSOR = "\033[?25h";

	private String go(int x, int y) {
		return ("\033[" + x + ";" + y + "H");
	}

	private String color(int foreground, int background) {
		return ("\033[0;" + foreground + ";" + background + "m");
	}

	public void clearTerminal() {
		System.out.println(CLEAR_SCREEN);
	}

	public void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public String toString() {
		int maxr = maze.length;
		int maxc = maze[0].length;
		String ans = "";
		if (animate) {
			ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
		}
		for (int i = 0; i < maxc * maxr; i++) {
			if (i % maxc == 0 && i != 0) {
				ans += color(37, 40) + "\n";
			}
			char c = maze[i / maxc][i % maxc];
			if (c == '#') {
				ans += color(38, 47) + c;
			} else {
				ans += color(33, 40) + c;
			}
		}
		// nice animation string
		if (animate) {
			return HIDE_CURSOR + go(0, 0) + ans + color(37, 40) + "\n" + SHOW_CURSOR + color(37, 40);
		} else {
			return ans + color(37, 40) + "\n";
		}
	}

	private static void printArray(char[] data) {
		String s = "";
		for (int x = 0; x < data.length; x++) {
			s += data[x];
			s += " ";
		}
		System.out.println(s);
	}

	public void print() {
		for (int x = 0; x < maze.length; x++) {
			printArray(maze[x]);
		}
	}
}
