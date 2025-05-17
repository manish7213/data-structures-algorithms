package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private static List<Integer> bfs(int v, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size() + 1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> bfsResult = new ArrayList<>();
        queue.add(0);
        visited[0] = true;
        bfsResult.add(0);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int n : adjList.get(node)) {
                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    bfsResult.add(n);
                }
            }
        }

        return bfsResult;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = Graph.getAdjList();
        List<Integer> bfs = bfs(0, adjList);
        Graph.printGraph(adjList);
        System.out.println("BFS Output is : " + bfs);
    }
}
