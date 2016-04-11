public interface Frontier<T> {
	public boolean add(T element);

	public T next();

	public boolean hasNext();

}
