
public class Recursion {
	public String name() {
		return "Hall-Pena,Matthew";
	}

	public static double sqrt(double n) {
		return sqrt1(n, n);
	}

	public static double sqrt1(double n, double guess) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (Math.abs(((guess * guess) + 1) / (n + 1) - 1) < .0000000000001) {
			return guess;
		}
		return sqrt1(n, (n / guess + guess) / 2);
	}
}
