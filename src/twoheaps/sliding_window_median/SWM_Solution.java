package twoheaps.sliding_window_median;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SWM_Solution {
    public static Double[] median(int[] array, int k) {

        Comparator<Integer> comparator = Comparator.comparingInt(a -> array[a]);

        TreeSet<Integer> minHeap = new TreeSet<>(comparator);
        TreeSet<Integer> maxHeap = new TreeSet<>(comparator.reversed());
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i >= k) {
                minHeap.remove(i -k);
                maxHeap.remove(i - k);
            }
            maxHeap.add(i);
            minHeap.add(maxHeap.pollFirst());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.pollFirst());
            }
            if (i >= k -1) {
                res.add(maxHeap.size() == minHeap.size() ? array[maxHeap.first()] / 2.0 + array[minHeap.first()] : array[maxHeap.first()]);
            }
        }
        return res.toArray(new Double[0]);
    }


    public static List<String> getAllNumbers(int n) {

        return null;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(median(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
