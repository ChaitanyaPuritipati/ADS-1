import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
	/**
	 * { nameofthestock }.
	 */
	private String stockname;
	/**
	 * { changevalueofstock }.
	 */
	private float stockchange;
	/**
	 * Constructs the object.
	 *
	 * @param      name    The name
	 * @param      change  The change
	 */
	Stock(final String name, final float change) {
		this.stockname = name;
		this.stockchange = change;
	}
	/**
	 * { getstockname }.
	 *
	 * @return     { String type }
	 */
	public String getstockname() {
		return this.stockname;
	}
	/**
	 * { getstockchange }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public float getstockchange() {
		return this.stockchange;
	}
	/**
	 * { For comparing }.
	 *
	 * @param      other  The other
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(final Stock other) {
		if (this.stockchange > other.stockchange) {
			return 1;
		}
		if (this.stockchange < other.stockchange) {
			return -1;
		}
		if (this.stockname.compareTo(other.stockname) > 0) {
			return 1;
		}
		if (this.stockname.compareTo(other.stockname) < 0) {
			return -1;
		}
		return 0;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		str = str + this.stockname + " " + this.stockchange;
		return str;
	}
}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused.
	}
	/**
	 * { Main function }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree<String, Integer> maxST = new  BinarySearchTree<>();
		BinarySearchTree<String, Integer> minST = new BinarySearchTree<>();
		int stocknum = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < 6; i++) {
			int count = 0;
			MinPQ<Stock> minpqobj = new MinPQ<>();
			MaxPQ<Stock> maxpqobj = new MaxPQ<>();
			while (count < stocknum) {
				String[] details = scan.nextLine().split(",");
				Stock stockobj = new Stock(details[0], Float.parseFloat(details[1]));
				minpqobj.insert(stockobj);
				maxpqobj.insert(stockobj);
				count++;
			}
			for (int j = 0; j < 5; j++) {
				Stock maxpqbest = maxpqobj.delMax();
				if (maxST.contains(maxpqbest.getstockname())) {
					int value = maxST.get(maxpqbest.getstockname());
					maxST.put(maxpqbest.getstockname(), ++value);
				} else {
					maxST.put(maxpqbest.getstockname(), 1);
				}
				System.out.println(maxpqbest);
			}
			System.out.println();
			for (int k = 0; k < 5; k++) {
				Stock minpqworst = minpqobj.delMin();
				if (minST.contains(minpqworst.getstockname())) {
					int valuemin = minST.get(minpqworst.getstockname());
					minST.put(minpqworst.getstockname(), ++valuemin);
				} else {
					minST.put(minpqworst.getstockname(), 1);
				}
				System.out.println(minpqworst);
			}
			System.out.println();
		}
		int querynum = Integer.parseInt(scan.nextLine());
		for (int l = 0; l < querynum; l++) {
			String[] querydetails = scan.nextLine().split(",");
			if (querydetails[0].equals("get")) {
				if (querydetails[1].equals("maxST")) {
					if(!maxST.contains(querydetails[2])) {
						System.out.println("0");
					} else {
						System.out.println(maxST.get(querydetails[2]));
					}
				} else {
					if(!minST.contains(querydetails[2])) {
						System.out.println("0");
					} else {
						System.out.println(minST.get(querydetails[2]));
					}
				}

			}
			if(querydetails[0].equals("intersection")) {
				for(String eachkey: maxST.getkeys()) {
					if(eachkey != null && minST.contains(eachkey)) {
						System.out.println(eachkey);
					}
				}
			}
		}

	}
}
