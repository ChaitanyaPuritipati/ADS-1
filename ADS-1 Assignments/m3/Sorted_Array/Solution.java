import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		int arr1size = Integer.parseInt(scan.nextLine());
		int arr2size = Integer.parseInt(scan.nextLine());
		String line = scan.nextLine();
		if (line != null) {
			String[] arr1 = line.split(",");
			int[] array1 = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array1);
			System.out.println(Arrays.toString(array1));

		}
		line = scan.nextLine();
		System.out.println(line);
		if (line != null) {
			String[] arr2 = line.split(",");
			int[] array2 = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array2);
			System.out.println(Arrays.toString(array2));
		}

	}
}