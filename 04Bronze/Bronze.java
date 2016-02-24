import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bronze {
	public static int[][] stomp(int r, int c, int diff, int[][] elev) {
		if (r + 3 > elev.length || c + 3 > elev[0].length || diff <= 0) {
			return elev;
		}
		int max = big(r, c, elev) - diff;
		for (int x = r; x < r + 3; x++) {
			for (int y = c; y < c + 3; y++) {
				if (elev[x][y] > max) {
					elev[x][y] = max;
				}
			}
		}
		return elev;
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
		int n = s.nextInt();
		for (int x = 0; x < elev.length; x++) {
			for (int y = 0; y < elev[0].length; y++) {
				elev[x][y] = s.nextInt();
			}
		}
		for (int x = n; x > 0; x--) {
			elev = stomp(s.nextInt() - 1, s.nextInt() - 1, s.nextInt(), elev);
		}
		for (int x = 0; x < elev.length; x++) {
			for (int y = 0; y < elev[0].length; y++) {
				elev[x][y] = lake - elev[x][y];
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