import java.util.Arrays;
class Stack {
	final int twenty = 20;
	String[] paranthesis;
	int size;
	Stack() {
		paranthesis = new String[twenty];
		size = 0;
	}
	public void resize() {
		paranthesis = Arrays.copyOf(paranthesis, 2 * size);
	}
	public void push(String input) {
		if (size == paranthesis.length) {
			resize();
		}
		paranthesis[size] = input;
		size++;
	}
	public String pop() {
		String item = paranthesis[size - 1];
		size--;
		return item;
	}
	public boolean isEmpty() {
		return size == 0;
	}
}