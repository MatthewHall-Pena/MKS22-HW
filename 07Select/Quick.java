import java.util.Random;

public class Quick {
	private static int partition(int[] data, int left, int right) {
		Random r = new Random();
		int index = left + r.nextInt() % ((right - left + 1) / 2) + (right - left + 1) / 2;
		int split = data[index];
		int old = 0;
		int end = 0;
		end += right;
		old = data[right];
		data[right] = data[index];
		data[index] = old;
		while (left != right) {
			if (data[left] > split) {
				old = data[right];
				data[right] = data[left];
				data[left] = old;
				right -= 1;
			} else if (data[right] < split) {
				old = data[right];
				data[right] = data[left];
				data[left] = old;
				left += 1;
			} else {
				left += 1;

			}
		}
		return left;
	}

	public static int quickselect(int[] data, int k) {
		int left = 0;
		int right = data.length - 1;
		int index = 0;
		while (right > k) {
			index = partition(data, left, right);
			if (index == right) {
				right -= 1;
			} else if (index >= k) {
				right = index;
			} else if (index < k) {
				left = index;

			}
		}
		int max = data[left];
		for (int x = left + 1; x < right + 1; x++) {
			if (data[x] > max) {
				max = data[x];
			}
		}
		return max;
	}
}
