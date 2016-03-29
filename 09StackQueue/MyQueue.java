
public class MyQueue<T> {
	private MyLinkedList<T> list = new MyLinkedList<T>();

	public void enqueue(T value) {
		list.add(value);
	}

	public T dequeue() {
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
