package chapter2.datastructure.sorting;


import java.util.List;


public class SortRunner<T>  implements Runnable {

    public SortRunner(List<T> input, Sort<T> sorter, int direction) {
        this.input = input;
        this.sorter = sorter;
        this.direction = direction;
    }

    private final Sort<T> sorter;

    private final List<T> input;

    private final int direction;

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        sorter.sort(input, direction);
        long end = System.currentTimeMillis();
        System.out.printf("%s Sorting took %d milliseconds for size of input %s \n", sorter.getName(), end - start, input.size());
    }
}
