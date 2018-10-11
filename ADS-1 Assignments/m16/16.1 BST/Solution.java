import java.util.Scanner;
/**
 * Class for key.
 */
class Key implements Comparable<Key> {
    /**
     * { Name of the book }.
     */
    private String bookname;
    /**
     * { Author of the book }.
     */
    private String bookauthor;
    /**
     * { Cost of the book }.
     */
    private String bookcost;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      cost    The cost
     */
    Key(String name, String author, String cost) {
        this.bookname = name;
        this.bookauthor = author;
        this.bookcost = cost;
    }
    /**
     * { To compare names }.
     *
     * @param      other  The other
     *
     * @return     { int value }
     */
    public int compareTo(Key other) {
        return this.bookname.compareTo(other.bookname);
    }
}
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * { Head Node }.
     */
    private Node head = null;
    /**
     * { Size value }.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { Left node }.
         */
        private Node left;
        /**
         * { Right node }.
         */
        private Node right;
        /**
         * { Keydata }.
         */
        private Key keydata;
        /**
         * { valuedata }.
         */
        private Value valdata;
        /**
         * Constructs the object.
         *
         * @param      keyval  The keyval
         * @param      val     The value
         */
        Node(Key keyval, Value val) {
            this.keydata = keyval;
            this.valdata = val;
        }
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return size == 0;
    }
    /**
     * { Put function }.
     *
     * @param      item     The item
     * @param      itemval  The itemval
     */
    void put(Key item, Value itemval) {
        Node newnode = new Node(item, itemval);
        if (isEmpty()) {
            head = newnode;
            size++;
            return;
        }
        Node test = head;
        while (!(test.left == null && test.right == null)) {
            int compare = item.compareTo(test.keydata);
            if (compare > 0) {
                if (test.right == null) {
                    break;
                }
                test = test.right;
            } else if (compare < 0) {
                if (test.left == null) {
                    break;
                }
                test = test.left;
            } else {
                test.valdata = newnode.valdata;
                return;
            }
        }
        int compare = item.compareTo(test.keydata);
        if (compare == 0) {
            test.valdata = newnode.valdata;
            return;
        } else if (compare < 0) {
            test.left = newnode;
            size++;
        } else if (compare > 0) {
            test.right = newnode;
            size++;
        }
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    Value get(Key item) {
        Node test = head;
        while (!(test.left == null && test.right == null)) {
            int compare = item.compareTo(test.keydata);
            if (compare > 0) {
                if (test.right == null) {
                    break;
                }
                test = test.right;
            } else if (compare < 0) {
                if (test.left == null) {
                    break;
                }
                test = test.left;
            } else {
                break;
            }
        }
        if (item.compareTo(test.keydata) == 0) {
            return test.valdata;
        }
        return null;
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree<Key, Integer> bstobj = new BinarySearchTree<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Key newkey = new Key(tokens[1], tokens[2], tokens[3]);
                bstobj.put(newkey, Integer.parseInt(tokens[4]));
                break;
            case "get":
                newkey = new Key(tokens[1], tokens[2], tokens[3]);
                System.out.println(bstobj.get(newkey));
                break;
            default:
                break;
            }
        }
    }
}
