/**
 * Class for josephus.
 */
class Josephus {
    /**
     * { first node }
     */
    Node first = null;
    /**
     * { last node }
     */
    Node last = null;
    /**
     * { size }
     */
    int size = 0;
    /**
     * Class for node.
     */
    class Node {
        /**
         * { data }
         */
        int data;
        /**
         * { next node }
         */
        Node next;
        /**
         * Constructs the object.
         *
         * @param      inputdata  The inputdata
         */
        Node(int inputdata) {
            this.data = inputdata;
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
     * { push }.
     *
     * @param      item  The item
     */
    void push(int item) {
        Node newnode = new Node(item);
        if (isEmpty()) {
            newnode.next = first;
            first = newnode;
            last = first;
            first.next = last;
            last.next = first;
            size++;
            return;
        }
        last.next = newnode;
        last = newnode;
        last.next = first;
        size++;
    }
    /**
     * { pop function }.
     *
     * @param      index    The index
     * @param      sizeval  The sizeval
     */
    void pop(final int index, int sizeval) {
        Node test = first;
        String str = "";
        while (sizeval > 0) {
            int counter = 0;
            while (counter < index - 2) {
                test = test.next;
                counter++;
            }
            if (test.next == last) {
                str = str + test.next.data + " ";
                last = test;
                last.next = first;
                test = first;
                sizeval--;
            } else {
                if (test.next == first) {
                    str = str + first.data + " ";
                    first = first.next;
                    last.next = first;
                    test = first;
                } else {
                    str = str + test.next.data + " ";
                    test.next = test.next.next;
                    test = test.next;
                }
                sizeval--;
            }
        }
        str = str.trim();
        System.out.println(str);
    }
}