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
		for (int i = 0; i < magwordsnum; i++) {
			if (schstobj.contains(magwords[i])) {
				int countvar = schstobj.get(magwords[i]);
				schstobj.put(magwords[i], countvar + 1);
			} else {
				schstobj.put(magwords[i], 1);
			}
		}
		int flag = 0;
		for (int j = 0; j < ransomwordsnum; j++) {
			if (schstobj.contains(ransomwords[j]) && schstobj.get(ransomwords[j]) > 0) {
				int count = schstobj.get(ransomwords[j]);
				schstobj.put(ransomwords[j], --count);
			} else {
				// flag = 1;
				System.out.println("No");
				return;
			}
		}
		// if (flag == 1) {
		// 	System.out.println("No");
		// } else {
			System.out.println("Yes");
		// }
	}
}