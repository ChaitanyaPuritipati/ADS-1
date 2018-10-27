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
		str = str + this.studentname + this.rollnumber;
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
		Double min = 76.7;
		Double max = 85.5;
		bstobj.range(bstobj.root, min, max);
		min = 65.0;
		max = 70.0;
		bstobj.range(bstobj.root, min, max);
	}
}