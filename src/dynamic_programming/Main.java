package dynamic_programming;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        // Put all supplies into HashSet.
        Set<String> available = Stream.of(supplies).collect(Collectors.toSet());
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            int nonAvailable = 0;
            for (String ing : ingredients.get(i)) {
                if (!available.contains(ing)) {
                    ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
                    ++nonAvailable;
                }
            }
            if (nonAvailable == 0) {
                ans.add(recipes[i]);
            }else {
                inDegree.put(recipes[i], nonAvailable);
            }
        }
        // Toplogical Sort.
        for (int i = 0; i < ans.size(); ++i) {
            String recipe = ans.get(i);
            if (ingredientToRecipes.containsKey(recipe)) {
                for (String rcp : ingredientToRecipes.remove(recipe)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var words = List.of("Foo", "Bar", "Foo", "Buzz", "Foo", "Buzz", "Fizz", "Fizz");

        Map<Integer, List<String>> map = new ConcurrentHashMap<>();

        words.forEach(x -> map.getOrDefault(x.length(), new ArrayList<>()));
        System.out.println(map);
//        words.forEach( w -> {
//            map.putIfAbsent(w, 0);
//            map.put(w, map.get(w) + 1);
//        });
//
//        words.forEach(w -> {
//            map.putIfAbsent(w, 0);
//            map.computeIfPresent(w, (x, prev) -> prev + 1);
//        });

//        words.forEach(w -> {
//            map.compute(w, (x, pre) -> pre == null ? 1 : pre + 1);
//        });
//        words.forEach(w -> map.merge(w, 1, Integer::sum));
//
//        Set<String> set = new HashSet<>();
//
//        Arrays.stream(words.toArray(new String[0])).forEach(w -> map.merge(w, 1, Integer::sum));
//        System.out.println(map);
    }
}
