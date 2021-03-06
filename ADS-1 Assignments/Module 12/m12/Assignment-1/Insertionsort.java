import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for insertionsort.
 */
class Insertionsort {
	/**
	 * { exchanges two items }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @param      array       The array
	 * @param      smallindex  The smallindex
	 * @param      bigindex    The bigindex
	 */
	void exchange(final studentdata[] array,
	              final int smallindex,
	              final int bigindex) {
		studentdata temp = array[smallindex];
		array[smallindex] = array[bigindex];
		array[bigindex] = temp;
	}
	/**
	 * { To check min element }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @param      valueone  The valueone
	 * @param      valuetwo  The valuetwo
	 *
	 * @return     { boolean }
	 */
	boolean less(final studentdata valueone,
	             final studentdata valuetwo) {
		return valueone.compareTo(valuetwo) == -1;
	}
	/**
	 * { Insertion sort function }.
	 * Complexity: Best: O(N^2)
	 *             Worst: O(N^2)
	 *             Average: O(N^2)
	 *
	 * @param      students  The students
	 */
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
/**
 * Class for studentdata.
 */
class studentdata implements Comparable<studentdata> {
	/**
	 * { studentname }.
	 */
	String studentname;
	/**
	 * { birthdate }.
	 */
	String birthdate;
	/**
	 * { sub1marks }.
	 */
	int sub1marks;
	/**
	 * { sub2marks }.
	 */
	int sub2marks;
	/**
	 * { sub3marks }.
	 */
	int sub3marks;
	/**
	 * { totalmarks }.
	 */
	int totalmarks;
	/**
	 * { rescategory }.
	 */
	String rescategory;
	/**
	 * Constructs the object.
	 *
	 * @param      name      The name
	 * @param      dob       The dob
	 * @param      sub1      The sub 1
	 * @param      sub2      The sub 2
	 * @param      sub3      The sub 3
	 * @param      total     The total
	 * @param      category  The category
	 */
	studentdata(final String name,
	            final String dob,
	            final int sub1,
	            final int sub2,
	            final int sub3,
	            final int total,
	            final String category) {
		this.studentname = name;
		this.birthdate = dob;
		this.sub1marks = sub1;
		this.sub2marks = sub2;
		this.sub3marks = sub3;
		this.totalmarks = total;
		this.rescategory = category;
	}
	/**
	 * { To split the data string }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @return     { description_of_the_return_value }
	 */
	String[] datesplit() {
		String[] splitdate = birthdate.split("-");
		return splitdate;
	}
	/**
	 * { CompareTo function }.
	 * Complexity: Best: O(1)
	 *             Worst: O(1)
	 *             Average: O(1)
	 *
	 * @param      other  The other
	 *
	 * @return     { int }
	 */
	public int compareTo(final studentdata other) {
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