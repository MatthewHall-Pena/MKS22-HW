import java.util.NoSuchElementException;

public class FrontierQueue<T> extends MyLinkedList<T> implements Frontier<T> {
	private LNode current = start;

	@Override
	public boolean add(T element) {
		if (super.add(0, element)) {
			current = start;
			return true;
		}
		return false;

	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		T value = current.getValue();
		current = current.getNext();
		remove(0);
		return value;
	}

}