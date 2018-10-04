import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * { headnode }.
     */
    private Node head;
    /**
     * { testnode }.
     */
    private Node test;
    /**
     * { prevnode }.
     */
    private Node prev;
    /**
     * { tempnode }.
     */
    private Node temp;
    /**
     * { size }.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { nodedata }.
         */
        private int nodedata;
        /**
         * { nextnode }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data  The data
         */
        Node(final int data) {

            //assigning parameter to attribute

            this.nodedata = data;
        }
    }
    /**
     * { insertAt function }.
     * Complexity:
     *            Best case: O(1);
     *            Worst case: O(N);
     *            Average case: O(N);
     *
     * @param      index      The index
     * @param      inputdata  The inputdata
     *
     * @throws     Exception  { Insertion not possible }
     */
    void insertAt(final int index, final int inputdata) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Can't insert at this position.");
        }
        if (index == 1) {
            Node newnode = new Node(inputdata);
            newnode.next = test.next;
            test.next = newnode;
            test = head;
            size++;
            return;
        }
        if (index == 0) {
            Node newnode = new Node(inputdata);
            newnode.next = test;
            head = newnode;
            test =  head;
            size++;
            return;
        }
        test = test.next;
        int newindex = index;
        newindex--;
        insertAt(newindex, inputdata);
    }
    /**
     * { reverse function }.
     * Complexity:
     *            Best case: O(N);
     *            Worst case: O(N);
     *            Average case: O(N);
     *
     * @throws     Exception  { No elements to reverse }
     */
    void reverse() throws Exception {
        if (size == 0) {
            throw new Exception("No elements to reverse.");
        }
        if (test.next == null) {
            head = test;
            head.next = prev;
            test = head;
            prev = null;
            return;
        }
        temp = test;
        test = test.next;
        temp.next = prev;
        prev = temp;
        reverse();
    }
    /**
     * { prints linkedlist }.
     */
    void print() {
        String str = "";
        Node newtest = head;
        while (newtest.next != null) {
            str = str + newtest.nodedata + ", ";
            newtest = newtest.next;
        }
        str = str + newtest.nodedata;
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
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Linkedlist linked = new Linkedlist();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    linked.insertAt(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                    linked.print();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            case "reverse":
                try {
                    linked.reverse();
                    linked.print();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                break;
            }
        }
    }
}
