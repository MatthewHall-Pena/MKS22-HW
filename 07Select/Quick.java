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

	private static int partition(int[] data, int left, int right) {
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

	public static int quickselect(int[] data, int k, int left, int right) {
		if (left == right) {
			return max(data, 0, k);
		}
		int index = partition(data, left, right);
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

	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	public static void quickSort(int[] data, int left, int right) {
		if (left < right) {
			int index = partition(data, left, right);
			quickSort(data, left, index);
			quickSort(data, index + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] data = { 0, 0, 2, 0, 0, 0, 0, 1 };
		quickSort(data);
		printArray(data);
	}
}
