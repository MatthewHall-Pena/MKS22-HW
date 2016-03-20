public class MyLinkedList {
	private LNode start;
	private int size;

	public MyLinkedList() {
		size = 0;
	}

	public MyLinkedList(int nSize) {
		if (nSize > 0) {
			size = nSize;
			start = new LNode(0);
			constructor(nSize, start);
		}
	}

	private void constructor(int nSize, LNode node) {
		if (nSize > 0) {
			LNode Node = new LNode(0);
			node.setNext(Node);
			constructor(nSize - 1, Node);
		}
	}

	public boolean add(int value) {
		if (start == null) {
			start = new LNode(value);
			size += 1;
			return true;
		}
		return add(value, start);
	}

	private boolean add(int value, LNode node) {
		if (node.getNext() == null) {
			LNode nNode = new LNode(value);
			node.setNext(nNode);
			size += 1;
			return true;
		}
		return add(value, node.getNext());
	}

	public boolean add(int index, int value) {
		if (index > size || index < 0) {
			return false;
		}
		if (index == size) {
			return add(value);
		}
		return add(index, value, start);
	}

	private boolean add(int index, int value, LNode node) {
		if (index == 1) {
			LNode nNode = new LNode(value, node.getNext());
			node.setNext(nNode);
			size += 1;
			return true;
		}
		return add(index - 1, value, node.getNext());
	}

	public boolean remove(int index) {
		if (index >= size || index < 0) {
			return false;
		}
		return remove(index, start);
	}

	private boolean remove(int index, LNode node) {
		if (index == 1) {
			node.setNext(node.getNext().getNext());
			size -= 1;
			return true;
		}
		return remove(index - 1, node.getNext());
	}

	public int get(int index) {
		return get(index, start);
	}

	private int get(int index, LNode node) {
		if (index == 0) {
			return node.getValue();
		}
		return get(index - 1, node.getNext());
	}

	public int set(int index, int newValue) {
		return set(index, newValue, start);
	}

	private int set(int index, int value, LNode node) {
		if (index == 0) {
			return node.setValue(value);
		}
		return set(index - 1, value, node.getNext());
	}

	public int size() {
		return size;
	}

	public int indexOf(int value) {
		return indexOf(size, value, start);
	}

	private int indexOf(int index, int value, LNode node) {
		if (index == 0) {
			return -1;
		}
		if (node.getValue() == value) {
			return size - index;
		}
		return indexOf(index - 1, value, node.getNext());
	}

	@Override
	public String toString() {
		return toString(size, start, "[ ") + " ]";
	}

	private String toString(int index, LNode node, String s) {
		if (index == 1) {
			s += node.getValue();
			return s;
		}
		s += node.getValue() + ", ";
		return toString(index - 1, node.getNext(), s);
	}
}
