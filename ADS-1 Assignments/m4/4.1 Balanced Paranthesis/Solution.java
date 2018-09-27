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
			char[] paranthesis = new char[20];
			String line = scan.nextLine();
			int flag = 0;
			for (int j = 0; j < line.length(); j++) {
				if (Character.toString(line.charAt(0)).equals(")") || Character.toString(line.charAt(line.length() - 1)).equals("(")) {
					System.out.println("NO");
					flag = 1;
					break;
				}
				if (Character.toString(line.charAt(j)).equals("(")) {
					if (size == paranthesis.length) {
						paranthesis = Arrays.copyOf(paranthesis, 2 * size);
					}
					paranthesis[size] = line.charAt(j);
				} else if (Character.toString(line.charAt(j)).equals(")")) {
					size--;
				}
			}
			if (paranthesis.length == 0 && flag == 0) {
				System.out.println("YES");
			} else if (paranthesis.length > 0 && flag == 0) {
				System.out.println("NO");
			}
		}
	}
}