import java.util.Scanner;
class BinarysearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] values;
	private int size;
	BinarysearchST(int length) {
		keys = (Key[]) new Comparable[length];
		values = (Value[]) new Object[length];
		size = 0;
	}
	void put(Key item, Value itemval) {
		if (item == null) {
			System.out.println("key is null");
		}
		if (itemval == null) {
			delete(item);
			return;
		}
		int rankval = rank(item);
		if (rankval < size && keys[rankval].compareTo(item) == 0) {
			values[rankval] = itemval;
			return;
		}
		for (int j = size; j > 1; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[rankval] = item;
		values[rankval] = itemval;
		size++;
	}
	int rank(Key item) {
		if (item == null) {
			System.out.println("key is null");
		}
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int compare = item.compareTo(keys[mid]);
			System.out.println(compare + "comp");
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
	boolean contains(Key item) {
		if (item == null) {
			System.out.println("key is null");
		}
		return get(item) != null;
	}
	Value get(Key item) {
		if (item == null) {
			System.out.println("key is null");
		}
		if (isEmpty()) {
			return null;
		}
		int rankval = rank(item);
		if (rankval < size && keys[rankval].compareTo(item) == 0) {
			return values[rankval];
		}
		return null;
	}
	boolean isEmpty() {
		return size == 0;
	}
	Key floor(Key item) {
		int rankval = rank(item);
		if (rankval < size && item.compareTo(keys[rankval]) == 0) {
			return keys[rankval];
		}
		if (rankval == 0) {
			return null;
		} else {
			return keys[rankval - 1];
		}
	}
	void delete(Key item) {
		if (item == null) {
			System.out.println("key is null");
		}

		int rankval = rank(item);
		if (rankval == size || keys[rankval].compareTo(item) != 0) {
			return;
		}
		for (int j = rankval; j < size - 1; j++)  {
			keys[j] = keys[j + 1];
			values[j] = values[j + 1];
		}
		size--;
		keys[size] = null;
		values[size] = null;
	}
	Key max() {
		if (isEmpty()) {
			System.out.println("No elements are available in the Symbol table");
		}
		return keys[size - 1];
	}
	void deleteMin() {
		if (isEmpty()) {
			System.out.println("No elements are available in the Symbol table to perform deletion");
		}
		delete(min());
	}
	Key min() {
		if (isEmpty()) {
			System.out.println("empty symbol table");
		}
		return keys[0];
	}
	String keys() {
		String str = "";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			if (keys[i] != null) {
				str += keys[i] + " " + values[i] + "\n";
			}
		}
		str += keys[size - 1] + " " + values[size - 1];
		return str;
	}
}
class Solution {
	private Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array = scan.nextLine().split(" ");
		BinarysearchST binobj = new BinarysearchST(array.length);
		for (int i = 0; i < array.length; i++) {
			binobj.put(array[i], i);
		}
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "get":
				System.out.println(binobj.get(tokens[1]));
				break;
			case "max":
				System.out.println(binobj.max());
				break;

			case "floor":
				System.out.println(binobj.floor(tokens[1]));
				break;

			case "rank":
				System.out.println(binobj.rank(tokens[1]));
				break;

			case "contains":
				System.out.println(binobj.contains(tokens[1]));
				break;

			case "deleteMin":
				binobj.deleteMin();
				break;

			case "keys":
				System.out.println(binobj.keys());
				break;

			default:
				break;
			}
		}
	}
}