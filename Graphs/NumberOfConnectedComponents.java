package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges.
 * The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi.
 * We say two vertices u and v belong to a same component if there is a path from u to v or v to u.
 * Find the number of connected components in the graph.

 * A connected component is a subgraph of a graph in which there exists a path between any two vertices,
 * and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.
 * e.g
 * 1. Input: V=4, edges=[[0,1],[1,2]]
 * <p>
 * Output: 2
 * <p>
 * Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.
 * <p>
 * 2.  Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * <p>
 * The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}.
 * <p>
 * The edge [4, 5] forms another connected component with vertices {4, 5}.
 * <p>
 * Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6} (vertices 6 and any other unconnected vertices).
 */

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
