import java.util.Scanner;
import java.util.Arrays;
class Solution {
	Solution() {
		//unused
	}
	static int opencount = 0;
	static int bccount = 0;
	static int sccount = 0;
	static int stcount = 0;
	public static void countcat(studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].rescategory.equals("Open")) {
				opencount++;
			}
			if (array[i].rescategory.equals("BC")) {
				bccount++;
			}
			if (array[i].rescategory.equals("SC")) {
				sccount++;
			}
			if (array[i].rescategory.equals("ST")) {
				stcount++;
			}
		}
	}
	public static void meritfill(studentdata[] array, int vacancy, int open, int bc, int sc, int st) {
		countcat(array);
		studentdata[] merit = new studentdata[30];
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (vacancy == 0) {
				// System.out.println("entered");
				break;
			}
			if (open > 0) {
				merit[count++] = array[i];
				open--;
				vacancy--;

			} else {
				if (array[i].rescategory.equals("BC") || array[i].rescategory.equals("SC") || array[i].rescategory.equals("ST")) {
					if (array[i].rescategory.equals("BC") && bc > 0) {
						
						merit[count++] = array[i];
						bc--;
						vacancy--;
					} else if (array[i].rescategory.equals("SC") && sc > 0) {
						
						merit[count++] = array[i];
						sc--;
						vacancy--;
					} else if (array[i].rescategory.equals("ST") && st > 0) {
						merit[count++] = array[i];
						st--;
						vacancy--;
					}
				} else if (vacancy > 0 && bccount == 0 && sccount == 0 && stcount == 0) {
					merit[count++] = array[i];
					vacancy--;
				}
			}

		}
		if (vacancy > 0) {
			for (int i = 0; i < array.length; i++) {
				if (vacancy <= 0 ) {
					break;
				}
				if (array[i] != merit[i]) {
					merit[count++] = array[i];
					vacancy--;
				}
			}
		}
		merit = Arrays.copyOf(merit, count);
		Insertionsort newinsert = new Insertionsort();
		newinsert.sort(merit);
		for (int i = 0; i < merit.length; i++) {
			System.out.println(merit[i].studentname + "," +
			                   merit[i].totalmarks + "," +
			                   merit[i].rescategory);
		}

	}

	public static void print(studentdata[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].studentname + "," +
			                   array[i].totalmarks + "," +
			                   array[i].rescategory);
		}
	}
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		studentdata[] students = new studentdata[num];
		int vacancynum = Integer.parseInt(scan.nextLine());
		int openvacancy = Integer.parseInt(scan.nextLine());
		int bcvacancy = Integer.parseInt(scan.nextLine());
		int scvacancy = Integer.parseInt(scan.nextLine());
		int stvacancy = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < num; i++) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			studentdata eachstudentdata = new studentdata(tokens[0], tokens[1],
			        Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
			        Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
			students[i] = eachstudentdata;
		}
		Insertionsort insertion = new Insertionsort();
		insertion.sort(students);
		print(students);
		System.out.println();
		meritfill(students, vacancynum, openvacancy, bcvacancy, scvacancy, stvacancy);
	}

}