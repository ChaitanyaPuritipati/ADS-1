import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
/**
 * List of .
 */
class Stack {
    private Node first = null;
    /**
     * Class for node.
     */
    class Node {
        private int data;
        private Node next;
        Node(int input) {
            this.data = input;
        }
    }
    /**
     * { push }.
     *
     * @param      item  The item
     */
    public void push(final int item) {
        Node newnode = new Node(item);
        newnode.next = first;
        first = newnode;
    }
    /**
     * { pop }.
     *
     * @return     { int type }
     */
    public int pop() {
        int item = first.data;
        first = first.next;
        return item;
    }
    /**
     * { print }.
     */
    public void print() {
        Node testnode = first;
        while (testnode != null) {
            System.out.println(testnode.data);
            testnode = testnode.next;
        }
    }
}