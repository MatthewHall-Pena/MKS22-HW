import java.util.NoSuchElementException;

public class BSTree<T extends Comparable<T>> {
	private class Node {
		T data;
		Node left;
		Node right;

		public Node(T value) {
			data = value;
		}

		public int getHeight() {
			int r = 0;
			int l = 0;
			if (right != null) {
				r = right.getHeight();
			}
			if (left != null) {
				l = left.getHeight();
			}
			if (r >= l) {
				return r + 1;
			}
			return l + 1;
		}

		public void add(T value) {
			if (data.compareTo(value) > 0) {
				if (right == null) {
					right = new Node(value);
				} else {
					right.add(value);
				}
			} else {
				if (left == null) {
					left = new Node(value);
				} else {
					left.add(value);
				}
			}

		}

		@Override
		public String toString() {
			if (left != null && right != null) {
				return "" + data + left.toString() + right.toString();
			}
			if (left == null && right != null) {
				return "" + data + "_" + right.toString();
			}
			if (left != null && right == null) {
				return "" + data + left.toString() + "_";
			}
			return "" + data + "_" + "_";
		}

		public boolean contains(T value) {
			if (data.compareTo(value) != 0 && left == null && right == null) {
				return false;
			} else if ((left != null && left.data.compareTo(value) == 0)
					|| (right != null && right.data.compareTo(value) == 0)) {
				return true;
			} else if (left != null && (right == null || right.data.compareTo(value) > 0)) {
				return left.contains(value);
			} else if (right != null && (left == null || left.data.compareTo(value) < 0)) {
				return right.contains(value);
			}
			return false;
		}

		public T remove(T value) {
			if (data.compareTo(value) == 0) {
				T temp = data;
				int rHeight = 0;
				int lHeight = 0;
				if (right != null) {
					rHeight = right.getHeight();
				}
				if (left != null) {
					lHeight = left.getHeight();
				}
				System.out.println(right);
				System.out.println(left);
				System.out.println();
				if (left == null || (right != null && rHeight >= lHeight)) {
					data = right.data;
					if (rHeight > 1) {
						right.remove(right.data);
					} else {
						right = null;
					}
					return temp;
				}
				data = left.data;
				if (lHeight > 1) {
					left.remove(left.data);
				} else {
					left = null;
				}
				return temp;
			} else if (data.compareTo(value) != 0 && left == null && right == null) {

				throw new NoSuchElementException();

			} else if (right != null && right.data.compareTo(value) == 0 && right.getHeight() == 1) {
				right = null;
				return value;
			} else if (left != null && left.data.compareTo(value) == 0 && left.getHeight() == 1) {
				left = null;
				return value;
			} else if (right == null
					|| (left != null && (left.data.compareTo(value) == 0 || right.data.compareTo(value) > 0))) {

				return left.remove(value);

			} else if (left == null
					|| (right != null && (right.data.compareTo(value) == 0 || left.data.compareTo(value) < 0))) {

				return right.remove(value);

			}
			throw new NoSuchElementException();

		}
	}

	private Node root = null;

	public int getHeight() {
		if (root == null) {
			return 0;
		}
		return root.getHeight();
	}

	public void add(T value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.add(value);
		}
	}

	@Override
	public String toString() {
		if (root == null) {
			return "";
		}
		return root.toString();
	}

	public T remove(T value) {
		if (root == null) {
			throw new NoSuchElementException();
		}
		if (root.data.compareTo(value) == 0 && root.getHeight() == 1) {
			root = null;
			return value;
		}
		return root.remove(value);
	}

	public boolean contains(T value) {
		if (root == null) {
			return false;
		}
		return root.contains(value);
	}
}
