import java.util.Scanner;
class Key implements Comparable<Key> {
	String bookname;
	String bookauthor;
	String bookcost;
	Key(String name, String author, String cost) {
		this.bookname = name;
		this.bookauthor = author;
		this.bookcost = cost;
	}
	public int compareTo(Key other) {
		return this.bookname.compareTo(other.bookname);
	}
	public String toString() {
		String str = "";
		str = str + bookname + bookauthor + bookcost;
		return str;
	}
}
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	Node head = null;
	int size = 0;
	class Node {
		Node left;
		Node right;
		Key keydata;
		Value valdata;
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
		// System.out.println(newnode.keydata + "keyval");
		if (isEmpty()) {
			head = newnode;
			head.left = null;
			head.right = null;
			size++;
			return;
		}
		Node test = head;
		while (test.left != null && test.right != null) {
			int compare = item.compareTo(test.keydata);
			// System.out.println(compare + "inside while");
			if (compare > 0) {
				test = test.right;
			} else if (compare < 0) {
				test = test.left;
			} else {
				test.valdata = newnode.valdata;
				return;
			}
		}
		int compare = item.compareTo(test.keydata);
		// System.out.println(compare + "compare in put");
		if (compare < 0) {
			test.left = newnode;
			test.right.left = null;
			test.right.right = null;
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
		System.out.println(head.left.keydata + "left");
		System.out.println(head.right.keydata + "right");
		while (test.left != null && test.right != null) {
			System.out.println(test.keydata + "testprint");
			int compare = item.compareTo(test.keydata);
			// System.out.println(compare + "comp");
			if (compare > 0) {
				test = test.right;
			} else if (compare < 0) {
				test = test.left;
			} else {
				return test.valdata;
			}
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