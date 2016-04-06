import java.util.NoSuchElementException;

public class MyDeque<T> {
	private T[] data;
	private int size = 0;
	private int start;
	private int end;

	@SuppressWarnings("unchecked")
	public MyDeque() {
		data = (T[]) new Object[10];
		start = data.length / 2;
		end = start + 0;
	}

	@SuppressWarnings("unchecked")
	public MyDeque(int length) {
		data = (T[]) new Object[length];
		start = data.length / 2;
		end = start;
	}

	private void printArray(T[] data2) {
		String s = "[ ";
		for (int x = 0; x < data2.length; x++) {
			s += data2[x];
			if (x + 1 != data2.length) {
				s += ", ";
			}
		}
		s += "]";
		System.out.println(s);
	}

	@SuppressWarnings("unchecked")
	private void grow() {
		T[] ndata = (T[]) new Object[data.length * 2];
		if (start == end) {
			ndata[ndata.length / 2] = data[0];
			start = ndata.length / 2;
			end = ndata.length / 2;
		} else if (start > end) {
			int x;
			for (x = 0; x < end + 1; x++) {
				ndata[x] = data[x];
			}
			for (x = end + 1; x < size; x++) {
				ndata[x + ndata.length - size] = data[x];
			}
			start = end + ndata.length - size + 1;
		}
		data = ndata;
	}

	public void addFirst(T value) {
		if (size == data.length) {
			grow();
		}
		if (start == end && size == 0) {
		} else if (start - 1 >= 0) {
			start -= 1;
		} else {
			start = data.length - 1;
		}
		data[start] = value;
		size += 1;
	}

	public void addLast(T value) {
		if (size == data.length) {
			grow();
		}
		if (end + 1 < data.length) {
			end += 1;
		} else {
			end = 0;
		}
		data[end] = value;
		size += 1;
	}

	public T removeFirst() {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		size -= 1;
		if (start + 1 < data.length) {
			start += 1;
			return data[start - 1];
		}
		start = 0;
		return data[data.length - 1];
	}

	public T removeLast() {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		size -= 1;
		if (end - 1 >= 0) {
			end -= 1;
			return data[end + 1];
		}
		end = data.length - 1;
		return data[0];
	}

	public T getFirst() {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		return data[start];
	}

	public T getLast() {
		if (size <= 0) {
			throw new NoSuchElementException();
		}
		return data[end];
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MyDeque<Integer> d = new MyDeque<Integer>();
		int length = 50;
		for (int x = 0; x < length; x++) {
			d.addFirst(x);
		}
		for (int x = 0; x < d.size() + x; x++) {
			System.out.println(d.getFirst());
			d.removeFirst();
		}

	}
}
