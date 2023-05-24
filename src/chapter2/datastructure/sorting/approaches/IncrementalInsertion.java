package chapter2.datastructure.sorting.approaches;

import chapter2.datastructure.sorting.Sort;

import java.util.Collection;
import java.util.List;

import static java.util.Collections.swap;

public class IncrementalInsertion<T extends Comparable<T>> implements Sort<T> {
    @Override
    public Collection<T> sort(List<T> input, int direction) {

        for (int i = 1; i < input.size(); i++ ) {
            int j = i;
            if (direction > 0) {
                while (j > 0 && input.get(j).compareTo(input.get(j - 1)) > 0) {
                    swap(input, j, j - 1);
                    j--;
                }
            } else {
                while (j > 0 && input.get(j).compareTo(input.get(j - 1)) < 0) {
                    swap(input, j, j - 1);
                    j--;
                }
            }
        }
        return input;
    }

    @Override
    public String getName() {
        return "Incremental Sorting";
    }
}
