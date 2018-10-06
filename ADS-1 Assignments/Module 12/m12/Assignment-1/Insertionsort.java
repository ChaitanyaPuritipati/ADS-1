import java.util.Scanner;
import java.util.Arrays;
class Insertionsort {
	void exchange(studentdata[] array, int smallindex, int bigindex) {
		studentdata temp = array[smallindex];
		array[smallindex] = array[bigindex];
		array[bigindex] = temp;
	}
	boolean less(studentdata valueone, studentdata valuetwo) {
		return valueone.compareTo(valuetwo) == -1;
	}
	void sort(studentdata[] students) {
		for (int i = 1; i < students.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(students[j - 1], students[j])) {
					exchange(students, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
}
class studentdata implements Comparable<studentdata> {
	String studentname;
	String birthdate;
	int sub1marks;
	int sub2marks;
	int sub3marks;
	int totalmarks;
	String rescategory;
	studentdata(String name, String dob, int sub1, int sub2, int sub3, int total, String category) {
		this.studentname = name;
		this.birthdate = dob;
		this.sub1marks = sub1;
		this.sub2marks = sub2;
		this.sub3marks = sub3;
		this.totalmarks = total;
		this.rescategory = category;
	}
	String[] datesplit() {
		String[] splitdate = birthdate.split("-");
		return splitdate;
	}
	public int compareTo(studentdata other) {
		if (this.totalmarks > other.totalmarks) {
			return 1;
		}
		if (this.totalmarks < other.totalmarks) {
			return -1;
		}
		if (this.sub3marks > other.sub3marks) {
			return 1;
		}
		if (this.sub3marks < other.sub3marks) {
			return -1;
		}
		if (this.sub2marks > other.sub2marks) {
			return 1;
		}
		if (this.sub2marks < other.sub2marks) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[2]) > Integer.parseInt(other.datesplit()[2])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[2]) < Integer.parseInt(other.datesplit()[2])) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[1]) > Integer.parseInt(other.datesplit()[1])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[1]) < Integer.parseInt(other.datesplit()[1])) {
			return -1;
		}
		if (Integer.parseInt(this.datesplit()[0]) > Integer.parseInt(other.datesplit()[0])) {
			return 1;
		}
		if (Integer.parseInt(this.datesplit()[0]) < Integer.parseInt(other.datesplit()[0])) {
			return -1;
		}
		return 0;
	}

}