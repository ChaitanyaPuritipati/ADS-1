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
			Stock minathour = minpqobj.min();
			int maxfreq = 0;
			for (Stock eachmaxstock : maxpqobj) {
				if (eachmaxstock.compareTo(maxathour) == 0) {
					maxfreq++;
					maxST.put(eachmaxstock.getstockname(), maxfreq);
				} else {
					maxfreq = 0;
					maxST.put(eachmaxstock.getstockname(), maxfreq);
				}
			}
			int minfreq = 0;
			for (Stock eachminstock : minpqobj) {
				if (eachminstock.compareTo(maxathour) == 0) {
					minfreq++;
					minST.put(eachminstock.getstockname(), minfreq);
				} else {
					minfreq = 0;
					minST.put(eachminstock.getstockname(), minfreq);
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
