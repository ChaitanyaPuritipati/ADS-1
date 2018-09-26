import java.util.Scanner;
import java.io.File;
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
				int count = 1;
				int sum = 0;
				int temp = array[0];
				for (int i = 1; i < array.length; i++) {
					if (array[i] == temp) {
						count++;
					} else {
						if (count > 1) {
							sum = sum + (((count) * (count - 1)) / 2);
						}
						count = 1;
						temp = array[i];
					}
					if((i == (array.length - 1)) && count > 1) {
						sum = sum + (((count) * (count - 1)) / 2);
					}
				}
				System.out.println(sum);
			}
		} catch (Exception io) {
			System.out.println("FILE NOT FOUND");
			return;
		}
	}
}