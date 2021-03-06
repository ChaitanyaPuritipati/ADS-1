import java.util.Scanner;
class Steque {
	Node left = null;
	Node right = null;
	int size = 0;
	class Node {
		int  data;
		Node next;
		Node(int inputdata) {
			this.data = inputdata;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	int size() {
		return size;
	}
	void push(int inputitem) {
		Node newnode = new Node(inputitem);
		if (isEmpty()) {
			left = newnode;
			right = left;
			size++;
			print();
			return;
		}
		newnode.next = left;
		left = newnode;
		size++;
		print();
	}
	void enqueue(int inputitem) {
		if (isEmpty()) {
			push(inputitem);
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
	int pop() {
		int leftout = left.data;
		left = left.next;
		size--;
		print();
		return leftout;
	}
	void print() {
		if (isEmpty()) {
			System.out.println("Steque is empty.");
			return;
		}
		String str = "";
		Node test = left;
		while (test.next != null) {
			str = str + test.data + ", ";
			test = test.next;
		}
		str = str + right.data;
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