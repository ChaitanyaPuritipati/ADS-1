import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testnum = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testnum; i++) {
            final int twenty = 20;
            String line = scan.nextLine();
            String[] tokens = line.split("");
            Stack stack = new Stack();
            int flag = 0;
            for (int j = 0; j < tokens.length; j++) {
                if (tokens[j].equals("(")
                        || tokens[j].equals("{")
                        || tokens[j].equals("[")) {
                    stack.push(tokens[j]);
                } else if (tokens[j].equals("}")) {
                    if (stack.isEmpty()) {
                        flag = 1;
                        System.out.println("NO");
                        break;
                    }
                    if (!stack.pop().equals("{")) {
                        System.out.println("NO");
                        flag = 1;
                        break;
                    }
                } else if (tokens[j].equals(")")) {
                    if (stack.isEmpty()) {
                        flag = 1;
                        System.out.println("NO");
                        break;
                    }
                    if (!stack.pop().equals("(")) {
                        System.out.println("NO");
                        flag = 1;
                        break;
                    }
                } else if (tokens[j].equals("]")) {
                    if (stack.isEmpty()) {
                        flag = 1;
                        System.out.println("NO");
                        break;
                    }
                    if (!stack.pop().equals("[")) {
                        System.out.println("NO");
                        flag = 1;
                        break;
                    }
                }
            }
            if (stack.isEmpty() && flag == 0) {
                System.out.println("YES");
            } else if (!stack.isEmpty() && flag == 0) {
                System.out.println("NO");
            }
        }
    }
}
