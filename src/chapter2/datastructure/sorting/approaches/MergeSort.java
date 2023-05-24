package chapter2.datastructure.sorting.approaches;

import chapter2.datastructure.sorting.Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MergeSort<T extends Comparable< ? super T>> implements Sort<T> {

    int direction;
    @Override
    public Collection<T> sort(List<T> input, int direction) {
        this.direction = direction;
        return mergeSort(input);
    }

    @Override
    public String getName() {
        return "MergeSort";
    }

    public List<T> mergeSort(List<T> input) {
        if (input.size() == 1) {
            return new ArrayList<>(input);
        }
        return merge(
                mergeSort(new ArrayList<>(input.subList(0, input.size()/2))),
                mergeSort(new ArrayList<>(input.subList(input.size()/2, input.size())))
        );
    }

    public List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (direction > 0) {
                if (left.get(i).compareTo(right.get(j)) > 0) {
                    result.add(left.get(i++));
                } else {
                    result.add(right.get(j++));
                }
            } else {
                if (left.get(i).compareTo(right.get(j)) < 0) {
                    result.add(left.get(i++));
                } else {
                    result.add(right.get(j++));
                }
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }
}
