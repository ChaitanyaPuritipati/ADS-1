import java.util.Scanner;
class Josephus {
	Node first = null;
	Node last = null;
	int size = 0;
	class Node {
		int data;
		Node next;
		Node(int inputdata) {
			this.data = inputdata;
		}
	}
	boolean isEmpty() {
		return size == 0;
	}
	void push(int item) {
		Node newnode = new Node(item);
		if (isEmpty()) {
			newnode.next = first;
			first = newnode;
			last = first;
			size++;
			return;
		}
		last.next = newnode;
		last = newnode;
		last.next = first;
		size++;
	}
	void pop(int index, int sizeval) {
		Node test = first;
		String str = "";
		while (sizeval > 0) {
			int counter = 0;
			if(sizeval == 1) {
				str = str + test.data;
				System.out.println(str);
				return;
			}
			while (counter < index - 2) {
				test = test.next;
				counter++;
			}
			if (sizeval == 1) {
				str = str + test.data + " ";
				sizeval--;
			} else if (test.next == last) {
				str = str + test.next.data + " ";
				last = test;
				last.next = first;
				test = first;
				sizeval--;
			} else {
				if (test.next == first) {
					str = str + first.data + " ";
					first = first.next;
					last.next = first;
					test = first;
				} else {
					str = str + test.next.data + " ";
					test.next = test.next.next;
					test = test.next;
				}
				sizeval--;
			}
		}
		str = str.trim();
		System.out.println(str);
	}
}
class Solution {
	Solution() {
		//unused;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testnum = Integer.parseInt(scan.nextLine());
		for (int k = 0; k < testnum; k++) {
			Josephus start = new Josephus();
			String[] tokens = scan.nextLine().split(" ");
			for (int i = 0; i < Integer.parseInt(tokens[0]); i++) {
				start.push(i);
			}
			start.pop(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[0]));
		}
	}
}