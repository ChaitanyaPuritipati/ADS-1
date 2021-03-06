import java.util.Scanner;
/**
 * Class for cubesum.
 */
class Cubesum implements Comparable<Cubesum> {
    /**
     * { firstnum variable }.
     */
    private int firstnum;
    /**
     * { secondnum variable }.
     */
    private int secondnum;
    /**
     * { sum variable }.
     */
    private int sum;
    /**
     * Constructs the object.
     *
     * @param      first   The first
     * @param      second  The second
     */
    Cubesum(final int first, final int second) {
        this.sum = (first * first * first) + (second * second * second);
        this.firstnum = first;
        this.secondnum = second;
    }
    /**
     * { compareTo function }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Cubesum other) {
        if (this.sum > other.sum) {
            return 1;
        }
        if (this.sum < other.sum) {
            return -1;
        }
        return 0;
    }
    /**
     * Gets the sum.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }
    /**
     * { getSecondnum }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @return     { int type }
     */
    public int getsecondnum() {
        return secondnum;
    }
    /**
     * { getfirstnum }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @return     { int type }
     */
    public int getfirstnum() {
        return firstnum;
    }
    /**
     * Returns a string representation of the object.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = str + this.sum;
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
        final int ftt = 522;
        final int hun = 100;
        Scanner scan = new Scanner(System.in);
        String[] tokens = scan.nextLine().split(" ");
        int reqtime = Integer.parseInt(tokens[0]);
        int numtimes = Integer.parseInt(tokens[1]);
        MinPQ<Cubesum> minpqobj = new MinPQ<>(hun);
        for (int i = 0; i < ftt; i++) {
            minpqobj.insert(new Cubesum(i, i));
        }
        int previous = -1;
        int ntimes = 1;
        int rtime = 0;
        while (!minpqobj.isEmpty()) {
            Cubesum current = minpqobj.delMin();
            if (current.getSum() == previous) {
                ntimes++;
                if (ntimes == numtimes) {
                    rtime++;
                }
                if (rtime == reqtime) {
                    System.out.println(current.getSum());
                    return;
                }
            } else {
                ntimes = 1;
            }
            if (current.getsecondnum() < ftt) {
                minpqobj.insert(new Cubesum(
                                    current.getfirstnum(),
                                    current.getsecondnum() + 1));
            }
            previous = current.getSum();
        }
    }
}
