import java.util.*;

public class AccountSearch {

    static int linearSearch(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear Search Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }
        System.out.println("Not Found");
        return -1;
    }

    static void binarySearch(String[] arr, String target) {
        Arrays.sort(arr);
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                int count = 1;

                int i = mid - 1;
                while (i >= 0 && arr[i].equals(target)) {
                    count++; i--;
                }

                i = mid + 1;
                while (i < arr.length && arr[i].equals(target)) {
                    count++; i++;
                }

                System.out.println("Binary Search Found at index: " + mid);
                System.out.println("Count: " + count);
                System.out.println("Comparisons: " + comparisons);
                return;
            }

            if (arr[mid].compareTo(target) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Not Found");
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        System.out.println("Array: " + Arrays.toString(logs));

        linearSearch(logs, "accB");
        binarySearch(logs, "accB");
    }
}