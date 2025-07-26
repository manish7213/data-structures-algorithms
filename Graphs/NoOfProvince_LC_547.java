package Graphs;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.

 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.

 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly
 * connected, and isConnected[i][j] = 0 otherwise.

 * Return the total number of provinces.

 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2

 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 *
 *
 */
public class NoOfProvince_LC_547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int numberOfProvinces = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numberOfProvinces++;
                dfs(isConnected,visited, i);
            }
        }
        return numberOfProvinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int nodeIndex) {
        visited[nodeIndex] = true;
        for(int i = 0 ; i < isConnected.length ; i++) {
            if(isConnected[nodeIndex][i] == 1 && !visited[i]) {
                dfs(isConnected,visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new NoOfProvince_LC_547().findCircleNum(isConnected));
    }
}
