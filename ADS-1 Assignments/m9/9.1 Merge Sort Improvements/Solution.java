import java.util.Scanner;
import java.util.Arrays;
class Mergesort {

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
			System.out.println(Arrays.toString(array));
		}
	}
}