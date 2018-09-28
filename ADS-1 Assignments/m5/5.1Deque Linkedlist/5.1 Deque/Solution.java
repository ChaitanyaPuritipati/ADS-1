import java.util.Scanner;
class Deque<Item> {
	Node left = null;
	Node right = null;
	int size = 0;
	class Node {
		Item data;
		Node next;
		Node(Item inputdata) {
			this.data = inputdata;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	int size() {
		return size;
	}
	void pushLeft(Item inputitem) {
		Node newnode = new Node(inputitem);
		if(isEmpty()) {
			left = newnode;
			right = left;
			size++;
			print();
			return;
		}
		// if (size == 1) {
		// 	right = left;
		// }
		newnode.next = left;
		left = newnode;
		size++;
		print();
	}
	void pushRight(Item inputitem) {
		if (isEmpty()) {
			pushLeft(inputitem);
			return;
		}
		if (size == 1) {
			left = right;
		}
		Node newnode = new Node(inputitem);
		right.next = newnode;
		right = newnode;
		size++;
		print();
	}
	Item popLeft() {
		if (isEmpty()) {
			System.out.println("Deck is empty");
			return null;
		}
		Item leftout = left.data;
		left = left.next;
		size--;
		print();
		return leftout;
	}
	Item popRight() {
		if (isEmpty()) {
			System.out.println("Deck is empty");
			return null;
		}
		Item rightout = right.data;
		Node test = left;
		int counter = 1;
		while (counter < size - 1) {
			test = test.next;
			counter++;
		}
		right = test;
		right.next = null;
		size--;
		print();
		return rightout;
	}
    void print() {
    	if (isEmpty()) {
    		System.out.println("[]");
    		return;
    	}
    	String str = "";
    	str = str + "[";
    	Node test = left;
    	while(test.next != null) {
    		str = str + test.data + ", ";
    		test = test.next;
    	}
    	str = str + right.data;
    	str = str + "]";
    	System.out.println(str);
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