
import java.util.*;
public class MyQueue<T> {
	private MyLinkedList<T> list = new MyLinkedList<T>();
	public void enqueue(T value) {
		list.add(value);
	}

	public T dequeue() {
		return list.remove(0);
	}

	public T peek() {
		return list.get(0);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public static void main(String[]args){
	    MyQueue<Double> queue =new MyQueue<Double>();
	    Queue<Double> queue2 =new Queue<Double>();
	    for(int x=0;x<10000;x++){
		queue.enqueue(Math.random());
		queue2.enqueue(Math.random());
	    }
	    for(int x=0;x<10000;x++){
		queue.dequeue(Math.random());
		queue2.dequeue(Math.random());
	    }
	    
	}
}
