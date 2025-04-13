package graphs;


import java.util.*;

public class Graph {

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());


        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 0);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 3);

        printGraph(adjList);
    }


    private static void addEdge(List<List<Integer>> adjList, int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }


    public static void printGraph(List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(" -> " + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getAdjList() {
        int V = 4;
        List<List<Integer>> adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());


        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 0);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 3);
        return adjList;
    }
}
