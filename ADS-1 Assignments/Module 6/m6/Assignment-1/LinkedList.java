class LinkedList {
	Node first = null;
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
		newnode.next = first;
		first = newnode;
		size++;
	}
	int reversepop(int iteratorval) {
		Node test = first;
		int counter = 0;
		while (counter < iteratorval - 1) {
			test = test.next;
			counter++;
		}
		int value = test.data;
		size--;
		return value;
	}
	int pop() {
		int output = first.data;
		first = first.next;
		size--;
		return output;
	}
	String print() {
		Node test = first;
		String num = "";
		while (test != null) {
			num = num + test.data;
			test = test.next;
		}
		return num;
	}

}