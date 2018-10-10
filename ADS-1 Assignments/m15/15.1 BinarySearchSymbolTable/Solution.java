import java.util.Scanner;
/**
 * Class for binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * { keys array }.
     */
    private Key[] keys;
    /**
     * { values array }.
     */
    private Value[] values;
    /**
     * { size value }.
     */
    private int size = 0;
    /**
     * Constructs the object.
     */
    BinarySearchST() {
        final int twenty = 20;
        keys = (Key[]) new Comparable[twenty];
        values = (Value[]) new Object[twenty];
    }
    /**
     * { To add elements into the Data Structure }.
     * Complexity:
     *            Best case: O(logN)
     *            Worst case: O(logN)
     *            Average case: O(logN)
     *
     * @param      keyval  The keyval
     * @param      val     The value
     */
    public void put(final Key keyval, final Value val) {
        if (keyval == null) {
            System.out.println("key is null");
        }
        if (val == null) {
            delete(keyval);
            return;
        }
        int i = rank(keyval);
        if (i < size && keys[i].compareTo(keyval) == 0) {
            values[i] = val;
            return;
        }
        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = keyval;
        values[i] = val;
        size++;
    }
    /**
     * { To calculate rank of the keyvalue }.
     * Complexity:
     *            Best case: O(logN)
     *            Worst case: O(logN)
     *            Average case: O(logN)
     *
     * @param      keyval  The keyval
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(final Key keyval) {
        if (keyval == null) {
            System.out.println("key is null");
        }
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = keyval.compareTo(keys[mid]);
            if (compare < 0) {
                high = mid - 1;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * { Checks for presence of key }.
     * Complexity:
     *            Best case: O(1)
     *            worst case: O(1)
     *            Average case: O(1)
     *
     * @param      keyval  The keyval
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final Key keyval) {
        if (keyval == null) {
            System.out.println("key is null");
        }
        return get(keyval) != null;
    }
    /**
     * { To retreive the value of key }.
     * Complexity:
     *            Best case: O(logN)
     *            Worst case: O(logN)
     *            Average case: O(logN)
     *
     * @param      keyval  The keyval
     *
     * @return     { Value type }
     */
    public Value get(final Key keyval) {
        if (keyval == null) {
            System.out.println("key is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(keyval);
        if (i < size && keys[i].compareTo(keyval) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * Determines if empty.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * { To find max value }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @return     { key type }
     */
    public Key max() {
        if (isEmpty()) {
            System.out.println("No elements are available in the Symbol table");
        }
        return keys[size - 1];
    }
    /**
     * { Floor function }.
     * Complexity:
     *            Best case: O(logN)
     *            Worst case: O(logN)
     *            Average case: O(logN)
     *
     * @param      keyval  The keyval
     *
     * @return     { key type }
     */
    public Key floor(final Key keyval) {
        int i = rank(keyval);
        if (i < size && keyval.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * { To delete min value }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     */
    public void deleteMin() {
        if (isEmpty()) {
            System.out.println("No elements are available in"
                               + "the Symbol table to perform deletion");
        }
        delete(min());
    }
    /**
     * { To get minimum key }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     * @return     { Key type }
     */
    public Key min() {
        if (isEmpty()) {
            System.out.println("empty symbol table");
        }
        return keys[0];
    }
    /**
     * { To delete a key }.
     *  Complexity:
     *            Best case: O(logN)
     *            Worst case: O(logN)
     *            Average case: O(logN)
     *
     * @param      keyval  The keyval
     */
    public void delete(final Key keyval) {
        if (keyval == null) {
            System.out.println("key is null");
        }

        int i = rank(keyval);
        if (i == size || keys[i].compareTo(keyval) != 0) {
            return;
        }
        for (int j = i; j < size - 1; j++)  {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        size--;
        keys[size] = null;
        values[size] = null;
    }
    /**
     * { To print keys }.
     * Complexity:
     *            Best case: O(N)
     *            Worst case: O(N)
     *            Average case: O(N)
     *
     * @return     { String type }
     */
    public String keys() {
        String str = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            if (keys[i] != null) {
                str += keys[i] + " " + values[i] + "\n";
            }
        }
        str += keys[size - 1] + " " + values[size - 1];
        return str;
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
        String[] array = scan.nextLine().split(" ");
        BinarySearchST binobj = new BinarySearchST();
        for (int i = 0; i < array.length; i++) {
            binobj.put(array[i], i);
        }
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "get":
                System.out.println(binobj.get(tokens[1]));
                break;
            case "max":
                System.out.println(binobj.max());
                break;

            case "floor":
                System.out.println(binobj.floor(tokens[1]));
                break;

            case "rank":
                System.out.println(binobj.rank(tokens[1]));
                break;

            case "contains":
                System.out.println(binobj.contains(tokens[1]));
                break;

            case "deleteMin":
                binobj.deleteMin();
                break;

            case "keys":
                System.out.println(binobj.keys());
                break;

            default:
                break;
            }
        }
    }
}
