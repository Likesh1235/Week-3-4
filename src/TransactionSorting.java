import java.util.*;

class Transaction {
    String id;
    double fee;
    String time;

    Transaction(String id, double fee, String time) {
        this.id = id;
        this.fee = fee;
        this.time = time;
    }
}

public class TransactionSorting {

    static void bubbleSort(ArrayList<Transaction> list) {
        int n = list.size();
        int passes = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Transaction temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }

        System.out.println("Bubble Sort Result:");
        for (Transaction t : list) {
            System.out.println(t.id + " : " + t.fee);
        }
        System.out.println("Passes: " + passes + ", Swaps: " + swaps);
        System.out.println();
    }

    static void insertionSort(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 &&
                    (list.get(j).fee > key.fee ||
                            (list.get(j).fee == key.fee &&
                                    list.get(j).time.compareTo(key.time) > 0))) {

                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }

        System.out.println("Insertion Sort Result:");
        for (Transaction t : list) {
            System.out.println(t.id + " : " + t.fee + " @ " + t.time);
        }
        System.out.println();
    }

    static void findHighFee(ArrayList<Transaction> list) {
        System.out.println("High Fee Outliers (>50):");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.println(t.id + " : " + t.fee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }
    }

    public static void main(String[] args) {

        ArrayList<Transaction> list1 = new ArrayList<>();
        list1.add(new Transaction("id1", 10.5, "10:00"));
        list1.add(new Transaction("id2", 25.0, "09:30"));
        list1.add(new Transaction("id3", 5.0, "10:15"));

        ArrayList<Transaction> list2 = new ArrayList<>(list1);

        bubbleSort(list1);
        insertionSort(list2);
        findHighFee(list2);
    }
}