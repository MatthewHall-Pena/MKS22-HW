import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Silver {
	public static int solve(int[][] map, int s, int x, int y, int x2, int y2) {
		for (int a = -1; a < 2; a++) {
			for (int b = -1; b < 2; b++) {
				if (a + x >= 0 && a + x < map.length && b + y >= 0 && y + b < map[0].length && a != b && a != -b
						&& map[x + a][b + y] != -1) {
					map[x + a][y + b] = 1;
				}

			}
		}
		for (int a = 1; a < s; a++) {
			/*
			 * for (x = 0; x < map.length; x++) { System.out.println(); for (y =
			 * 0; y < map[x].length; y++) { System.out.print(" " + map[x][y] +
			 * " "); } }
			 */
			map = add(map);
		}

		return map[x2][y2];
	}

	public static int[][] add(int[][] map) {
		int[][] nmap = new int[map.length][map[0].length];

		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y] > 0) {
					for (int a = -1; a < 2; a++) {
						for (int b = -1; b < 2; b++) {
							if (a + x >= 0 && a + x < map.length && b + y >= 0 && y + b < map[x].length && a != b
									&& a != -b && map[x + a][b + y] != -1) {
								nmap[x + a][y + b] += map[x][y];
							}

						}
					}
				}
				if (map[x][y] == -1) {
					nmap[x][y] = -1;
				}
			}
		}

		return nmap;

	}

	public static void main(String[] args) {
		Scanner s = null;
		try {
			s = new Scanner(new File("ctravel.in"));
		} catch (FileNotFoundException e) {
		}
		int[][] map = new int[s.nextInt()][s.nextInt()];
		char[] line;
		int sec = s.nextInt();
		s.nextLine();
		for (int x = 0; x < map.length; x++) {
			line = s.nextLine().toCharArray();
			for (int y = 0; y < map[x].length; y++) {
				if (line[y] == '.') {
					map[x][y] = 0;
				}
				if (line[y] == '*') {
					map[x][y] = -1;
				}
			}
		}
		System.out.println(solve(map, sec, s.nextInt() - 1, s.nextInt() - 1, s.nextInt() - 1, s.nextInt() - 1)+",7,Hall-Pena,Matthew");
	}
}
