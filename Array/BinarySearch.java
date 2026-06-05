package Array;
import java.util.Arrays;

public class BinarySearch {

    static int findElement(int[] arr, int key) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 2, 1, 3, 2, 3, 4, 5, 8, 1 };
        int key = 2;

        int index = findElement(arr, key);

        if (index != -1) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not Available");
        }
    }

}
