package leetcode.demo.chart;


import java.util.*;

/**
 */
public class ChartDemo {

    /**
     * 广度优先搜索（BFS）
     * @param start
     * @param graph
     */
    public void bfs(int start, Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    /**
     * 深度优先搜索（DFS）
     * @param node
     * @param graph
     * @param visited
     */
    public void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
    visited.add(node);
    System.out.print(node + " ");

    for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
        if (!visited.contains(neighbor)) {
            dfs(neighbor, graph, visited);
        }
    }
}

}
