package exercises.chapter02;


import java.util.*;

import static java.util.Collections.swap;


public class Task01 {

    public static int size;
    public static List<List<Integer>> solve(List<Integer> team) {
        size = team.size();
        devide(team, 0, team.size() - 1);
        return List.of(team.subList(0, team.size() / 2), team.subList(team.size() / 2, team.size()));
    }

    private static void devide(List<Integer> team, int low, int high) {
        if (low < high) {
            int pivot = partition(team, low, high);
            if (pivot < size/2) {
                devide(team, pivot +1, high);
            } else if (pivot > size/2){
                devide(team, low, pivot -1);
            }
        }
    }

    private static int partition(List<Integer> team, int low, int high) {
        Integer pivot = team.get(high);
        int i = low - 1;
        for (int j = low; j < high+1; j++) {
            if (team.get(j).compareTo(pivot) <= 0) {
                swap(team, ++i, j);
            }
        }
//        swap(team, i + 1, high);
        return i;
    }

    public static void main(String[] args) {
        List<Integer> team1 = new ArrayList<>(List.of(20, 25, 10, 8, 7, 3, 30, 21, 23, 9));
        Task01.solve(team1);
        System.out.println(team1);
    }
}
