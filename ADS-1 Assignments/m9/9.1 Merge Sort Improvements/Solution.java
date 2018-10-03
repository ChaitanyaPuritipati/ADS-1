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
	              final int smallindex,
	              final int bigindex) {

		//creates a temporary variable to store the bigindex value

		int temp = inputarray[bigindex];

		//swap the indexe

		inputarray[bigindex] = inputarray[smallindex];

		inputarray[smallindex] = temp;
	}
	void sort(final int[] inputarray, final int start, final int end) {
		for (int i = start; i < end; i++) {
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
	boolean less(final  Integer inputone, final Integer inputtwo) {

		//checks for the greatness using compareTo function

		return inputone.compareTo(inputtwo) == -1;
	}
	void merge(int[] storingarray, int[] inputarray, int first, int middle, int last) {
		int i = first;
		int j = middle + 1;
		for(int k = first; k <= last; k++) {
			if(i > middle) {
				storingarray[k] = inputarray[j++];
			} else if(j > last) {
				storingarray[k] = inputarray[i++];
			} else if(less(inputarray[j], inputarray[i])) {
				storingarray[k] = inputarray[j++];
			} else {
				storingarray[k] = inputarray[i++];
			}
		}
	}
	void sort(int[] inputarray, int[] storingarray, int first, int last) {
		InsertionSort insertion = new InsertionSort();
		if (last <= first + 6) {
			System.out.println("Insertion sort method invoked...");
			insertion.sort(storingarray, first, last);
			return;
		}
		int middle = (first + last) / 2;
		sort(storingarray, inputarray, first, middle);
		sort(storingarray, inputarray, middle + 1, last);
		if(!less(storingarray[middle + 1], storingarray[middle])) {
			return;
		}
		merge(storingarray, inputarray, first, middle, last);
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
			int high = array.length;
			int[] temparray = new int[array.length];
			sortobj.sort(array, temparray, low, high);
			System.out.println(Arrays.toString(temparray));
			System.out.println("-------------------------------------------");
		}
	}
}