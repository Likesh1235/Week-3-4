import java.util.*;

class Trade {
    String id;
    int volume;

    Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }
}

public class TradeVolumeAnalysis {

    static void sortAsc(Trade[] arr) {
        Arrays.sort(arr, (a, b) -> a.volume - b.volume);
    }

    static void sortDesc(Trade[] arr) {
        Arrays.sort(arr, (a, b) -> b.volume - a.volume);
    }

    static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) sum += t.volume;
        return sum;
    }

    public static void main(String[] args) {

        Trade[] trades = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        Trade[] asc = Arrays.copyOf(trades, trades.length);
        Trade[] desc = Arrays.copyOf(trades, trades.length);

        sortAsc(asc);
        sortDesc(desc);

        System.out.print("Input: [");
        for (int i = 0; i < trades.length; i++) {
            System.out.print(trades[i].id + ":" + trades[i].volume);
            if (i < trades.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("MergeSort: [");
        for (int i = 0; i < asc.length; i++) {
            System.out.print(asc[i].id.replace("trade", "") + ":" + asc[i].volume);
            if (i < asc.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("QuickSort (desc): [");
        for (int i = 0; i < desc.length; i++) {
            System.out.print(desc[i].id.replace("trade", "") + ":" + desc[i].volume);
            if (i < desc.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Merged morning+afternoon total: " + totalVolume(asc));
    }
}