import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * { Checks if first element is greater than second element }.
     *
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @param      inputone  The inputone
     * @param      inputtwo  The inputtwo
     *
     * @return     { boolean type }
     */
    boolean greater(final Comparable inputone, final Comparable inputtwo) {

        //checks for the greatness using compareTo function

        return inputone.compareTo(inputtwo) > 0;
    }

    /**
     * { Exchange function swaps two indexes in an array }.
     *
     * Complexity:
     *             Best case: O(1);
     *             Worst case: O(1);
     *             Average case: O(1);
     *
     * @param      inputarray  The inputarray
     * @param      bigindex    The bigindex
     * @param      smallindex  The smallindex
     */
    void exchange(final Comparable[] inputarray,
                  final int bigindex,
                  final int smallindex) {

        //creates a temporary variable to store the bigindex value

        Comparable temp = inputarray[bigindex];

        //swap the indexe

        inputarray[bigindex] = inputarray[smallindex];

        inputarray[smallindex] = temp;
    }
    /**
     * { Insertion sort function }.
     * Complexity: Best case: O(N)
     *             Worst case: O(N^2)
     *             Average case: O(N^2)
     *
     * @param      inputarray  The inputarray
     * @param      start       The start
     * @param      end         The end
     */
    void sort(final Comparable[] inputarray,
              final int start, final int end) {
        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > start; j--) {
                if (greater(inputarray[j - 1], inputarray[j])) {

                    //call the exchange function.

                    exchange(inputarray, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
/**
 * Class for quicksort.
 */
class Quicksort {
    /**
     * { To swap two items }.
     *
     * @param      inputarray  The inputarray
     * @param      bigindex    The bigindex
     * @param      smallindex  The smallindex
     */
    void exchange(final Comparable[] inputarray,
                  final int bigindex,
                  final int smallindex) {

        //creates a temporary variable to store the bigindex value

        Comparable temp = inputarray[bigindex];

        //swap the indexe

        inputarray[bigindex] = inputarray[smallindex];

        inputarray[smallindex] = temp;
    }
    /**
     * { Partition function }.
     * Complexity: Best case: O(N)
     *             Worst case: O(N^2)
     *             Average case: O(N^2)
     *
     * @param      inputarray  The inputarray
     * @param      start       The start
     * @param      end         The end
     *
     * @return     { int value }
     */
    int partition(final Comparable[] inputarray,
                  final int start, final int end) {
        int i = start + 1;
        int j = end;
        Comparable pivotval = inputarray[start];
        while (i < j) {
            while (i <= end
                    && inputarray[i].compareTo(
                        pivotval) <= 0) {
                i++;
            }
            while (j >= start
                    && inputarray[j].compareTo(
                        pivotval) > 0) {
                j--;
            }
            if (i < j) {
                exchange(inputarray, j, i);
            }
        }
        exchange(inputarray, j, start);
        System.out.println(Arrays.toString(inputarray));
        return j;
    }
    /**
     * { Quick Sort function }.
     * Complexity:
     *             Best case: O(NlogN)
     *             Worst case: O(NlogN)
     *             Average case: O(NlogN)
     *
     * @param      inputarray  The inputarray
     * @param      start       The start
     * @param      end         The end
     * @param      cutoff      The cutoff
     */
    void sort(final Comparable[] inputarray,
              final int start, final int end,
              final int cutoff) {
        if (end - start < cutoff) {
            InsertionSort insertion = new InsertionSort();
            insertion.sort(inputarray, start, end);
            System.out.println("insertionSort called");
            return;
        }
        int pivot = partition(inputarray, start, end);
        sort(inputarray, start, pivot - 1, cutoff);
        sort(inputarray, pivot + 1, end, cutoff);
    }
}
/**
 * { Solution }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testnum = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testnum; i++) {
            Quicksort quick = new Quicksort();
            int cutoffval = Integer.parseInt(scan.nextLine());
            Comparable[] inputarray = scan.nextLine().split(" ");
            if (inputarray[0].equals("")) {
                System.out.println(Arrays.toString(inputarray));
            } else {
                quick.sort(inputarray,
                           0, inputarray.length - 1,
                           cutoffval);
                System.out.println(Arrays.toString(inputarray));
            }
        }

    }
}
