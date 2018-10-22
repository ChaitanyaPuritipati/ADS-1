import java.util.Scanner;
class Key implements Comparable<Key> {
	private String bookname;
	private String bookauthor;
	private String bookprice;
	Key(String name, String author, String price) {
		this.bookname = name;
		this.bookauthor = author;
		this.bookprice = price;
	}
	public String getname() {
		return this.bookname;
	}
	public String getauthor() {
		return this.bookauthor;
	}
	public String getprice() {
		return this.bookprice;
	}
	public int compareTo(Key other) {
		if (this.getname().compareTo(other.getname()) > 0) {
			return 1;
		}
		if (this.getname().compareTo(other.getname()) < 0) {
			return -1;
		}
		return 0;
	}
}
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node head;
	private int size;
	class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		Node(Key keyval, Value val) {
			this.key = keyval;
			this.value = val;
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public Value get(Key item) {
		if (isEmpty()) {
			return null;
		}
		Node test = head;
		while (!(test.left == null && test.right == null)) {
			if (item.compareTo(test.key) == 0) {
				return test.value;
			} else if (item.compareTo(test.key) > 0) {
				test = test.right;
			} else {
				test = test.left;
			}
		}
		return null;
	}
	public void put(Key item, Value itemval) {
		Node newnode = new Node(item, itemval);
		if (isEmpty()) {
			head = newnode;
			size++;
			return;
		}
		Node test = head;
		while (!(test.left == null && test.right == null)) {
			if (item.compareTo(test.key) > 0) {
				test = test.right;
			} else if (item.compareTo(test.key) < 0) {
				test = test.left;
			} else {
				test.value = newnode.value;
				return;
			}
		}
		if (item.compareTo(test.key) > 0) {
			test.right = newnode;
			size++;
		} else if (item.compareTo(test.key) < 0) {
			test.left = newnode;
			size++;
		} else {
			test.value = newnode.value;
		}
	}
}
class Solution {
	Solution() {
		//unused
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
			}
		}
	}
}