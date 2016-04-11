import java.util.NoSuchElementException;

public class FrontierStack<T> extends MyLinkedList<T> implements Frontier<T> {
	private LNode current = end;

	@Override
	public boolean add(T element) {
		if (super.add(0, element)) {
			current = end;
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
		current = current.getPrev();
		remove(size() - 1);
		return value;
	}

}