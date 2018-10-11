import java.util.Scanner;
/**
 * Class for key.
 */
class Key implements Comparable<Key> {
	/**
	 * { Name of the book }.
	 */
	private String bookname;
	/**
	 * { Author of the book }.
	 */
	private String bookauthor;
	/**
	 * { Cost of the book }.
	 */
	private String bookcost;
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      author  The author
	 * @param      cost    The cost
	 */
	Key(String name, String author, String cost) {
		this.bookname = name;
		this.bookauthor = author;
		this.bookcost = cost;
	}
	/**
	 * { To compare names }.
	 *
	 * @param      other  The other
	 *
	 * @return     { int value }
	 */
	public int compareTo(Key other) {
		return this.bookname.compareTo(other.bookname);
	}
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node head = null;
	private int size = 0;
	class Node {
		private Node left;
		private Node right;
		private Key keydata;
		private Value valdata;
		Node(Key keyval, Value val) {
			this.keydata = keyval;
			this.valdata = val;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	void put(Key item, Value itemval) {
		Node newnode = new Node(item, itemval);
		if (isEmpty()) {
			newnode.left = null;
			newnode.right = null;
			head = newnode;
			size++;
			return;
		}
		Node test = head;
		while (!(test.left == null && test.right == null)) {
			int compare = item.compareTo(test.keydata);
			if (compare > 0) {
				if (test.right == null) {
					break;
				}
				test = test.right;
			} else if (compare < 0) {
				if (test.left == null) {
					break;
				}
				test = test.left;
			} else {
				test.valdata = newnode.valdata;
				return;
			}
		}
		int compare = item.compareTo(test.keydata);
		if (compare == 0) {
			test.valdata = newnode.valdata;
			return;
		} else if (compare < 0) {
			test.left = newnode;
			test.left.left = null;
			test.left.right = null;
			size++;
		} else if (compare > 0) {
			test.right = newnode;
			test.right.left = null;
			test.right.right = null;
			size++;
		}
	}
	Value get(Key item) {
		Node test = head;
		while (!(test.left == null && test.right == null)) {
			int compare = item.compareTo(test.keydata);
			if (compare > 0) {
				if (test.right == null) {
					break;
				}
				test = test.right;
			} else if (compare < 0) {
				if (test.left == null) {
					break;
				}
				test = test.left;
			} else {
				break;
			}
		}
		if (item.compareTo(test.keydata) == 0) {
			return test.valdata;
		}
		return null;
	}
}
class Solution {
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree<Key, Integer> bstobj = new BinarySearchTree<>();
		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			switch (tokens[0]) {
			case "put":
				Key newkey = new Key(tokens[1], tokens[2], tokens[3]);
				bstobj.put(newkey, Integer.parseInt(tokens[4]));
				break;
			case "get":
				newkey = new Key(tokens[1], tokens[2], tokens[3]);
				System.out.println(bstobj.get(newkey));
				break;
			default:
				break;
			}
		}
	}
}
