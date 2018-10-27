import java.util.Scanner;
/**
 * Class for student.
 */
class Student {
    /**
     * { studentname }.
     */
    private String studentname;
    /**
     * { totalmarks }.
     */
    private double totalmarks;
    /**
     * Constructs the object.
     *
     * @param      name   The name
     * @param      marks  The marks
     */
    Student(final String name, final double marks) {
        this.studentname = name;
        this.totalmarks = marks;
    }
    /**
     * { getname function }.
     * Complexity is O(1).
     *
     * @return     { String type }
     */
    public String getname() {
        return this.studentname;
    }
    /**
     * { getmarks function }.
     * Complexity is O(1).
     * @return     { description_of_the_return_value }
     */
    public double getmarks() {
        return this.totalmarks;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = str + this.studentname + this.totalmarks;
        return str;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int putnum = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<Integer, Student> schsobj =
            new SeparateChainingHashST<>();
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