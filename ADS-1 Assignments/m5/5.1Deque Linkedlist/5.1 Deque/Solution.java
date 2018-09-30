import java.util.Scanner;
/**
 * { Solution }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { Main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Deque<Integer> dequeobj = new Deque<Integer>();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "pushLeft":
                dequeobj.pushLeft(Integer.parseInt(tokens[1]));
                break;
            case "pushRight":
                dequeobj.pushRight(Integer.parseInt(tokens[1]));
                break;
            case "size":
                System.out.println(dequeobj.size());
                break;
            case "popRight":
                dequeobj.popRight();
                break;
            case "popLeft":
                dequeobj.popLeft();
                break;
            default:
            }
        }
    }
}
