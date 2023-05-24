package exercises.chapter02;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

/***
 *  Assume that we are given as input n pairs of intems, where the first item is a numerical and the second item is one
 *  of three colors(red, blue, yellow). Further assume that array is sorted by the number. Give an O(n) Algorithm to sort
 *  the items by colors such that numbers for identical colors stay sorted.
 */
enum Color{
    RED, BLUE, YELLOW
}

record Entity(Integer number, Color color) {

    public Integer getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "{" +
                +number +
                ", " + color +
                '}';
    }
}

public class Task03 {
    public static List<Entity> sort(List<Entity> input) {
        int start = 0, end = input.size() - 1, index = 0;
        while (index < end) {
            if (input.get(index).getColor().equals(Color.RED)) {
                swap(input, start++, index);
            } else if (input.get(index).getColor().equals(Color.YELLOW)) {
                swap(input, end--, index);
            }
            index++;
        }
        return input;
    }

    public static void main(String[] args) {
        List<Entity> input = new ArrayList<>(List.of(new Entity(1, Color.BLUE), new Entity(2, Color.RED), new Entity(5, Color.RED), new Entity(8, Color.YELLOW), new Entity(9, Color.BLUE) ));
        System.out.println(sort(input));
    }
}
