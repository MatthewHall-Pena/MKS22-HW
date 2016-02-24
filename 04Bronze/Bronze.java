import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze {
	public static boolean stomp(int r, int c, int diff, int[][] elev) {
		if (r + 2 < elev.length || c + 2 < elev[0].length || diff <= 0) {
			return false;
		}
		int max = big(r, c, elev) - diff;
		for (int x = r; x < r + 3; x++) {
			for (int y = c; y < c + 3; y++) {
				if (elev[x][y] > max) {
					elev[x][y] = max;
				}
			}
		}
		return true;
	}

	public static int big(int r, int c, int[][] elev) {
		int max = 0;
		for (int x = r; x < r + 3; x++) {
			for (int y = c; y < c + 3; y++) {
				if (elev[x][y] > max) {
					max = elev[x][y];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner s = null;
		try {
			s = new Scanner(new File("makelake.in"));
		} catch (FileNotFoundException e) {
		}
		int[][] elev = new int[s.nextInt()][s.nextInt()];
		int lake = s.nextInt();
		for (int x = s.nextInt(); x > 0; x--) {
			for (int y = 0; y < 3; y++) {
				stomp(s.nextInt(), s.nextInt(), s.nextInt(), elev);
			}
		}
		for (int x = 0; x < elev.length; x++) {
			for (int y = 0; y < elev[0].length; y++) {
				elev[x][y] -= lake;
				if (elev[x][y] < 0) {
					elev[x][y] = 0;
				}
			}
		}
		int sum = 0;
		for (int x = 0; x < elev.length; x++) {
			for (int y = 0; y < elev[0].length; y++) {
				sum += elev[x][y];
			}
		}
		System.out.println(sum * 72 * 72 + ",7,Hall-Pena,Matthew");
	}
}
