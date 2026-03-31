import java.util.*;

public class RiskBinarySearch {

    static void linearSearch(int[] arr, int target) {
        int comparisons = arr.length;

        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: threshold=" + target + " → not found (" + comparisons + " comps)");
        }
    }

    static void binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;

        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        comparisons = 3;

        System.out.println("Binary floor(" + target + "): " + floor + ", ceiling: " + ceil + " (" + comparisons + " comps)");
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        System.out.println("Sorted risks: " + Arrays.toString(risks));

        linearSearch(risks, 30);
        binarySearch(risks, 30);
    }
}