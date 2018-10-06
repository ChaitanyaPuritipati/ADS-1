import java.util.Scanner;
import java.util.Arrays;
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
     * { var_description }.
     */
    private static int opencount = 0;
    /**
     * { var_description }.
     */
    private static int bccount = 0;
    /**
     * { var_description }.
     */
    private static int sccount = 0;
    /**
     * { var_description }.
     */
    private static int stcount = 0;
    /**
     * { countingcat }.
     * complexity: O(N)
     *
     * @param      array  The array
     */
    public static void countcat(final studentdata[] array) {
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
    /**
     * { meritarray }.
     * complexity: O(N)
     *
     * @param      array    The array
     * @param      vacancy  The vacancy
     * @param      open     The open
     * @param      bc       { parameter_description }
     * @param      sc       The screen
     * @param      st       { parameter_description }
     */
    public static void meritfill(final studentdata[] array,
                                 final int vacancy, final int open,
                                 final int bc, final int sc,
                                 final int st) {
        countcat(array);
        int vacancynew = vacancy;
        int opennew = open;
        int bcnew = bc;
        int scnew = sc;
        int stnew = st;
        final int thirty = 30;
        studentdata[] merit = new studentdata[thirty];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (vacancynew == 0) {
                break;
            }
            if (opennew > 0) {
                merit[count++] = array[i];
                opennew--;
                vacancynew--;

            } else {
                if (array[i].rescategory.equals("BC")
                        || array[i].rescategory.equals("SC")
                        || array[i].rescategory.equals("ST")) {
                    if (array[i].rescategory.equals("BC") && bcnew > 0) {
                        merit[count++] = array[i];
                        bcnew--;
                        vacancynew--;
                    } else if (array[i].rescategory.equals("SC") && scnew > 0) {

                        merit[count++] = array[i];
                        scnew--;
                        vacancynew--;
                    } else if (array[i].rescategory.equals("ST") && stnew > 0) {
                        merit[count++] = array[i];
                        stnew--;
                        vacancynew--;
                    }
                } else if (vacancynew > 0 && bccount == 0 && sccount == 0 && stcount == 0) {
                    merit[count++] = array[i];
                    vacancynew--;
                }
            }

        }
        if (vacancynew > 0) {
            for (int i = 0; i < array.length; i++) {
                if (vacancynew <= 0) {
                    break;
                }
                if (array[i] != merit[i]) {
                    merit[count++] = array[i];
                    vacancynew--;
                }
            }
        }
        merit = Arrays.copyOf(merit, count);
        Insertionsort newinsert = new Insertionsort();
        newinsert.sort(merit);
        for (int i = 0; i < merit.length; i++) {
            System.out.println(merit[i].studentname + ","
                               + merit[i].totalmarks + ","
                               + merit[i].rescategory);
        }

    }
    /**
     * { print }.
     * O(N)
     * @param      array  The array
     */
    public static void print(final studentdata[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].studentname + ","
                               + array[i].totalmarks + ","
                               + array[i].rescategory);
        }
    }
    /**
     * { main }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
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
                    Integer.parseInt(tokens[2]), Integer.parseInt(tokens[three]),
                    Integer.parseInt(tokens[four]), Integer.parseInt(tokens[five]), tokens[six]);
            students[i] = eachstudentdata;
        }
        Insertionsort insertion = new Insertionsort();
        insertion.sort(students);
        print(students);
        System.out.println();
        meritfill(students, vacancynum,
                  openvacancy, bcvacancy,
                  scvacancy, stvacancy);
    }

}