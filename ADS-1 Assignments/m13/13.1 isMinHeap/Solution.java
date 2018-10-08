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
     * { To compare child node with its parents }.
     *
     * @param      heaparr  The heaparr
     * @param      nodeval  The nodeval
     *
     * @return     { boolean type }
     */
    boolean swim(final Gen[] heaparr, int nodeval) {
        while (nodeval > 1) {
            if (less(heaparr[nodeval], heaparr[(nodeval - 1) / 2])) {
                return false;
            } else {
                nodeval = (nodeval - 1) / 2;
            }
        }
        return true;
    }
    /**
     * { To insert an element }.
     *
     * @param      item  The item
     *
     * @return     { int type }
     */
    int insert(Gen item) {
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
class Solution {
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
                Minheap<Integer> minobjint = new Minheap<Integer>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = minobjint.insert(Integer.parseInt(tokens[j]));
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
                    int returnval = minobjdou.insert(Double.parseDouble(tokens[j]));
                    if (returnval == 1) {
                        System.out.println("false");
                        break outerloop;
                    }
                }
                System.out.println("true");
                break;
            case "Float":
                tokens = scan.nextLine().split(",");
                if(tokens[0].equals("")) {
                    System.out.println("false");
                    break;
                }
                Minheap<Float> minobjflo = new Minheap<Float>(tokens.length);
                for (int j = 0; j < tokens.length; j++) {
                    int returnval = minobjflo.insert(Float.parseFloat(tokens[j]));
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