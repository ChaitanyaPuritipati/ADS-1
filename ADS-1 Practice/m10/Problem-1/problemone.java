import java.util.Scanner;
/**
 * Class for problemone.
 */
class problemone {
	/**
	 * { factorial function }.
	 *
	 * @param      testnum  The testnum
	 *
	 * @return     { int type }
	 */
	public static int factorial(final int testnum) {
		if (testnum == 1) {
			return 1;
		}
		return testnum * factorial(testnum - 1);
	}
	/**
	 * { Main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputnum =  Integer.parseInt(scan.nextLine());
		int fact = factorial(inputnum);
		System.out.println("Factorial of " + inputnum + ": " + fact);
	}
}