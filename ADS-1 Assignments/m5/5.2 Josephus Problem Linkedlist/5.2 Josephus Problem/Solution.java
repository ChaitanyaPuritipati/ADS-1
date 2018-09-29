import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused;
    }
    /**
     * { Main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testnum = Integer.parseInt(scan.nextLine());
        for (int k = 0; k < testnum; k++) {
            Josephus start = new Josephus();
            String[] tokens = scan.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(tokens[0]); i++) {
                start.push(i);
            }
            start.pop(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[0]));
        }
    }
}
