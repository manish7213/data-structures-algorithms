package Graphs;


import java.util.*;

public class Graph {


    public static void addEdge(List<List<Integer>> adjList, int source, int destination) {
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

}
