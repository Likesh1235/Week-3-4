import java.util.*;

class Asset {
    String name;
    int returnRate;
    int volatility;

    Asset(String name, int returnRate, int volatility) {
        this.name = name;
        this.returnRate = returnRate;
        this.volatility = volatility;
    }
}

public class PortfolioSorting {

    static void mergeSort(Asset[] arr) {
        Arrays.sort(arr, (a, b) -> a.returnRate - b.returnRate);
    }

    static void quickSort(Asset[] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (b.returnRate != a.returnRate)
                return b.returnRate - a.returnRate;
            return a.volatility - b.volatility;
        });
    }

    public static void main(String[] args) {

        Asset[] assets = {
                new Asset("AAPL", 12, 5),
                new Asset("TSLA", 8, 7),
                new Asset("GOOG", 15, 4)
        };

        Asset[] asc = Arrays.copyOf(assets, assets.length);
        Asset[] desc = Arrays.copyOf(assets, assets.length);

        mergeSort(asc);
        quickSort(desc);

        System.out.print("Input: [");
        for (int i = 0; i < assets.length; i++) {
            System.out.print(assets[i].name + ":" + assets[i].returnRate + "%");
            if (i < assets.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Merge: [");
        for (int i = 0; i < asc.length; i++) {
            System.out.print(asc[i].name + ":" + asc[i].returnRate + "%");
            if (i < asc.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Quick (desc): [");
        for (int i = 0; i < desc.length; i++) {
            System.out.print(desc[i].name + ":" + desc[i].returnRate + "%");
            if (i < desc.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}