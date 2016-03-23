public class MyLinkedList<T> implements Iterable<T>{
	private LNode<T> start = null;
	private int size;
	private LNode<T> end = null;

	public MyLinkedList() {
	}

	public MyLinkedList(int nSize) {
		if (nSize > 0) {
			size = nSize;
			start = new LNode<T>();
			constructor(nSize, start);
		}
	}

	private void constructor(int nSize, LNode<T> node) {
		if (nSize > 0) {
			LNode<T> Node = new LNode<T>();
			node.setNext(Node);
			constructor(nSize - 1, Node);
		}
		end = node;
	}

	public boolean add(T value) {
		if (start == null) {
			start = new LNode<T>(value);
			end = start;
			size += 1;
			return true;
		}
		end.setNext(new LNode<T>(value));
		size += 1;
		end = end.getNext();
		return true;
	}

	public boolean add(int index, T value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size) {
			return add(value);
		}
		if (index == 0) {
			LNode<T> nNode = new LNode<T>(value, start);
			start = nNode;
			size += 1;
			return true;
		}
		return add(index, value, start);
	}

	private boolean add(int index, T value, LNode<T> node) {
		if (index == 1) {
			LNode<T> nNode = new LNode<T>(value, node.getNext());
			node.setNext(nNode);
			size += 1;
			return true;
		}
		return add(index - 1, value, node.getNext());
	}

	public T remove(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			T t = start.getValue();
			start = start.getNext();
			size -= 1;
			return t;
		}
		return remove(index, start);
	}

	private T remove(int index, LNode<T> node) {
		if (index == 1) {
			if (node.getNext().getNext() == null) {
				end = node;
			}
			T t = (T) node.getNext().getValue();
			node.setNext(node.getNext().getNext());
			size -= 1;
			return t;
		}
		return remove(index - 1, node.getNext());
	}

	public T get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return get(index, start);
	}

	private T get(int index, LNode<T> node) {
		if (index == 0) {
			return node.getValue();
		}
		return get(index - 1, node.getNext());
	}

	public T set(int index, T newValue) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == size - 1) {
			return end.setValue(newValue);
		}

		return set(index, newValue, start);
	}

	private T set(int index, T value, LNode<T> node) {
		if (index == 0) {
			return node.setValue(value);
		}
		return set(index - 1, value, node.getNext());
	}

	public int size() {
		return size;
	}

	public int indexOf(T value) {
		return indexOf(size, value, start);
	}

	private int indexOf(int index, T value, LNode<T> node) {
		if (index == 0) {
			return -1;
		}
		if (node.getValue().equals(value)) {
			return size - index;
		}
		return indexOf(index - 1, value, node.getNext());
	}

	@Override
	public String toString() {
		return toString(size, start, "[ ") + " ]";
	}

	private String toString(int index, LNode<T> node, String s) {
		if (index == 1) {
			s += node.getValue();
			return s;
		}
		s += node.getValue() + ", ";
		return toString(index - 1, node.getNext(), s);
	}
	public Iterator<T> iterator(){
	    return new ListIterator();
	}

	public class ListIterator implements Iterator<T>{
	    LNode<T> current=start;
	}
}
  
