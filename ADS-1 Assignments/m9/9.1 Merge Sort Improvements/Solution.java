import java.util.Scanner;
import java.util.Arrays;
class InsertionSort {
	// int compareTo(int other) {
	// if()
	// }
	boolean less(final  Integer inputone, final Integer inputtwo) {

		//checks for the greatness using compareTo function

		return inputone.compareTo(inputtwo) == -1;
	}
	void exchange(final int[] inputarray,
	              final int bigindex,
	              final int smallindex) {

		//creates a temporary variable to store the bigindex value

		int temp = inputarray[bigindex];

		//swap the indexe

		inputarray[bigindex] = inputarray[smallindex];

		inputarray[smallindex] = temp;
	}
	void sort(final int[] inputarray, final int start, final int end) {
		for (int i = start; i <= end; i++) {
			for (int j = i; j > 0; j--) {
				if (less(inputarray[j], inputarray[j - 1])) {

					//call the exchange function.

					exchange(inputarray, j, j - 1);
				} else {
					break;
				}
			}
		}
	}
}
class Mergesort {
	void sort(int[] inputarray, int[] storingarray, int first, int last) {
		InsertionSort insertion = new InsertionSort();
		if (last <= first + 6) {
			if (last - first < 7) {
				System.out.println("Insertion");
				insertion.sort(inputarray, first, last);
				return;
			}
			for (int i = first; i <= last; i++) {
				System.out.print(inputarray[i]);
			}
			System.out.println("------------------------------------------ + Arrays line");
			int middle = (first + last) / 2;
			sort(inputarray, storingarray, first, middle);
			sort(inputarray, storingarray, middle + 1, last);
		}
	}
}
class Solution {
	Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Mergesort sortobj = new Mergesort();
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			int[] array = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
			int low = 0;
			int high = array.length - 1;
			int[] temparray = new int[array.length];
			sortobj.sort(array, temparray, low, high);
			System.out.println(Arrays.toString(array));
			System.out.println("-------------------------------------------");
		}
	}
}