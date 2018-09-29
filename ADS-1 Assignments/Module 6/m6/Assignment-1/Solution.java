import java.util.Scanner;
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
class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList numtodig = new LinkedList();
		for (int i = number.length() - 1; i >= 0; i--) {
			String ele = "" + number.charAt(i);
			numtodig.push(Integer.parseInt(ele));
		}
		return numtodig;
	}

	public static String digitsToNumber(LinkedList list) {
		return list.print();
	}

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		LinkedList carry = new LinkedList();
		carry.push(0);
		if (list1.size <= list2.size) {
			int out = 0;
			String result = "";
			while (!list1.isEmpty()) {
				// System.out.println(list1.size);
				out = carry.pop() + list1.reversepop(list1.size) + list2.reversepop(list2.size);
				result =  (out % 10) + result ;
				if (out > 9) {
					carry.push(out / 10);
				} else {
					carry.push(0);
				}
			}
			while (!list2.isEmpty()) {
				result =  list2.reversepop(list2.size) + carry.pop() + result ;
				carry.push(0);
			}
			// if(!carry.isEmpty()) {
			// 	result = carry.pop() + result;
			// }
			return numberToDigits(result);
		} else {
			int out = 0;
			String result = "";
			while (!list2.isEmpty()) {
				out = carry.pop() + list1.reversepop(list1.size) + list2.reversepop(list2.size);
				result = result + (out % 10);
				if (out > 9) {
					carry.push(out / 10);
				}
			}
			while (!list1.isEmpty()) {
				result = result + list1.reversepop(list1.size) + carry.pop();
				carry.push(0);
			}
			return numberToDigits(result);
		}
	}
 }

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
			LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
			System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
			System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
			break;

			case "addLargeNumbers":
			    pDigits = AddLargeNumbers.numberToDigits(p);
			    qDigits = AddLargeNumbers.numberToDigits(q);
			    LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			    System.out.println(AddLargeNumbers.digitsToNumber(result));
			    break;
		}
	}

}
