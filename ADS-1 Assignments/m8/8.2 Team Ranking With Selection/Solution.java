import java.util.Arrays;
import java.util.Scanner;
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
    boolean greater(final Teamdata inputone, final Teamdata inputtwo) {

        //checks for the greatness using compareTo function

        return inputone.compareTo(inputtwo) == 1;
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
    void exchange(final Teamdata[] inputarray,
                  final int bigindex,
                  final int smallindex) {

        //creates a temporary variable to store the bigindex value

        Teamdata temp = inputarray[bigindex];

        //swap the indexe

        inputarray[bigindex] = inputarray[smallindex];

        inputarray[smallindex] = temp;
    }

    /**
     * { Sort function sorts the data according to the requirement }.
     *  Complexity:
     *             Best case: O(N)
     *             Worst case: O(N^2)
     *             Average case: O(N^2)
     *
     * @param      inputarray  The inputarray
     */
    void sort(final Teamdata[] inputarray) {
        int length = inputarray.length;
        for (int i = 0; i < length; i++) {
            int maxindex = i;
            for (int j = i + 1; j < length; j++) {
                if (greater(inputarray[j], inputarray[maxindex])) {
                    maxindex = j;
                }
            }
            exchange(inputarray, i, maxindex);
        }

        //To print the output

        for (int i = 0; i < inputarray.length - 1; i++) {
            System.out.print(inputarray[i].getname() + ",");
        }
        System.out.println(inputarray[inputarray.length - 1].getname());
    }
}

/**
 * Class for teamdata.
 * This class implements comparable interface to override compareTo method
 *
 */
class Teamdata implements Comparable<Teamdata> {
    /**
     * { Teamname }.
     */
    private String teamname;
    /**
     * { Number of wins }.
     */
    private int teamwins;
    /**
     * { Number of losses }.
     */
    private int teamlosses;
    /**
     * { Number of draws }.
     */
    private int teamdraws;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      wins    The wins
     * @param      losses  The losses
     * @param      draws   The draws
     */
    Teamdata(final String name,
             final int wins,
             final int losses,
             final int draws) {
        this.teamname = name;
        this.teamwins = wins;
        this.teamlosses = losses;
        this.teamdraws = draws;
    }
    /**
     * { To access teamname }.
     * Complexity:
     *            Best case: O(1);
     *            Worst case: O(1);
     *            Average case: O(1);
     * @return     { String }
     */
    public String getname() {
        return this.teamname;
    }
    /**
     * { Overriding compareTo to compare according to our condition }.
     *
     * @param      other  The other
     *
     * @return     { int type }
     */
    public int compareTo(final Teamdata other) {
        if (this.teamwins > other.teamwins) {
            return 1;
        }
        if (this.teamwins < other.teamwins) {
            return -1;
        }
        if (this.teamlosses > other.teamlosses) {
            return -1;
        }
        if (this.teamlosses < other.teamlosses) {
            return 1;
        }
        if (this.teamdraws > other.teamdraws) {
            return 1;
        }
        if (this.teamdraws < other.teamdraws) {
            return -1;
        }
        return 0;
    }
}
/**
 * { Solution class }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main function is created to initialize sort class }.
     * Array of teamdata objects is created
     * Input is read using scanner class
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int ten = 10;
        final int three = 3;
        Teamdata[] data = new Teamdata[ten];
        int count = 0;
        InsertionSort startobj = new InsertionSort();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            Teamdata everydata = new Teamdata(tokens[0],
                                              Integer.parseInt(tokens[1]),
                                              Integer.parseInt(tokens[2]),
                                              Integer.parseInt(tokens[three]));
            data[count] = everydata;
            count++;
        }
        data = Arrays.copyOf(data, count);
        startobj.sort(data);
    }
}
