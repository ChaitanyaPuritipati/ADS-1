import java.util.Scanner;
/**
 * Class for steque.
 */
class Steque {
    /**
     * { Declare a HEAD node and intialize it to null }.
     */
    private Node head = null;
    /**
     * { Declare a HEAD node and intialize it to null }.
     */
    private Node tail = null;
    /**
     * { Declare a int variable size and intialize it to zero }.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { Create a variable nodedata to store the element }.
         */
        private int nodedata;
        /**
         * { Declare a variable prevnode to keep track of its previous node }.
         */
        private Node prevnode;
        /**
         * { Declare a variable nextnode to keep track of its next node }.
         */
        private Node nextnode;
        /**
         * Constructs the object.
         *
         * @param      data  The data
         * Argument is of int type.
         */
        Node(final int data) {

            //Assigning argument data to variable to nodedata.

            nodedata = data;
        }
    }
    /**
     * Determines if empty.
     * Complexity:
     *             Best case: O(1);
     *             Worst case: O(1);
     *             Average case: O(1);
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return size == 0;
    }
    /**
     * { Push function adds elements to the steque at the head side }.
     * Complexity:
     *             Best case: O(1);
     *             Worst case: O(1);
     *             Average case: O(1);
     *
     * @param      item  The item
     * item is the data that is to be added to the steque.
     */
    void push(final int item) {

        //Creating newnode using the item data

        Node newnode = new Node(item);

        //Checking for the size of the Steque.

        if (isEmpty()) {

            //Keep updating nodes accordingly

            newnode.nextnode = head;
            newnode.prevnode = head;
            head = newnode;
            tail = head;
            size++;
            print();
            return;
        }

        //Keep updating nodes accordingly

        newnode.nextnode = head;
        newnode.prevnode = head.prevnode;
        head.prevnode = newnode;
        head = newnode;
        size++;
        print();
    }
    /**
     * { Enqueue function adds elements to the tail side of the steque }.
     * Complexity:
     *             Best case: O(1);
     *             Worst case: O(1);
     *             Average case: O(1);
     * @param      item  The item
     * Input element is the data to be added to the Steque
     */
    void enqueue(final int item) {

        //creating a newnode with the input item

        Node newnode = new Node(item);

        //Checking for the size of the steque

        if (isEmpty()) {

            //Keep updating nodes accordingly

            newnode.nextnode = tail;
            newnode.prevnode = tail;
            tail = newnode;
            head = tail;
            size++;
            print();
            return;
        }

        //Keep updating nodes accordingly

        newnode.nextnode = tail.nextnode;
        newnode.prevnode = tail;
        tail.nextnode = newnode;
        tail = newnode;
        size++;
        print();
    }
    /**
     * { Pop function removes the last added element in the steque }.
     * Complexity:
     *             Best Case: O(1);
     *             Worst Case: O(1);
     *             Average Case: O(1);
     */
    void pop() {
        int result = head.nodedata;
        head = head.nextnode;
        size--;
        print();
    }
    /**
     * { Print function to print
     *   all the values in the steque
     *   after every operation }.
     * Complexity:
     *             Best case: O(1);
     *             Worst case: O(N);
     *             Average case: O(N);
     */
    void print() {

        //Checking for the size of steque.

        if (isEmpty()) {
            System.out.println("Steque is empty.");
            return;
        }

        //Creating a new string to append steque elements

        String str = "";
        Node test = head;
        while (test != tail) {
            str = str + test.nodedata + ", ";
            test = test.nextnode;
        }
        str = str + test.nodedata;
        System.out.println(str);
    }
}
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
     * It has functionality of taking inputs for number of testcases
     * and Operations to be performed on Steque
     * For example: Push, Enqueue, Pop
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);

        //Input for number of test cases

        int testnum = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testnum; i++) {

            //Creating Steque object

            Steque steque = new Steque();
            while (scan.hasNext()) {

                //Input for operation to be performed on Steque: Push, Enqueue, Pop

                String line = scan.nextLine();

                //Empty line check.

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