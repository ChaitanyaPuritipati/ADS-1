import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {

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
		int size = 0;
		for (int i = 0; i < testnum; i++) {
			// System.out.println(i);
			String[] paranthesis = new String[20];
			String line = scan.nextLine();
			String[] tokens = line.split("");
			int flag = 0;
			for (int j = 0; j < tokens.length; j++) {
				// System.out.println(j);
				// if (tokens[0].equals(")") || tokens[tokens.length - 1].equals("")) {
				// 	// System.out.println("NO");
				// 	flag = 1;
				// 	break;
				// }
				if (tokens[j].equals("(") || tokens[j].equals("{") || tokens[j].equals("[")) {
					if (size == paranthesis.length) {
						System.out.println("entered");
						paranthesis = Arrays.copyOf(paranthesis, 2 * size);
					}
					paranthesis[size] = tokens[j];
					size++;
				} else if (tokens[j].equals("}")) {
					if (!tokens[size - 1].equals("{")) {
						System.out.println("NO");
						flag = 1;
						break;
					}
					size--;
				} else if (tokens[j].equals(")") && size > 0) {
					if (!tokens[size - 1].equals("(")) {
						System.out.println("NO");
						flag = 1;
						break;
					}
					size--;
				} else if (tokens[j].equals("]") && size > 0) {
					if (!tokens[size - 1].equals("[")) {
						System.out.println("NO");
						flag = 1;
						break;
					}
					size--;
				}
			}
			if (size == 0 && flag == 0) {
				System.out.println("YES");
			}
		}
	}

}
