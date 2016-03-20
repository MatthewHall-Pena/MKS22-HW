public class LNode {
	private int value;
	private LNode next;

	public LNode(int nValue) {
		value = nValue;
	}

	public LNode(int nValue, LNode nNode) {
		next = nNode;
		value = nValue;
	}

	public int getValue() {
		return value;
	}

	public int setValue(int nValue) {
		int old = value;
		value = nValue;
		return old;
	}

	public LNode getNext() {
		return next;
	}

	public LNode setNext(LNode nNode) {
		LNode old = next;
		next = nNode;
		return old;
	}
}
