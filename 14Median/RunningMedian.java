import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class RunningMedian {
	private MyHeap tiny;
	private MyHeap big;

	public RunningMedian() {
		tiny = new MyHeap<Integer>(true);
		big = new MyHeap<Integer>(false);
	}

	public double getMedian() {
		System.out.println(tiny.toString());
		if (tiny.size() < 1) {
			throw new NoSuchElementException();
		}
		if (tiny.size() > big.size()) {
			return (int) tiny.peek();
		}
		return ((int) tiny.peek() + (int) big.peek()) / 2.;
	}

	public void add(Integer x) {
		if (tiny.size() - big.size() == 0) {
			tiny.add(x);
		} else if (tiny.size() - big.size() == 1) {
			tiny.add(x);
			big.add(tiny.delete(tiny.peek()));
			if ((int) tiny.peek() > (int) big.peek()) {
				Integer y = (int) big.peek();
				big.add(tiny.delete(tiny.peek()));
				tiny.add(big.delete(y));
			}
		}
		if (tiny.size() > 0 && big.size() > 0 && (int) tiny.peek() > (int) big.peek()) {
			Integer y = (int) big.peek();
			big.add(tiny.delete(tiny.peek()));
			tiny.add(big.delete(y));
		}
	}

}
