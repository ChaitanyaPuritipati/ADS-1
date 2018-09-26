import java.util.*;
import java.io.*;
class Solution {
	Solution() {
		//unused
	}
	public static void main(String[] args) {
		try {
			File testfile = new File("testfile.txt");
			Scanner scan = new Scanner(testfile);
			while (scan.hasNext()) {
				String line = scan.nextLine();
				String[] tokens = line.split(",");
				int[] array = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
				Arrays.sort(array);
				int testvalue = Integer.parseInt(scan.nextLine());
				int first = 0;
				int last = array.length;
				int present = 0;
				int middle = 0;
				if(array.length == 1 && array[array.length - 1] == testvalue) {
                    System.out.println("Array contains " + testvalue +" at " + first);
                    return; 
				}
				while (last != first) {
					middle = ((first + last) / 2);
					if (array[middle] == testvalue) {
						present = 1;
						last = middle;
					} else if (array[middle] < testvalue) {
						first = middle + 1;
					} else {
						last = middle - 1;
					}
				}
				if(present == 1) {
					System.out.println("Array contains " + testvalue +" at " + last);
					return;
				}
				System.out.println("Array does not contains " + testvalue);
			}
		} catch (Exception io) {
			System.out.println("FILE NOT FOUND");
			return;
		}
	}
}