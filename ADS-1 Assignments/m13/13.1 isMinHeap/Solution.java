import java.util.Scanner;
class minheap<Gen extends Comparable<Gen>> {
	Gen[] heaparr;
	int count;
	int flag;
	minheap(int size) {
		heaparr = (Gen[])new Comparable[size];
		count = 0;
		flag = 0;
	}
	boolean less(Gen valueone, Gen valuetwo) {
		return valueone.compareTo(valuetwo) <= 0;
	}
	boolean swim(Gen[] heaparr, int nodeval) {
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
		if (!swim(heaparr, count - 1)) {
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
			case "Integer":
				tokens = scan.nextLine().split(",");
				minheap<Integer> minobjint = new minheap<Integer>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = minobjint.insert(Integer.parseInt(tokens[j]));
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;
			case "Double":
				tokens = scan.nextLine().split(",");
				minheap<Double> minobjdou = new minheap<Double>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = minobjdou.insert(Double.parseDouble(tokens[j]));
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;	
			default:
				// System.out.println("not checking");
				break;
			}


		}
	}
}