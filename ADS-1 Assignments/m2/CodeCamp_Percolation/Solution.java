import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputsize = Integer.parseInt(scan.nextLine());
		Percolation pt = new Percolation(inputsize);
		while(scan.hasNext()) {
			pt.open(Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()));
		}
		System.out.println(pt.percolates());
	}
}
