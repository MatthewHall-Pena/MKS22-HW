public class LNode<T> {
	private T value=null;
	private LNode next=null;

	public LNode(){
	}
	public LNode(T nValue) {
		value = nValue;
	}

	public LNode(T nValue, LNode nNode) {
		next = nNode;
		value = nValue;
	}

	public T getValue() {
		return value;
	}

	public T setValue(T nValue) {
		T old = value;
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
