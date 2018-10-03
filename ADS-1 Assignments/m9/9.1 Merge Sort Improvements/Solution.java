import java.util.Scanner;
import java.util.Arrays;
class Mergesort {
	void sort(int[] inputarray, int[] storingarray, int first, int last) {
		if(last - first < 7) {
			System.out.println("Insertion");
		}
		for(int i = first; i <=last; i++) {
			System.out.print(inputarray[i]);
		}
		System.out.println("------------------------------------------ + Arrays line");
		int middle = (first + last)/2;
		sort(inputarray, storingarray, first, middle);
		sort(inputarray, storingarray, middle + 1, last);
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