import java.util.Scanner;
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	Key[] keys;
	Value[] values;
	int size;
	BinarySearchTree(int length) {
		keys = (Key[])new Comparable[length];
		values = (Value[]) new Object[length];
		size = 0;
	}
	int rank(Key keyval) {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int compare = keyval.compareTo(keys[mid]);
			if (compare < 0) {
				high = mid - 1;
			} else if (compare > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	Value get(Key keyval) {
		if (!contains(keyval)) {
			return null;
		}
		int rankval = rank(keyval);
		return values[rankval];
	}
	boolean isEmpty() {
		return size == 0;
	}
	boolean contains(Key keyval) {
		int rankval = rank(keyval);
		return keyval.compareTo(keys[rankval]) == 0;
	}
	void put(Key keyval, Value val) {
		int rankval = rank(keyval);
		if (size > 0 && rankval < size && keys[rankval].compareTo(keyval) == 0) {
			values[rankval] = val;
			return;
		}
		for (int i = size; i > rankval; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[rankval] = keyval;
		values[rankval] = val;
		size++;
	}
	Key max() {
		return keys[size - 1];
	}
	void deleteMin() {
		for (int i = 0; i < size - 1; i++) {
			keys[i] = keys[i + 1];
			values[i] = values[i + 1];
		}
		size--;
	}
	void print() {
		for (int i = 0; i < size; i++) {
			System.out.println(keys[i] + " " + values[i]);
		}
	}
	Key floor(Key keyval) {
		int rankval = rank(keyval);
		if (contains(keyval) || rankval == 0) {
			return keyval;
		}
		return keys[rankval - 1];
	}
}
class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array = scan.nextLine().split(" ");
		BinarySearchTree binobj = new BinarySearchTree(array.length);
		for (int i = 0; i < array.length; i++) {
			binobj.put(array[i], i);
		}
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "contains":
				System.out.println(binobj.contains(tokens[1]));
				break;
			case "max":
			    System.out.println(binobj.max());
			    break;
			case "deleteMin":
			    binobj.deleteMin();
			    break;
			case "rank":
			    System.out.println(binobj.rank(tokens[1]));
			    break;
			case "floor":
			    System.out.println(binobj.floor(tokens[1]));
			    break;
			case "keys":
			    binobj.print();
			    break;
			case "get":
			    System.out.println(binobj.get(tokens[1]));
			    break;
			default:
			    break;    
			}
		}
		// String[] tokens = str.split(" ");
		// for(int i = 0; i < tokens.length; i++) {
		// 	binobj.put(tokens[i], i);
		// }
		// binobj.print();
		// System.out.println(binobj.max());
		// binobj.deleteMin();
		// binobj.print();
		// System.out.println(binobj.get("A"));
		// System.out.println(binobj.floor("I"));
	}
}