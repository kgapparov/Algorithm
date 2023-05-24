package chapter2.datastructure.sorting.approaches;

import chapter2.datastructure.sorting.Sort;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.swap;

public class QuickSort<T extends Comparable<? super T>> implements Sort<T> {

    @Override
    public Collection<T> sort(List<T> input, int direction) {
        quickSort(input, 0, input.size() - 1, direction);
        return input;
    }

    private void quickSort(List<T> input, int low, int high, int direction) {
        if (low < high) {
            int ploc = partition(input, low, high, direction);
            quickSort(input, low, ploc-1, direction);
            quickSort(input, ploc + 1, high, direction);
        }
    }
    @Override
    public String getName() {
        return "Quick Sort";
    }

    public int partition(List<T> input, int low, int high, int direction) {
        T pivot = input.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (input.get(j).compareTo(pivot) <= 0) {
                swap(input, ++i, j);
            }
        }
        swap(input, i+1, high);
        return i + 1;
    }

}
