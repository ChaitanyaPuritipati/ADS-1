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
		RedBlackBST<Double, Student> redobj = new RedBlackBST<>();
		for(int i = 0; i < putnum; i++) {
			String[] tokens = scan.nextLine().split(",");
			Student studentobj = new Student(tokens[1], Integer.parseInt(tokens[0]));
			redobj.put(Double.parseDouble(tokens[2]), studentobj);
		}
		System.out.println(redobj.rank(85.5) - redobj.rank(76.7));
		
	}
}