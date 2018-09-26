import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
    }
    /**
     *
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(scan.nextLine());
        }
        int count = 0;
        Arrays.sort(array);
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int sum = array[i] + array[j];
                int check = binarySearch(array, j + 1, size - 1, (0 - sum));
                if (check != -1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    /**
     * { item_description }
     *  @param      arr  The arr
     *  @param     start     The start
     *  @param      end  The end
     *  @param      testvalue  The testvalue
     *   @return        The arguments
     */
    public static int binarySearch(final int[] arr,
                                   final int start,
                                   final int end,
                                   final int testvalue) {
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == testvalue) {
                return mid;
            }
            if (arr[mid] > testvalue) {
                return binarySearch(arr, start, mid - 1, testvalue);
            }
            return binarySearch(arr, mid + 1, end, testvalue);
        }
        return -1;
    }
}