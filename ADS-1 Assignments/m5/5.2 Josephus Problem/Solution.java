import java.util.Scanner;
import java.util.Arrays;
class Josephus {
	int[] seats;
	int size;
	int skipval;
	Josephus(int inputsize, int inputskipval) {
		this.seats = new int[inputsize];
		this.size = inputsize;
		for (int l = 0; l < this.size; l++) {
			seats[l] = l;
		}
		this.skipval = inputskipval;
	}
	void removing() {
		int i = 0;
		String str = "";
		while (this.size > 0) {
			int rem = 0;
			// System.out.println(size + "sizeval");
			// System.out.println("size val" + size);
			// System.out.println(i + skipval -1 + "before if");
			while (i + skipval - 1 > (this.size) - 1) {
				i = i - this.size ;
			}
			// System.out.println(i + "value of i");
			// System.out.println(i + skipval -1 + "after if");
			// System.out.println(Arrays.toString(seats) + "Arrayssssss");
			str = str + seats[i + skipval - 1] + " ";
			for (int j = i + skipval - 1; j < this.size - 1; j++) {
				seats[j] = seats[j + 1];
			}
			// System.out.println(Arrays.toString(seats));
			i = i + skipval - 1;
			this.size--;
			// System.out.println(this.size + "later");
		}
		str = str.trim();
		System.out.println(str);
	}

}
class Solution {
	Solution() {
		//unused;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testnum = Integer.parseInt(scan.nextLine());
		for (int k = 0; k < testnum; k++) {
			String[] tokens = scan.nextLine().split(" ");
			Josephus start = new Josephus(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			start.removing();
		}
	}
}