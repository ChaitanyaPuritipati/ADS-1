import java.util.Scanner;
/**
 * Class for minheap.
 *
 * @param      <Gen>  The generate
 */
class Minheap<Gen extends Comparable<Gen>> {
    /**
     * { Heaparray }.
     */
    private Gen[] heaparr;
    /**
     * { counter }.
     */
    private int count;
    /**
     * { flag value }.
     */
    private int flag;
    /**
     * Constructs the object.
     *
     * @param      size  The size
     */
    Minheap(final int size) {
        heaparr = (Gen[]) new Comparable[size];
        count = 0;
        flag = 0;
    }
    /**
     * { To check if the first element is less than the second element }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(1)
     *            Average case: O(1)
     *
     * @param      valueone  The valueone
     * @param      valuetwo  The valuetwo
     *
     * @return     { boolean type }
     */
    boolean less(final Gen valueone, final Gen valuetwo) {
        return valueone.compareTo(valuetwo) < 0;
    }
    /**
     * { To compare child node with its parent nodes }.
     * Complexity: Best case: O(1)
     *             Worst case: O(logN)
     *             Average case: O(logN)
     *
     * @param      array    The array
     * @param      nodeval  The nodeval
     *
     * @return     { description_of_the_return_value }
     */
    boolean swim(final Gen[] array, final int nodeval) {
        int nodevalnew = nodeval;
        while (nodevalnew > 1) {
            if (less(array[nodevalnew], array[(nodevalnew - 1) / 2])) {
                return false;
            } else {
                nodevalnew = (nodevalnew - 1) / 2;
            }
        }
        return true;
    }
    /**
     * { To insert an element }.
     * Complexity:
     *            Best case: O(1)
     *            Worst case: O(logN)
     *            Average case: O(logN)
     *
     * @param      item  The item
     *
     * @return     { int type }
     */
    int insert(final Gen item) {
        heaparr[count++] = item;
        if (!swim(heaparr, count - 1)) {
            flag = 1;
        }
        return flag;
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
        String line = scan.nextLine();
        int testnum = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testnum; i++) {
            outerloop:
            switch (line) {
            case "String":
                String[] tokens = scan.nextLine().split(",");
                Minheap<String> minobj = new Minheap<String>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = minobj.insert(tokens[j]);
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Integer":
                tokens = scan.nextLine().split(",");
                Minheap<Integer> minobjint =
                    new Minheap<Integer>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = minobjint.insert(
                                        Integer.parseInt(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Double":
                tokens = scan.nextLine().split(",");
                Minheap<Double> minobjdou = new Minheap<Double>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = minobjdou.insert(
                                        Double.parseDouble(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Float":
                tokens = scan.nextLine().split(",");
                if (tokens[0].equals("")) {
                    System.out.println("false");
                    break;
                }
                Minheap<Float> minobjflo = new Minheap<Float>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = minobjflo.insert(
                                        Float.parseFloat(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            default:
                break;
            }
        }
    }
}
