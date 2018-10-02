import java.util.Arrays;
import java.util.Scanner;
class insertionSort {

	// boolean less( inputone, Comparable inputtwo) {
	// 	return inputone.compareTo(inputtwo) == -1;
	// }

	boolean greater(teamdata inputone, teamdata inputtwo) {
		return inputone.compareTo(inputtwo) == 1;
	}

	void exchange(teamdata[] inputarray, int bigindex, int smallindex) {
		teamdata temp = inputarray[bigindex];
		inputarray[bigindex] = inputarray[smallindex];
		inputarray[smallindex] = temp;
	}

	void Sort(teamdata[] inputarray) {
		int length = inputarray.length;
		for (int i = 1; i < length; i++) {
			for (int j = i; j > 0; j--) {
				if (greater(inputarray[j], inputarray[j - 1])) {
					exchange(inputarray, j, j - 1);
				} else {
					break;
				}
			}
		}
		for(int i = 0; i < inputarray.length; i++) {
			System.out.print(inputarray[i].teamname);
		}
		System.out.println();
	}
}
class teamdata implements Comparable<teamdata> {
	String teamname;
	int teamwins;
	int teamlosses;
	int teamdraws;
	teamdata(String name, int wins, int losses, int draws) {
		this.teamname = name;
		this.teamwins = wins;
		this.teamlosses = losses;
		this.teamdraws = draws;
	}
	public int compareTo(teamdata other) {
		if (this.teamwins > other.teamwins) {
			return 1;
		}
		if (this.teamwins < other.teamwins) {
			return -1;
		}
		if (this.teamlosses > other.teamlosses) {
			return -1;
		}
		if (this.teamlosses < other.teamlosses) {
			return 1;
		}
		if (this.teamdraws > other.teamdraws) {
			return 1;
		}
		if (this.teamdraws < other.teamdraws) {
			return -1;
		}
		return 0;
	}
}
class Solution {
	public static void main(String[] args) {
		teamdata[] data = new teamdata[10];
		int count = 0;
		insertionSort startobj = new insertionSort();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			teamdata everydata = new teamdata(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
			data[count] = everydata;
			count++;
		}
		data = Arrays.copyOf(data, count);
		startobj.Sort(data);
	}
}