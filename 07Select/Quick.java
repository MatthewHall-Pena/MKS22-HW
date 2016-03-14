import java.util.Arrays;
import java.util.Random;

public class Quick {
	public static String name() {
		return "7,Hall-Pena,Matthew";
	}

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

	private static void fillRandom(int[] data) {
		Random r = new Random();
		for (int x = 0; x < data.length; x++) {
			data[x] = r.nextInt();
		}
	}

	private static void swap(int[] data, int a, int b) {
		int old = data[a];
		data[a] = data[b];
		data[b] = old;
	}

	private static int max(int[] data, int a, int b) {
		int max = data[a];
		for (int x = a + 1; x < b + 1; x++) {
			if (data[x] > max) {
				max = data[x];
			}
		}
		return max;
	}

	private static int partitionOld(int[] data, int left, int right) {
		int index = (int) (left + Math.random() * (right - left + 1));
		int split = data[index];
		int end = right;
		swap(data, right, index);
		right--;
		while (left < right) {
			if (data[left] >= split && data[right] <= split) {
				swap(data, right, left);
				right--;
			} else if (data[left] > split && data[right] > split) {
				right--;
			} else {
				left++;
			}
		}
		if (data[left] > data[end]) {
			swap(data, end, left);
		}
		return left;
	}

	private static int[] partition(int[] data, int left, int right) {
		int index = (int) (left + Math.random() * (right - left + 1));
		int split = data[index];
		int start = left;
		int end = right;
		swap(data, right, index);
		right--;
		while (left < right) {
			if (data[left] > split && data[right] <= split) {
				swap(data, right, left);
				right--;
			} else if (data[left] > split && data[right] > split) {
				right--;
			} else {
				left++;
			}
		}
		if (data[left] > data[end]) {
			swap(data, end, left);
		}
		for (; start < left; start++) {
			if (data[left] == split) {
				left--;
				start--;
			} else if (data[start] == split) {
				swap(data, start, left);
				left--;
			}
		}
		for (; end > right; end--) {
			if (data[right] == split) {
				right++;
				end++;
			} else if (data[end] == split) {
				swap(data, end, right);
				right++;
			}
		}
		int[] ends = { left, right };
		return ends;
	}

	public static int quickselect(int[] data, int k, int left, int right) {
		if (left == right) {
			return max(data, 0, k);
		}
		int index = partitionOld(data, left, right);
		if (index == k) {
			return max(data, 0, k);
		}
		if (index > k) {
			return quickselect(data, k, left, index);
		}
		return quickselect(data, k, index + 1, right);
	}

	public static int quickselect(int[] data, int k) {
		return quickselect(data, k, 0, data.length - 1);
	}

	public static void quickSortOld(int[] data) {
		quickSortOld(data, 0, data.length - 1);
	}

	public static void quickSortOld(int[] data, int left, int right) {
		if (left < right) {
			int index = partitionOld(data, left, right);
			quickSortOld(data, left, index);
			quickSortOld(data, index + 1, right);
		}
	}

	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	public static void quickSort(int[] data, int left, int right) {
		if (left < right) {
			int[] index = partition(data, left, right);
			quickSort(data, left, index[0]);
			quickSort(data, index[1], right);
		}
	}

	public static void main(String[] args) {
		int[] data = new int[Integer.parseInt(args[0])];
		fillRandom(data);
		if (args[1] == "0") {
			quickSortOld(data);
		}
		if (args[1] == "1") {
			quickSort(data);
		}
		if (args[1] == "2") {
			Arrays.sort(data);
		}
	}
}