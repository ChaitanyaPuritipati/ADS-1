import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputsize = Integer.parseInt(scan.nextLine());
		Percolation pt = new Percolation(inputsize);
		while(scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(" ");
			pt.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		System.out.println(pt.percolates());
	}
}
