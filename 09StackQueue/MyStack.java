
public class MyStack<T> {
	private MyLinkedList<T> list = new MyLinkedList<T>();

	public void push(T value) {
		list.add(0, value);
	}

	public T pop() {
		return list.remove(0);
	}

	public T peek() {
		return list.get(0);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}
}
