package graphs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    private List<Integer> dfs(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size() + 1];
        visited[0] = true;
        List<Integer> dfsResult = new ArrayList<>();
        dfsHelper(adjList, dfsResult, 0, visited);
        return dfsResult;
    }

    private void dfsHelper(List<List<Integer>> adjList, List<Integer> dfsResult, int node, boolean[] visited) {
        visited[node] = true;
        dfsResult.add(node);
        for (int n : adjList.get(node)) {
            if (!visited[n]) {
                dfsHelper(adjList, dfsResult, n, visited);
            }
        }
    }

}
