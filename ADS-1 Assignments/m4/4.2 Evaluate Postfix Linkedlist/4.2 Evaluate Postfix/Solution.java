import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Stack operands = new Stack();
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String[] tokens = line.split(" ");
		String str = "+*-/";
		for (int i = 0; i < tokens.length; i++) {
			if (!str.contains(tokens[i])) {
				operands.push(Integer.parseInt(tokens[i]));
			} else {
				switch (tokens[i]) {
				case "+":
					int a = operands.pop();
					int b = operands.pop();
					operands.push(a + b);
					break;
				case "-":
					a = operands.pop();
					b = operands.pop();
					operands.push(a - b);
					break;
				case "*":
					a = operands.pop();
					b = operands.pop();
					operands.push(a * b);
					break;
				case "/":
					a = operands.pop();
					b = operands.pop();
					operands.push(a / b);
					break;
				default:
				}
			}
		}
		operands.print();
	}
}
class Stack {
	Node first = null;
	class Node {
		int data;
		Node next;
		Node(int input) {
			this.data = input;
		}
	}
	public void push(int item) {
		Node newnode = new Node(item);
		newnode.next = first;
		first = newnode;
	}
	public int pop() {
		int item = first.data;
		first = first.next;
		return item;
	}
	public void print() {
		System.out.println(first.data);
	}
}