import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] sizes = scan.nextLine().split(" ");
        int magwordsnum = Integer.parseInt(sizes[0]);
        int ransomwordsnum = Integer.parseInt(sizes[1]);
        SeparateChainingHashST<String, Integer> schstobj
            = new SeparateChainingHashST<>();
        String[] magwords = scan.nextLine().split(" ");
        String[] ransomwords = scan.nextLine().split(" ");
        for (int i = 0; i < magwordsnum; i++) {
            if (schstobj.contains(magwords[i])) {
                int countvar = schstobj.get(magwords[i]);
                schstobj.put(magwords[i], countvar + 1);
            } else {
                schstobj.put(magwords[i], 1);
            }
        }
        for (int j = 0; j < ransomwordsnum; j++) {
            if (schstobj.contains(ransomwords[j])
                    && schstobj.get(ransomwords[j]) > 0) {
                int count = schstobj.get(ransomwords[j]);
                schstobj.put(ransomwords[j], --count);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
