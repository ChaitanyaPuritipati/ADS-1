import java.util.Scanner;
class Stock implements Comparable<Stock> {
	private String stockname;
	private float stockchange;
	Stock(String name, float change) {
		this.stockname = name;
		this.stockchange = change;
	}
	public String getstockname() {
		return this.stockname;
	}
	public float getstockchange() {
		return this.stockchange;
	}
	public int compareTo(String other) {
		return this.stockname.compareTo(other);
	}
	public int compareTo(Stock other) {
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
	public String toString() {
		String str = "";
		str = str + this.stockname + " " + this.stockchange;
		return str;
	}
}
class Solution {
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree<String, Integer> maxST = new  BinarySearchTree<>();
		BinarySearchTree<String, Integer> minST = new BinarySearchTree<>();
		int stocknum = Integer.parseInt(scan.nextLine());
		// int maxfreq = 0;
		// int minfreq = 0;
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
			Stock maxathour = maxpqobj.max();
			// System.out.println(maxathour + "max");
			Stock minathour = minpqobj.min();
			// System.out.println(minathour + "min");
			for (Stock eachmaxstock : maxpqobj) {
				// System.out.println(eachmaxstock + "eachmaxstock");
				if (eachmaxstock.compareTo(maxathour) == 0) {
					if (!maxST.contains(eachmaxstock.getstockname())) {
						maxST.put(eachmaxstock.getstockname(), 1);
					}
					int value = maxST.get(eachmaxstock.getstockname());
					maxST.put(eachmaxstock.getstockname(), value++);
				} else {
					maxST.put(eachmaxstock.getstockname(), 0);
				}
			}
			for (Stock eachminstock : minpqobj) {
				if (eachminstock.compareTo(minathour) == 0) {
					if (!minST.contains(eachminstock.getstockname())) {
						minST.put(eachminstock.getstockname(), 1);
					}
					int valuemin = minST.get(eachminstock.getstockname());
					minST.put(eachminstock.getstockname(), valuemin++);
				} else {
					minST.put(eachminstock.getstockname(), 0);
				}
			}
			for (int j = 0; j < 5; j++) {
				Stock maxpqbest = maxpqobj.delMax();
				System.out.println(maxpqbest);
			}
			System.out.println();
			for (int k = 0; k < 5; k++) {
				Stock minpqworst = minpqobj.delMin();
				System.out.println(minpqworst);
			}
			System.out.println();
		}
		int querynum = Integer.parseInt(scan.nextLine());
		for (int l = 0; l < querynum; l++) {
			String[] querydetails = scan.nextLine().split(",");
			if (querydetails[0].equals("get")) {
				if (querydetails[1].equals("maxST")) {
					System.out.println(maxST.get(querydetails[2]));
				} else {
					System.out.println(minST.get(querydetails[2]));
				}
			}
		}

	}
}
