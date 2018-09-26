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
		int[] array1 = new int[arr1size];
		int[] array2 = new int[arr2size];
		if (!line.equals("")) {
			String[] arr1 = line.split(",");
			array1 = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array1);
			System.out.println(Arrays.toString(array1));

		}
		line = scan.nextLine();
		if (!line.equals("")) {
			String[] arr2 = line.split(",");
			array2 = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(array2);
			System.out.println(Arrays.toString(array2));
		}
		int count = 0;
		int[] array3 = new int[arr1size + arr2size];
		for (int i = 0, j = 0; count < arr1size + arr2size; count++) {
			System.out.println(count);
			if (array1[i] < array2[j]) {
				array3[count] = array1[i];
				i++;
			}
			if (array1[i] > array2[j]) {
				array3[count] = array2[j];
				j++;
			}
		}
	}
}