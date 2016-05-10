
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
	private int size;
	private T[] data;
	private int max = 1;

	public MyHeap() {
		size = 0;
		data = (T[]) new Comparable[10];
	}

	public MyHeap(T[] array) {
		size = array.length;
		data = (T[]) new Comparable[array.length];
		System.arraycopy(array, 0, data, 0, array.length);
		heapify();
	}

	public MyHeap(boolean isMax) {
		if (!isMax) {
			max = -1;
		}
		size = 0;
		data = (T[]) new Comparable[10];
	}

	public MyHeap(T[] array, boolean isMax) {
		if (!isMax) {
			max = -1;
		}
		size = array.length;
		data = (T[]) new Comparable[array.length];
		System.arraycopy(array, 0, data, 0, array.length);
		heapify();
	}

	private void swap(int k, int n) {
		T temp = data[k];
		data[k] = data[n];
		data[n] = temp;
	}

	private void down(int k) {
		if (k * 2 < size) {
			if (data[k * 2].compareTo(data[k]) * max > 0
					&& (k * 2 + 1 >= size || data[k * 2].compareTo(data[k * 2 + 1]) * max > 0)) {
				swap(k, k * 2);
				down(k * 2);
			} else if (k * 2 + 1 < size && (data[k * 2 + 1].compareTo(data[k]) * max > 0)) {
				swap(k, k * 2 + 1);
				down(k * 2 + 1);
			}

		}
	}

	private void up(int k) {
		if (k / 2 >= 0 && data[k / 2].compareTo(data[k]) * max < 0) {
			swap(k, k / 2);
			up(k / 2);
		}
	}

	private void heapify() {
		for (int x = size - 1; x >= 0; x--) {
			down(x);
		}
	}

	private int indexOf(T elem, int index) {
		int loc = -1;
		if (index >= size || elem.compareTo(data[index]) * max > 0) {
			return -1;
		}
		if (elem.compareTo(data[index]) * max == 0) {
			return loc;
		}
		if (index * 2 < size && elem.compareTo(data[index * 2]) * max <= 0) {
			loc = indexOf(elem, index * 2);
			if (loc != -1) {
				return loc;
			}
		}
		if (index * 2 + 1 < size && elem.compareTo(data[index * 2 + 1]) * max <= 0) {
			loc = indexOf(elem, index * 2 + 1);
			if (loc != -1) {
				return loc;
			}
		}
		return -1;
	}

	private T delete(T x, int loc) {
		int index = indexOf(x, loc);
		if (index * 2 > size) {
			for (int y = index; y < size - 1; y++) {
				swap(y, y + 1);
			}
			for (int y = index; y < size - 1; y++) {
				up(y);
			}
		} else if (index * 2 < size
				&& (index * 2 + 1 > size || data[index * 2].compareTo(data[index * 2 + 1]) * max > 0)) {
			swap(index, index * 2);
			return delete(x, index * 2);
		} else if (index * 2 + 1 < size && data[index * 2 + 1].compareTo(data[index * 2]) * max > 0) {
			swap(index, index * 2 + 1);
			return delete(x, index * 2 + 1);
		}
		size -= 1;
		return x;
	}

	public T delete(T x) {
		return delete(x, 0);
	}

	public void add(T n) {
		if (size == data.length) {
			grow();
		}
		data[size] = n;
		size += 1;
		up(size - 1);
	}

	private void grow() {
		T[] ndata = (T[]) new Comparable[data.length * 2];
		for (int x = 0; x < data.length; x++) {
			ndata[x] = data[x];
		}
		data = ndata;

	}

	@Override
	public String toString() {
		String str = "[ ";
		for (int x = 0; x < size - 1; x++) {
			str += data[x] + ", ";
		}
		str += data[size - 1] + "]";
		return str;
	}

}
