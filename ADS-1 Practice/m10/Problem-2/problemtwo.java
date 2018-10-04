import java.util.Scanner;
/**
 * Class for problemtwo.
 */
class problemtwo {
	/**
	 * { Append function }.
	 *
	 * @param      testline  The testline
	 *
	 * @return     { String }
	 */
	static String Append(final String testline) {
		if(testline.length() <= 1) {
			return testline;
		}
		if(testline.charAt(0) == testline.charAt(1)) {
			return testline.charAt(0) + "*" + Append(testline.substring(1));
		}
		return testline.charAt(0) + Append(testline.substring(1));
	}
	/**
	 * { main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		System.out.println(Append(line));
	}
}