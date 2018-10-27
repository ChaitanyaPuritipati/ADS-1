import java.util.Scanner;
class Student {
	private String studentname;
	private double totalmarks;
	Student(String name, double marks) {
		this.studentname = name;
		this.totalmarks = marks;
	}
	public String getname() {
		return this.studentname;
	}
	public double getmarks() {
		return this.totalmarks;
	}
	public String toString() {
		String str = "";
		str = str + this.studentname + this.totalmarks;
		return str;
	}
}
class Solution {
	private Solution() {
		//unused
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int putnum = Integer.parseInt(scan.nextLine());
		SeparateChainingHashST<Integer, Student> schsobj = new SeparateChainingHashST<>();
		for (int i = 0; i < putnum; i++) {
			String[] tokens = scan.nextLine().split(",");
			Student studentobj = new Student(tokens[1], Double.parseDouble(tokens[2]));
			schsobj.put(Integer.parseInt(tokens[0]), studentobj);
		}
		int querynum = Integer.parseInt(scan.nextLine());
		for (int j = 0; j < querynum; j++) {
			String[] querytokens = scan.nextLine().split(" ");
			if (querytokens[0].equals("get")) {
				if (Integer.parseInt(querytokens[2]) == 1) {
					if (schsobj.get(Integer.parseInt(querytokens[1])) == null) {
						System.out.println("Student doesn't exists...");
					} else {
						System.out.println(schsobj.get(Integer.parseInt(querytokens[1])).getname());
					}

				} else {
					if (schsobj.get(Integer.parseInt(querytokens[1])) == null) {
						System.out.println("Student doesn't exists...");
					} else {
						System.out.println(schsobj.get(Integer.parseInt(querytokens[1])).getmarks());
					}
				}
			}
		}
	}
}