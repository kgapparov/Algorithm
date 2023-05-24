package leetcode.linkedlist.leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
        Map<Integer, List<Integer>> graph;
        boolean[] seen;
        public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
            seen = new boolean[n];

            for (int[] edge : edges) {
                graph.computeIfAbsent(edge[0], s -> new ArrayList<>()).add(edge[1]);
            }
            return dfs(graph, source, destination);
        }

        boolean dfs(Map<Integer, List<Integer>> graph, int source, int destination) {
            if (seen[source]) {
                return false;
            }
            if (!graph.containsKey(source) && source == destination) {
                return true;
            }

            seen[source] = true;

            for (Integer child : graph.get(source)) {
                if (dfs(graph, child, destination)) {
                    return true;
                }
            }
            return false;
        }
}
