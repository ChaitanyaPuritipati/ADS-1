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
		for (int i = 0; i < testnum; i++) {
			String[] paranthesis = new String[20];
			String line = scan.nextLine();
			String[] tokens = line.split("");
			System.out.println(Arrays.toString(tokens) + "hello");
			int size = 0;
			int flag = 0;
			for (int j = 0; j < tokens.length; j++) {
				if (tokens[j].equals("(") || tokens[j].equals("{") || tokens[j].equals("[")) {
					if (size == paranthesis.length) {
						paranthesis = Arrays.copyOf(paranthesis, 2 * size);
					}
					paranthesis[size] = tokens[j];
					size++;
				} else if (tokens[j].equals("}")) {
					if(size == 0) {
						flag = 1;
						System.out.println("NO");
						break;
					}
					if (!tokens[size - 1].equals("{")) {
						System.out.println("NO flower");
						flag = 1;
						break;
					}
					size--;
				} else if (tokens[j].equals(")")) {
					if(size == 0) {
						flag = 1;
						System.out.println("NO");
						break;
					}
					System.out.println(size + "size value");
					if (!tokens[size - 1].equals("(")) {
						System.out.println(Arrays.toString(paranthesis));
						System.out.println("NO convex");
						flag = 1;
						break;
					}
					size--;
				} else if (tokens[j].equals("]")) {
					if(size == 0) {
						flag = 1;
						System.out.println("NO");
						break;
					}
					if (!tokens[size - 1].equals("[")) {
						System.out.println("NO sqaure");
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
