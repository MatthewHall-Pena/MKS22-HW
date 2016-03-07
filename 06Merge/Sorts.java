import java.util.Random;

public class Sorts {
	public static void printArray(int[] data) {
		String s = "[ ";
		for (int x = 0; x < data.length; x++) {
			s += data[x];
			if (x + 1 != data.length) {
				s += ", ";
			}
		}
		s += "]";
		System.out.println(s);
	}

	public static void selectionSort(int[] data) {
		int num;
		for (int x = 0; x < data.length; x++) {

			for (int y = x; y > 0; y--) {
				if (data[y] < data[y - 1]) {
					num = data[y];
					data[y] = data[y - 1];
					data[y - 1] = num;
				}
			}

		}
	}

	public static void insertionSort(int[] data) {
		int num;
		for (int y = 0; y < data.length - 1; y++) {

			while (data[y] > data[y + 1]) {
				num = data[y];
				data[y] = data[y + 1];
				data[y + 1] = num;

			}

		}
		printArray(data);

	}

	public static void bubbleSort(int[] data) {
		int num;
		int swap = 0;
		for (int x = 0; x < data.length; x++) {

			for (int y = 0; y < data.length - x - 1; y++) {
				if (data[y] > data[y + 1]) {
					num = data[y];
					data[y] = data[y + 1];
					data[y + 1] = num;
					swap += 1;
				}
			}
			if (swap == 0) {
				x = data.length;
			}
			swap = 0;

		}

	}

	public static void fillRandom(int[] data) {
		Random r = new Random();
		for (int x = 0; x < data.length; x++) {
			data[x] = r.nextInt();
		}
	}

	public static void swap(int[] data, int index, int nIndex) {
		int num = data[index];
		data[index] = data[nIndex];
		data[nIndex] = num;
	}

	public static int[] merge(int[] data, int[] data2) {
		int[] ints = new int[data.length + data2.length];
		int a = 0;
		int b = 0;
		for (int x = 0; x < ints.length; x++) {
			if (b >= data2.length || (a < data.length && data[a] < data2[b])) {
				ints[x] = data[a];
				a++;
			} else {
				ints[x] = data2[b];
				b++;
			}
		}
		return ints;
	}

	public static void merge(int[] data, int start, int end, int end2) {
		int[] ints = new int[end - start];
		int[] ints2 = new int[end2 - end];
		int y = 0;
		for (int x = start; x < end; x++) {
			ints[y] = data[x];
			y++;
		}
		y = 0;
		for (int x = end; x < end2; x++) {
			ints2[y] = data[x];
			y++;
		}
		ints = merge(ints, ints2);
		y = 0;
		for (int x = start; x < end2; x++) {
			data[x] = ints[y];
			y++;
		}
	}

	public static void mergesort(int[] data) {
		merger(data, 0);

	}

	private static void merger(int[] data, int power) {
		int pow2 = (int) Math.pow(2, power);
		if (pow2 * 2 < data.length) {
			for (int x = 0; x < data.length - (2 * pow2) + 1; x += 2 * pow2) {
				merge(data, x, x + pow2, x + 2 * pow2);
			}
			merger(data, power + 1);
		}
		for (int x = pow2; x + pow2 / 2 < data.length + 1; x += pow2 / 2) {
			merge(data, 0, x, x + pow2 / 2);
			if (pow2 / 2 == 0) {
				x = data.length + 1;
			}
		}

	}

}
