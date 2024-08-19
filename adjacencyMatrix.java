package ankur.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adjacencyMatrix {
    private List<List<Integer>> adjList;

    public adjacencyMatrix(int vertices){
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i <= vertices; i++) {
            List<Integer> list = new ArrayList<>();
            adjList.add(list);
        }
    }

    public void addEdge(int source, int destination){
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }
    public List<Integer> getNeighbours(int vertex){
        return adjList.get(vertex);
    }

    public void printGraph(){
        for (int i = 1; i < adjList.size(); i++) {
            List<Integer> currList = adjList.get(i);
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbour : currList) {
                System.out.print(neighbour + " ");
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter no. of vertices: ");
//        int vertices = sc.nextInt();
//        System.out.print("Enter no. of edges: ");
//        int edges = sc.nextInt();
//
//        adjacencyMatrix graph = new adjacencyMatrix(vertices);
//
//        for (int i = 0; i < edges; i++) {
//            int v = sc.nextInt();
//            int w = sc.nextInt();
//            graph.addEdge(v, w);
//        }
//        graph.printGraph();

//        System.out.println(graph.getNeighbours(3));

        int[] arr = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        System.out.println(arr.length);
    }
}
