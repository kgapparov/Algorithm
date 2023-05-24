package chapter2.datastructure.sorting;

import java.util.Collection;
import java.util.List;

public interface Sort<T> {
    Collection<T> sort(List<T> input, int direction);
    String getName();
}
