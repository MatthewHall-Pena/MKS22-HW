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
		end = start;
	}

	@SuppressWarnings("unchecked")
	public MyDeque(int length) {
		data = (T[]) new Object[length];
		start = data.length / 2;
		end = start;
	}

	@SuppressWarnings("unchecked")
	private void grow() {
		T[] ndata = (T[]) new Object[data.length * 2];
		for (int x = 0; x < size; x++) {
			ndata[x + ndata.length - size] = data[x];
		}
		data = ndata;
	}

	public void addFirst(T value) {
		if (size == data.length) {
			grow();
		}
		if (start - 1 >= 0) {
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
	
	public int size(){
	    return size;
	}
	public static void main(String[]args){
	    MyDeque<Integer> d=new MyDeque();
	    int length=30;
	    for(int x=0;x<length;x++){
		d.addFirst(x);
	    }
	    for(int x=0;x<d.size()+x;x++){
		System.out.println(d.getFirst());
		d.removeFirst();
	    }
	   
	}
}
