import java.util.Scanner;
class Solution {
	private Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] sizes = scan.nextLine().split(" ");
		int magwordsnum = Integer.parseInt(sizes[0]);
		int ransomwordsnum = Integer.parseInt(sizes[1]);
		SeparateChainingHashST<String, Integer> schstobj = new SeparateChainingHashST<>();
		String[] magwords = scan.nextLine().split(" ");
		String[] ransomwords = scan.nextLine().split(" ");
		for(int i = 0; i < magwordsnum; i++) {
			schstobj.put(magwords[i], i);
		}
	}
}