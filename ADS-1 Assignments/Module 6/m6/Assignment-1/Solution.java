import java.util.Scanner;
class LinkedList {
	Node first = null;
	class Node {
		int data;
		Node next;
		Node(int inputdata) {
			this.data = inputdata;
		}
	}
	void push(int item) {
		Node newnode = new Node(item);
		newnode.next = first;
		first = newnode;
	}
	int pop() {
		int output = first.data;
		first = first.next;
		return output;
	}
	String print() {
		Node test = first;
		String num = "";
		while(test != null) {
			num = num + test.data;
			test = test.next;
		}
		return num;
	}

}
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
    	LinkedList numtodig = new LinkedList();
    	for(int i = number.length() - 1; i >= 0; i--) {
    		String ele = "" + number.charAt(i);
    		numtodig.push(Integer.parseInt(ele));
    	}
    	return numtodig;
    }

    public static String digitsToNumber(LinkedList list) {
    	return list.print();
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            // case "addLargeNumbers":
            //     LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            //     LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}
