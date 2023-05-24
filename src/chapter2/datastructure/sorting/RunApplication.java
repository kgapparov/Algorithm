package chapter2.datastructure.sorting;

import chapter2.datastructure.sorting.approaches.IncrementalInsertion;
import chapter2.datastructure.sorting.approaches.MergeSort;
import chapter2.datastructure.sorting.approaches.QuickSort;
import chapter2.datastructure.sorting.approaches.SelectionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RunApplication<T> {

    private final int size;

    private final int direction;

    private List<T> input;

    public RunApplication(int size, int direction) {
        this.size = size;
        this.direction = direction;
        input = new ArrayList<>();
    }

    public static List<Integer> generateIntegerList(int size, int bound){
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(bound));
        }
        return result;
    }

    public void addToInput(T input) {
        this.input.add(input);
    }


    public static void main(String[] args) {

        Random random = new Random();
        List<Sort<Integer>> algorythms = new ArrayList<>();

        int size = 10000;
        if (args.length >= 1) {
            size = Integer.parseInt(args[0]);
        }

        algorythms.add(new SelectionSort<>());
        algorythms.add(new IncrementalInsertion<>());
        algorythms.add(new MergeSort<>());
        algorythms.add(new QuickSort<>());

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            input.add(random.nextInt(size));
        }

        for (int i = 0; i < algorythms.size(); i++) {
            SortRunner<Integer> application = new SortRunner<Integer>(new ArrayList<>(input), algorythms.get(i), 1);
            Thread thread = new Thread(application);
            thread.start();
        }
    }
}
