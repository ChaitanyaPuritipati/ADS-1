import java.util.Scanner;
class minheap<Gen extends Comparable<Gen>>{
	Gen[] heaparr;
	int count;
	int flag;
	minheap(int size) {
		heaparr = (Gen[])new Comparable[size];
		count = 0;
		flag = 0;
	}
	// int compareTo 
	boolean less(Gen valueone, Gen valuetwo) {
		System.out.println(valueone + "one");
		System.out.println(valuetwo + "two");
		return valueone.compareTo(valuetwo) <= 0;
	}
	boolean swim(Gen[] heaparr, int nodeval) {
		System.out.println(nodeval + "nodevals");
		while (nodeval > 1) {
			if (less(heaparr[nodeval], heaparr[(nodeval - 1) / 2])) {
				return false;
			} else {
				nodeval = (nodeval - 1) / 2;
			}
		}
		return true;
	}
	int insert(Gen item) {
		heaparr[count++] = item;
		if (!swim(heaparr, count)) {
			flag = 1;
		}
		return flag;
	}

}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused
	}
	/**
	 * { Main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int testnum = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < testnum; i++) {
			outerloop:
			switch (line) {
			case "String":
				String[] tokens = scan.nextLine().split(",");
				minheap<String> minobj = new minheap<String>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = minobj.insert(tokens[j]);
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;
			default:
				System.out.println("not checking");
				break;
			}


		}
	}
}