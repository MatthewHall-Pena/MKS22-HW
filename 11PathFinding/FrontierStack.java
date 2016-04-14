import java.util.LinkedList;

public class FrontierStack<T> extends LinkedList<T> implements Frontier<T> {

	@Override
	public boolean add(T element) {
		super.addFirst(element);
		return true;
	}

	@Override
	public boolean hasNext() {
		return super.peekFirst() != null;
	}

	@Override
	public T next() {
		return removeFirst();
	}
}