import java.util.Scanner;
class problemone {
	public static int factorial(int testnum) {
		if (testnum == 1) {
			return 1;
		}
		return testnum * factorial(testnum - 1);
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputnum =  Integer.parseInt(scan.nextLine());
		int fact = factorial(inputnum);
		System.out.println("Factorial of " + inputnum + ": " + fact);
	}
}