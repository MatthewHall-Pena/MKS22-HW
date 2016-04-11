import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
	protected class LNode {
		private T value;
		private LNode next;
		private LNode prev;

		public LNode(T v) {
			value = v;
		}

		public T getValue() {
			return value;
		}

		public LNode getNext() {
			return next;
		}

		public LNode getPrev() {
			return prev;
		}

		public T setValue(T v) {
			T old = value;
			value = v;
			return old;
		}

		public void setNext(LNode n) {
			next = n;
		}

		public void setPrev(LNode n) {
			prev = n;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	LNode start;
	LNode end;
	int size;

	@Override
	public Iterator<T> iterator() {
		// This uses an anonymous class! You don't need to know this.
		return new Iterator<T>() {
			private LNode current = start;

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
				return value;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public Iterator<T> iteratorBack() {
		// This uses an anonymous class! You don't need to know this.
		return new Iterator<T>() {
			private LNode current = end;

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
				return value;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public String toString() {
		String ans = "[";
		LNode p = start;
		while (p != null) {
			ans += p.getValue();
			if (p.getNext() != null) {
				ans += ", ";
			}
			p = p.getNext();
		}
		return ans + "]";
	}

	public String toString(boolean b) {
		return toString() + " start: " + start + ", end: " + end;
	}

	private LNode getNth(int index) {
		if (size / 2 < index) {
			LNode temp = end;
			while (size - 1 > index) {
				temp = temp.getPrev();
				index++;
			}
			return temp;
		}
		LNode temp = start;
		while (index > 0) {
			temp = temp.getNext();
			index--;
		}
		return temp;
	}

	public boolean add(T value) {
		return add(size, value);
	}

	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
		}
		LNode temp;
		if (index == 0) {
			temp = start;
			start = start.getNext();
			if (start == null) {
				end = null;
			} else {
				start.setPrev(null);
			}
		} else {
			LNode p = getNth(index - 1);
			temp = p.getNext();
			p.setNext(p.getNext().getNext());
			if (end == temp) {
				end = p;
			} else {
				p.getNext().setPrev(p);
			}
		}
		size--;
		return temp.getValue();
	}

	public boolean add(int index, T value) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index " + index + ", Size: " + size());
		}
		LNode temp = new LNode(value);
		if (index == 0) {
			temp.setNext(start);
			if (size == 0) {
				start = temp;
				end = start;
			} else {
				start.setPrev(temp);
				start = temp;
			}
		} else {
			LNode p = getNth(index - 1);
			if (index != size) {
				p.getNext().setPrev(temp);
			}
			temp.setNext(p.getNext());
			temp.setPrev(p);
			p.setNext(temp);
			if (end.getNext() != null) {
				end = end.getNext();
			}
		}
		size++;
		return true;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + ", Size: " + size());
		}
		return getNth(index).getValue();
	}

	public T set(int index, T newValue) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("Index " + index + ", Size: " + size());
		}
		return getNth(index).setValue(newValue);
	}

	public int indexOf(T target) {
		LNode temp = start;
		int index = 0;
		while (temp != null) {
			if (temp.getValue().equals(target)) {
				return index;
			}
			index++;
			temp = temp.getNext();
		}
		return -1;
	}

}
