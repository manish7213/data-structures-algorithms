package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private List<Integer> bfsTraversal(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
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
        BFS bfs = new BFS();
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());


        Graph.addEdge(adjList, 0, 1);
        Graph.addEdge(adjList, 0, 2);
        Graph.addEdge(adjList, 1, 2);
        Graph.addEdge(adjList, 2, 0);
        Graph.addEdge(adjList, 2, 3);
        Graph.addEdge(adjList, 3, 3);

        List<Integer> resultNodes = bfs.bfsTraversal(adjList);
        System.out.println(resultNodes);


    }

}
