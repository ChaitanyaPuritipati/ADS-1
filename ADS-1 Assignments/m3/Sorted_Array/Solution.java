import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		while (scan.hasNext()) {
			int arr1size = Integer.parseInt(scan.nextLine());
			int arr2size = Integer.parseInt(scan.nextLine());
			String line = scan.nextLine();
			String[] arr1 = line.split(",");
			Arrays.sort(arr1);
			System.out.println(Arrays.toString(arr1));
			line = scan.nextLine();
			String[] arr2 = line.split(",");
			Arrays.sort(arr2);
			System.out.println(Arrays.toString(arr2));
		}

	}
}