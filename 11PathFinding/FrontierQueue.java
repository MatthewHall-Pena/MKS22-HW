import java.util.LinkedList;

public class FrontierQueue<T> extends LinkedList<T> implements Frontier<T> {

	@Override
	public boolean add(T element) {
		super.addFirst(element);
		return true;
	}

	@Override
	public boolean hasNext() {
		return super.peekLast() != null;
	}

	@Override
	public T next() {
		return removeLast();
	}
}