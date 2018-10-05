import java.util.Scanner;
import java.util.Arrays;
class Solution {
     public static void main(String[] args) {
     		Scanner scan = new Scanner(System.in);
     		int testnum = Integer.parseInt(scan.nextLine());
     		for(int i = 0; i < testnum; i++) {
     			int cutoffval = Integer.parseInt(scan.nextLine());
     			String[] inputarray = scan.nextLine().split("");
     			System.out.println(Arrays.toString(inputarray));
     		}
     	}	
}