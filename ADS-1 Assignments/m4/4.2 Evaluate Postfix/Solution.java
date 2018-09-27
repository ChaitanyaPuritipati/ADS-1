import java.util.Scanner;
import java.util.LinkedList;
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
        String[] tokens = line.split(" ");
        String str = "+*-/";
        LinkedList<Integer> operands = new LinkedList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (!str.contains(tokens[i])) {
                operands.add(Integer.parseInt(tokens[i]));
            } else {
                switch (tokens[i]) {
                case "+":
                    int a = operands.removeLast();
                    int b = operands.removeLast();
                    operands.add(a + b);
                    break;
                case "-":
                    a = operands.removeLast();
                    b = operands.removeLast();
                    operands.add(a - b);
                    break;
                case "*":
                    a = operands.removeLast();
                    b = operands.removeLast();
                    operands.add(a * b);
                    break;
                case "/":
                    a = operands.removeLast();
                    b = operands.removeLast();
                    operands.add(a / b);
                    break;
                default:
                }
            }
        }
        System.out.println(operands.get(0));
    }
}