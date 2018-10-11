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
		return this.bookauthor.compareTo(other.bookauthor);
	}
	public String toString() {
		String str = "";
		str = str + bookname + bookauthor + bookcost;
		return str;
	}
}
class BinarySearchTree<Key extends Comparable<Key>,Value> {
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
		if (isEmpty()) {
			head = newnode;
			newnode.left = null;
			newnode.right = null;
			size++;
			return;
		}
		Node test = head;
		while (test.left != null && test.right != null) {
			int compare = item.compareTo(test.keydata);
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
		if (compare < 0) {
			test.left = newnode;
			size++;
		} else if (compare > 0) {
			test.right = newnode;
			size++;
		}
	}
	Value get(Key item) {
		Node test = head;
		System.out.println(test.keydata + "name");
		while (test.left != null && test.right != null) {
			System.out.println("entered");
			int compare = item.compareTo(test.keydata);
			System.out.println(compare + "comp");
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