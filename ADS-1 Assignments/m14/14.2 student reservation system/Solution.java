import java.util.Scanner;
/**
 * { Solution class }.
 */
public final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        HeapSort sort = new HeapSort();
        int testnum = Integer.parseInt(scan.nextLine());
        int noOfVacancies = Integer.parseInt(scan.nextLine());
        int vac1 = Integer.parseInt(scan.nextLine());
        int vac2 = Integer.parseInt(scan.nextLine());
        int vac3 = Integer.parseInt(scan.nextLine());
        int vac4 = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testnum; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            Student student = new Student(tokens[0], tokens[1],
             Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1]),
             Integer.parseInt(tokens[2 + 2]), Integer.parseInt(tokens[2 + 2 + 1]),
             tokens[2 + 2 + 2]);
            sort.add(student);
        }
        sort.sort();
        System.out.println(sort.toString());
        sort.vacancy1(vac1);
        sort.vacancy2(vac1, vac2, vac3, vac4);
    }
}
