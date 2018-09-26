import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = Integer.parseInt(scan.nextLine());
		}
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int sum = array[i] + array[j];
				int check = Arrays.binarySearch(array, (0 - sum));
				if(check != -1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}