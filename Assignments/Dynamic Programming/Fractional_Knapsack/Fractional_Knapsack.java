import java.util.*;

class Item {
    String name;
    int quantity;
    int value;
    double ratio;

    Item(String name, int quantity, int value) {
        this.name = name;
        this.quantity = quantity;
        this.value = value;
        this.ratio = (double) value / quantity;
    }
}

public class Fractional_Knapsack {

    public static void main(String[] args) {

        Item[] items = {
            new Item("Gold", 10, 600),
            new Item("Silver", 20, 500),
            new Item("Copper", 30, 300)
        };

        int capacity = 35;
        double maxProfit = 0;

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        System.out.println("Items Taken:");

        for (Item item : items) {

            if (capacity == 0)
                break;

            if (item.quantity <= capacity) {
                capacity -= item.quantity;
                maxProfit += item.value;

                System.out.println("Take all " + item.name);
            } else {
                double fraction = (double) capacity / item.quantity;
                maxProfit += item.value * fraction;

                System.out.println("Take " + capacity + " units of " + item.name);
                capacity = 0;
            }
        }

        System.out.println("Maximum Profit = " + maxProfit);
    }
}
