import java.util.Scanner;
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
        //unused
    }
    /**
     * { numtodig }.
     *
     * @param      number  The number
     *
     * @return     { linkedlist }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList numtodig = new LinkedList();
        for (int i = number.length() - 1; i >= 0; i--) {
            String ele = "" + number.charAt(i);
            numtodig.push(Integer.parseInt(ele));
        }
        return numtodig;
    }
    /**
     * { digtonum }.
     *
     * @param      list  The list
     *
     * @return     { stringtype }
     */
    public static String digitsToNumber(final LinkedList list) {
        return list.print();
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { linkedlist }
     */
    public static LinkedList
    addLargeNumbers(
        final LinkedList list1,
        final LinkedList list2) {
        LinkedList carry = new LinkedList();
        final int ten = 10;
        final int nine = 9;
        carry.push(0);
        if (list1.size <= list2.size) {
            int out = 0;
            String result = "";
            while (!list1.isEmpty()) {
                out = carry.pop()
                      + list1.reversepop(list1.size)
                      + list2.reversepop(list2.size);
                result =  (out % ten) + result;
                if (out > nine) {
                    carry.push(out / ten);
                } else {
                    carry.push(0);
                }
            }
            while (!list2.isEmpty()) {
                result =  list2.reversepop(list2.size) + carry.pop() + result;
                carry.push(0);
            }
            if (carry.first.data != 0) {
                result = carry.pop() + result;
            }
            return numberToDigits(result);
        } else {
            int out = 0;
            String result = "";
            while (!list2.isEmpty()) {
                out = carry.pop()
                      + list1.reversepop(list1.size)
                      + list2.reversepop(list2.size);
                result = result + (out % ten);
                if (out > nine) {
                    carry.push(out / ten);
                }
            }
            while (!list1.isEmpty()) {
                result = result + list1.reversepop(list1.size) + carry.pop();
                carry.push(0);
            }
            return numberToDigits(result);
        }
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
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result
                = AddLargeNumbers.addLargeNumbers(
                      pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }

}
