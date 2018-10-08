import java.util.Scanner;
/**
 * Class for minheap.
 *
 * @param      <Gen>  The generate
 */
class minheap<Gen extends Comparable<Gen>> {
	/**
	 * { Heaparray }.
	 */
	Gen[] heaparr;
	/**
	 * { counter }.
	 */
	int count;
	/**
	 * { flag value }.
	 */
	int flag;
	/**
	 * Constructs the object.
	 *
	 * @param      size  The size
	 */
	minheap(final int size) {
		heaparr = (Gen[])new Comparable[size];
		count = 0;
		flag = 0;
	}
	/**
	 * { To check if the first element is less than the second element }.
	 *
	 * @param      valueone  The valueone
	 * @param      valuetwo  The valuetwo
	 *
	 * @return     { boolean type }
	 */
	boolean less(Gen valueone, Gen valuetwo) {
		return valueone.compareTo(valuetwo) < 0;
	}
	/**
	 * { To compare child node with its parents }.
	 *
	 * @param      heaparr  The heaparr
	 * @param      nodeval  The nodeval
	 *
	 * @return     { boolean type }
	 */
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
	/**
	 * { To insert an element }.
	 *
	 * @param      item  The item
	 *
	 * @return     { int type }
	 */
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
			case "Float":
				tokens = scan.nextLine().split(",");
				if(tokens[0].equals("")) {
					System.out.println("false");
					break;
				}
				minheap<Float> minobjflo = new minheap<Float>(tokens.length);
				for (int j = 0; j < tokens.length; j++) {
					int returnval = minobjflo.insert(Float.parseFloat(tokens[j]));
					if (returnval == 1) {
						System.out.println("false");
						break outerloop;
					}
				}
				System.out.println("true");
				break;		
			default:
				break;
			}
		}
	}
}