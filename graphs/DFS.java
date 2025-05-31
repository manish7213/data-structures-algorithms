package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public List<Integer> recursiveDfs(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        List<Integer> dfsResult = new ArrayList<>();
        recursiveDfsHelper(adjList, dfsResult, 0, visited); // starting from node 0
        return dfsResult;
    }

    private void recursiveDfsHelper(List<List<Integer>> adjList, List<Integer> dfsResult, int node, boolean[] visited) {
        visited[node] = true;
        dfsResult.add(node);

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                recursiveDfsHelper(adjList, dfsResult, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {

        DFS dfs = new DFS();
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

        List<Integer> resultNodes = dfs.recursiveDfs(adjList);
        System.out.println(resultNodes);


    }

}
