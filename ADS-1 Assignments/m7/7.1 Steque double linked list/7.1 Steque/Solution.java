import java.util.Scanner;
class Steque {
	Node head = null;
	Node tail = null;
	int size = 0;
	class Node {
		int nodedata;
		Node prevnode;
		Node nextnode;
		Node(int data) {
			nodedata = data;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	void push(int item) {
		Node newnode = new Node(item);
		if (isEmpty()) {
			newnode.nextnode = head;
			newnode.prevnode = head;
			head = newnode;
			tail = head;
			size++;
			print();
			return;
		}
		newnode.nextnode = head;
		newnode.prevnode = head.prevnode;
		head.prevnode = newnode;
		head = newnode;
		size++;
		print();
	}
	void enqueue(int item) {
		Node newnode = new Node(item);
		if (isEmpty()) {
			newnode.nextnode = tail;
			newnode.prevnode = tail;
			tail = newnode;
			head = tail;
			size++;
			print();
			return;
		}

		// newnode.nextnode = tail.nextnode;
		// newnode.prevnode = tail;
		// tail.nextnode = newnode;
		Node old = tail;
		tail = newnode;

		tail.nextnode = null;
		old.nextnode = tail;
		tail.prevnode = old; 
		size++;
		print();
	}
	void pop() {
		// if (isEmpty()) {
			
		// 	System.out.println("Steque is empty.");
		// 	return;
		// }

		int result = head.nodedata;
		if(head == tail) {
			System.out.println("equal");
		}
		System.out.println(tail.nodedata);
		System.out.println(head.nodedata + " before" );
		head = head.nextnode;
		System.out.println(tail.nodedata + " aftere" );
		size--;
		print();
	}
	void print() {
		if (isEmpty()) {
			// System.out.println(tail.nodedata + "hello");
			System.out.println("Steque is empty.");
			return;
		}
		String str = "";
		Node test = head;
		while (test.nextnode != null) {
			str = str + test.nodedata + ", ";
			test = test.nextnode;
		}
		str = str + test.nodedata;
		System.out.println(str);
	}
}
class Solution {
	Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testnum = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testnum; i++) {
			Steque steque = new Steque();
			while (scan.hasNext()) {
				String line = scan.nextLine();
				if (!line.isEmpty()) {
					String[] tokens = line.split(" ");
					switch (tokens[0]) {
					case "push":
						steque.push(Integer.parseInt(tokens[1]));
						break;
					case "enqueue":
						steque.enqueue(Integer.parseInt(tokens[1]));
						break;
					case "pop":
						if (steque.isEmpty()) {
							System.out.println("Steque is empty.");
							break;
						}
						steque.pop();
						break;
					default:
						break;
					}
				} else {
					System.out.println();
					break;
				}
			}
		}
	}
}