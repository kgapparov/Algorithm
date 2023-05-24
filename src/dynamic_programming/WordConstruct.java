package dynamic_programming;

import java.util.*;

public class WordConstruct {

    static boolean canConstruct(String s, String[] words) {
        if (Objects.equals(s, "")) {
            return true;
        }
        for (String word : words) {
            if (s.indexOf(word) == 0) {
                String reminder = s.substring(word.length());
                if (canConstruct(reminder, words)){
                    return true;
                }
            }
        }
        return false;
    }

    static int countConstruct(String s, String[] words) {
        if (Objects.equals(s, "")) {
            return 1;
        }
        int count = 0;
        for (String word : words) {
            if (s.indexOf(word) == 0) {
                String remainder = s.substring(word.length());
                count += countConstruct(remainder, words);
            }
        }
        return count;
    }

    static List<List<String>> allConstruct(String s, String[] words) {
        return new ArrayList<>(allConstructList(s, words));
    }
    static List<LinkedList<String>> allConstructList(String s, String[] words) {
        if (Objects.equals(s, "")){
            List<LinkedList<String>> result =  new ArrayList<>();
            result.add(new LinkedList<>());
            return  result;
        }
        List<LinkedList<String>> result = new ArrayList<>();
        for (String word : words) {
            if (s.indexOf(word) == 0) {
                String remainder = s.substring(word.length());
                List<LinkedList<String>> combination = allConstructList(remainder, words);
                combination.forEach(x -> x.addFirst(word));
                result.addAll(combination);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(canConstruct("perple", new String[]{"perp", "p", "er", "le"}));
        System.out.println(countConstruct("perple", new String[]{"perp", "p", "er", "le"}));
        System.out.println(allConstruct("perple", new String[]{"perp", "p", "er", "le"}));
//
//        LinkedList<String> list = new LinkedList<>();
//        result = String.join(" ", list);
    }
}
