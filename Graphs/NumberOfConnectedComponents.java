package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int numberOfComponent = 0;
        boolean[] visited = new boolean[V];
        List<List<Integer>> adjList = convertEdgeListToAdjList(edges, V);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                numberOfComponent++;
                dfs(adjList, visited, i);
            }
        }
        return numberOfComponent;
    }

    /**
     * Converts EdgeList to Adjacency List
     */
    private List<List<Integer>> convertEdgeListToAdjList(List<List<Integer>> edges, int V) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int src = edge.get(0);
            int dest = edge.get(1);

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        return adjList;
    }

    /**
     * dfs logic
     */
    private void dfs(List<List<Integer>> edges, boolean[] visited, int nodeIndex) {
        visited[nodeIndex] = true;
        List<Integer> neighbors = edges.get(nodeIndex);
        for (int n : neighbors) {
            if (!visited[n]) {
                dfs(edges, visited, n);
            }
        }
    }

    public static void main(String[] args) {
        int V1 = 4;
        List<List<Integer>> edges1 = List.of(List.of(0, 1), List.of(1, 2));
        System.out.println(new NumberOfConnectedComponents().findNumberOfComponent(V1, edges1));

        int V2 = 7;
        List<List<Integer>> edges2 = List.of(List.of(0, 1), List.of(1, 2), List.of(2, 3), List.of(4, 5));
        System.out.println(new NumberOfConnectedComponents().findNumberOfComponent(V2, edges2));

    }
}
