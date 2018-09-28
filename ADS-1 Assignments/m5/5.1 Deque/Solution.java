import java.util.Arrays;
import java.util.Scanner;
class Deque<Item> {
	int left;
	int right;
	Item[] elements;
	int size;
	Deque() {
		final int twenty = 20;
		// elements = new Item[20];
		elements = (Item[])new Object[20];
		left = 0;
		right = 0;
	}
	boolean isEmpty() {
		return right == 0;
	}
	int size() {
		return right;
	}
	void pushLeft(Item inputitem) {
		if (size == elements.length) {
			resize();
		}
		for (int i = right - 1; i >= 0; i--) {
			elements[i + 1] = elements[i];
		}
		elements[left] = inputitem;
		right++;
		System.out.println(Arrays.toString(elements));
	}
	void pushRight(Item inputitem) {
		if (right == elements.length) {
			resize();
		}
		elements[right] = inputitem;
		right++;
		System.out.println(Arrays.toString(elements));
	}
	Item popLeft() {
		if (isEmpty()) {
			return null;
		}
		System.out.println(right + "right value");
		Item removeditem = elements[left];
		for (int i = 0; i < right; i++) {
			elements[i - 1] = elements[i];
		}
		right--;
		System.out.println(Arrays.toString(elements));
		return removeditem;
	}
	Item popRight() {
		if (isEmpty()) {
			return null;
		}
		Item removeditem = elements[right - 1];
		right--;
		System.out.println(Arrays.toString(elements));
		return removeditem;
	}
	void resize() {
		elements = Arrays.copyOf(elements, 2 * right);
	}
}
class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Deque<Integer> dequeobj = new Deque<Integer>();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			switch (tokens[0]) {
			case "pushLeft":
				dequeobj.pushLeft(Integer.parseInt(tokens[1]));
				break;
			case "pushRight":
				dequeobj.pushRight(Integer.parseInt(tokens[1]));
				break;
			case "size":
				System.out.println(dequeobj.size());
				break;
			case "popRight":
				dequeobj.popRight();
				break;
			case "popLeft":
				dequeobj.popLeft();
				break;
			default:
			}
		}
	}
}