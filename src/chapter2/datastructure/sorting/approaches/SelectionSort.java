package chapter2.datastructure.sorting.approaches;

import chapter2.datastructure.sorting.Sort;

import java.util.Collection;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public Collection<T> sort(List<T> input, int direction) {
        for (int i = 0; i < input.size() - 1; i++) {
            int minOrMax = i;
            for (int j = i + 1; j < input.size(); j++) {
               if (direction > 0) {
                   if (input.get(j).compareTo(input.get(minOrMax)) > 0) {
                       minOrMax = j;
                   }
               } else {
                   if (input.get(j).compareTo(input.get(i)) < 0) {
                       minOrMax = j;
                   }
               }
            }
            ///.  bif (i != minOrMax)
                swap(input, i, minOrMax);
        }
        return input;
    }

    public void swap(List<T> input, int i, int j) {
        if (i == j) return;

        T temp = input.get(i);
        input.set(i,input.get(j));
        input.set(j, temp);
    }

    @Override
    public String getName() {
        return "Selection Sorting";
    }
}
