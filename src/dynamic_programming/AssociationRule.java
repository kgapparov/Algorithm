package dynamic_programming;

import java.util.*;

enum Items {

    BARLEY(0),
    CORN(1),
    GRAM(2),
    MILLET(3),
    RICE(4),
    WHEAT(5),
    UKNOWN(1000);

    private int item;

    Items(int id) {
        this.item = id;
    }
    public int getItem() {
        return this.item;
    }

    public static Items fromString (String input) {

        return switch (input.toLowerCase()) {
            case "barley" -> Items.BARLEY;
            case "corn" -> Items.CORN;
            case "gram" -> Items.GRAM;
            case "millet" -> Items.MILLET;
            case "rice" -> Items.RICE;
            case "wheat" -> Items.WHEAT;
            default -> Items.UKNOWN;
        };
    }

    public static Items fromInt(Integer input) {

        return switch (input) {
            case 0 -> Items.BARLEY;
            case 1 -> Items.CORN;
            case 2 -> Items.GRAM;
            case 3 -> Items.MILLET;
            case 4 -> Items.RICE;
            case 5 -> Items.WHEAT;
            default -> Items.UKNOWN;
        };
    }
}
public class AssociationRule{

    public AssociationRule() {
        transactions = new HashMap<>();
    }

    private Map<Integer, Integer[]> transactions;

    private int size = 0;

    private Double support;
    private Double confidence;

    void addTransaction(int transactionId, Items item) {
        if (transactions.containsKey(transactionId)) {
            transactions.get(transactionId)[item.getItem()]++;
        } else {
            Integer[] transaction = new Integer[6];
            transaction[item.getItem()]++;
            transactions.put(transactionId, transaction);
            size++;
        }
    }

    void addTransaction(Integer[] transaction) {
        transactions.put(++size, transaction);
    }

    void addTransaction(Items item) {
        transactions.get(size)[item.getItem()]++;
    }

    void printTransactions() {
        transactions.forEach((key, value) -> System.out.println(Arrays.toString(value)));
    }
    public int getItemsFreq(Items... items) {
        int result = 0;
       for (Map.Entry<Integer, Integer[]> entry : transactions.entrySet()) {
           boolean isAbsent = false;
           for (Items item : items) {
               if (entry.getValue()[item.getItem()] == 0) {
                   isAbsent = true;
               }
           }

           if (!isAbsent) {
               result++;
           }
       }
       return result;
    }

    public void setSupport(Double support) {
        this.support = support;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Double getSupport() {
        return support;
    }

    public Double getConfidence() {
        return confidence;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        List<Integer[]> transactions = List.of(
                new Integer[]{1, 1, 1, 1, 1, 1},
                new Integer[]{0, 1, 0, 1, 1, 1},
                new Integer[]{1, 0, 1, 0, 1, 1},
                new Integer[]{0, 1, 1, 0, 1, 1},
                new Integer[]{1, 0, 1, 1, 1, 0},
                new Integer[]{0, 0, 1, 0, 1, 1},
                new Integer[]{1, 0, 0, 1, 1, 1},
                new Integer[]{0, 0, 0, 1, 1, 1},
                new Integer[]{1, 1, 1, 1, 0, 0},
                new Integer[]{1, 1, 1, 1, 0, 0},
                new Integer[]{0, 1, 0, 1, 1, 1},
                new Integer[]{1, 1, 0, 1, 1, 1}
        );

        AssociationRule rule = new AssociationRule();

        for (Integer[] transaction : transactions)
        {
            rule.addTransaction(transaction);
        }

        rule.setConfidence(0.66);
        rule.setSupport(0.33);

        List<Items> firstIteration = new ArrayList<>();

        Items[] items = new Items[6];
        for (int i = 0; i < 6 ; i++) {
            items[i] = Items.fromInt(i);
        }

        for (Items item : items) {
            System.out.println(item.name() +" "+ rule.getItemsFreq(item)  + " "+(rule.getItemsFreq(item)/(double)rule.getSize() > rule.getSupport()));
        }
        for (Items x : items) {
            for (Items y : items) {
                System.out.println(x.name() +" and " + y.name()+" "+ rule.getItemsFreq(x, y)  + " "+(rule.getItemsFreq(x, y)/(double)rule.getSize() > rule.getSupport() && rule.getItemsFreq(x, y) / (double)rule.getItemsFreq(x) >= rule.getConfidence()));
            }
        }

    }

}
