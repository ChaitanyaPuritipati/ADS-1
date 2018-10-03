import java.util.Scanner;
import java.util.Arrays;
class InsertionSort {
	
	boolean less(final  String inputone, final String inputtwo) {

		//checks for the greatness using compareTo function

		return inputone.compareTo(inputtwo) == -1;
	}
	void exchange(final String[] inputarray,
	              final int bigindex,
	              final int smallindex) {

		//creates a temporary variable to store the bigindex value

		String temp = inputarray[bigindex];

		//swap the indexe

		inputarray[bigindex] = inputarray[smallindex];

		inputarray[smallindex] = temp;
	}
	void sort(final String[] inputarray, final int start, final int end) {
		for (int i = start; i <= end; i++) {
			for (int j = i; j > start; j--) {
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
	// boolean issorted() {

	// }
	boolean less(final  String inputone, final String inputtwo) {

		//checks for the greatness using compareTo function

		return inputone.compareTo(inputtwo) == -1;
	}
	void merge(String[] inputarray, String[] storingarray, int first, int middle, int last) {
		int subarr1 = first;
		int subarr2 = middle + 1;
		for (int k = first; k <= last; k++) {
			if (subarr1 > middle) {
				storingarray[k] = inputarray[subarr2++];
			} else if (subarr2 > last) {
				storingarray[k] = inputarray[subarr1++];
			} else if (less(storingarray[subarr2], storingarray[subarr1])) {
				storingarray[k] = inputarray[subarr2++];
			} else {
				storingarray[k] = inputarray[subarr1++];
			}
		}
	}
	void sort(String[] storingarray, String[] inputarray, int first, int last) {
		// System.out.println(Arrays.toString(inputarray) + "called");
		InsertionSort insertion = new InsertionSort();
		if (last - first < 7) {
			insertion.sort(inputarray, first, last);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int middle = (first + last) / 2;
		sort(inputarray, storingarray, first, middle);
		sort(inputarray, storingarray, middle + 1, last);
		if (less(inputarray[middle], inputarray[middle + 1])) {
			for (int i = first; i <= last; i++) {
               inputarray[i] = storingarray[i];
			}
			System.out.println("Array is already sorted. So, skipped the call to merge...");
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
			int low = 0;
			int high = tokens.length - 1;
			String[] temparray =  Arrays.copyOf(tokens, tokens.length);
			sortobj.sort(temparray, tokens, low, high);
			System.out.println(Arrays.toString(tokens));
			System.out.println();
		}
	}
}