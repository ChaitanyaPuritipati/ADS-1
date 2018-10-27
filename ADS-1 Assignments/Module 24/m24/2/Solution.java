import java.util.Scanner;
class Student {
	private String studentname;
	private Integer rollnumber;
	Student(String name, Integer  num) {
		this.studentname = name;
		this.rollnumber = num;
	}
	public String getname() {
		return this.studentname;
	}
	public Integer getnumber() {
		return this.rollnumber;
	}
	public String toString() {
		String str = "";
		str = str + this.studentname;
		return str;
	}
}
class Solution {
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int putnum = Integer.parseInt(scan.nextLine());
		BST<Double, Student> bstobj = new BST<>();
		for(int i = 0; i < putnum; i++) {
			String[] tokens = scan.nextLine().split(",");
			Student studentobj = new Student(tokens[1], Integer.parseInt(tokens[0]));
			bstobj.put(Double.parseDouble(tokens[2]), studentobj);
		}
		int querynum = Integer.parseInt(scan.nextLine());
		for(int j = 0; j < querynum; j++) {
			String[] querytokens = scan.nextLine().split(" ");
			if(querytokens[0].equals("BE")) {
				bstobj.range(bstobj.root, Double.parseDouble(querytokens[1]), Double.parseDouble(querytokens[2]));
			}
		}
	}
}