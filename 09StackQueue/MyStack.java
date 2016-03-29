import java.util.*;
public class MyStack<T> {
	private MyLinkedList<T> list = new MyLinkedList<T>();
	public MyStack(){
	    list = new MyLinkedList<T>();
	}
	public void push(T value) {
		list.add(0, value);
	}

	public T pop() {
	    if(isEmpty()){
		throw new NoSuchElementException();
	    }
		return list.remove(0);
	}

	public T peek() {
	    if(isEmpty()){
		throw new NoSuchElementException();
	    }
		return list.get(0);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}
}
