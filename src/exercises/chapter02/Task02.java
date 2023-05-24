package exercises.chapter02;

import chapter2.datastructure.sorting.Sort;
import chapter2.datastructure.sorting.approaches.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Take as input a sequence of 2n real numbers. Design an O(nLongn) algorithm that
 * partitions the numbers into n pairs, with the property that the paartitions minimizes the maximum sum of the pairs.
 */
public class Task02 {
    private static  Sort<Integer> sorter = new QuickSort<>();

    public static List<List<Integer>> partition(List<Integer> input) {
        sorter.sort(input, 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.size()/2; i++) {
            result.add(new ArrayList<>(List.of(input.get(i), input.get(input.size()-1-i))));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partition(new ArrayList<>(List.of(1, 9, 5, 3, 10, 7))));
    }

}
