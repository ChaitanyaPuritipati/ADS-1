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
			// System.out.println(last.data + "last val");
			// System.out.println(this.size + "size");
			int counter = 0;
			while (counter < index - 2) {
				test = test.next;
				counter++;
			}
			// System.out.println(test.data + "after while");
			// System.out.println(test.data +"data");
			// System.out.println(last.data + "last data");
			// System.out.println(test.data + "next data");
			// System.out.println();
			if (test.next == last) {
				// System.out.println(last.data + "last val");
				// System.out.println("entered");
				str += test.next.data;
				last = test;
				// System.out.println(test.data + "hello");
				last.next = first;
				test = first;
				sizeval--;
			} else {
				str += test.next.data;
				test.next = test.next.next;
				test = test.next;
				 // System.out.println(test.data +"data");
				// System.out.println(test.data + "here data");
				sizeval--;
			}
			str = str.trim();
			System.out.println(str);
			// System.out.println();
		}
		// while()
		// if(index = size - 1) {
		// 	int item = last.data;
		// 	Node test = first;
		// 	int counter = 1;
		// 	while(counter < size - 1) {
		// 		test = test.next;
		// 		counter++;
		// 	}
		// 	last = test;
		// 	last.next = first;
		// } else {
		// 	Node elsetest = first;
		// 	int indexcount = 0;
		// 	while(indexcount < index) {
		// 		elsetest = elsetest.next;
		// 	}

		// }
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