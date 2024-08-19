package ankur.graph;

import java.util.*;

public class graph {
     final private List<List<Integer>> List;

    public graph(int v){
        this.List = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            List.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        List.get(u).add(v);
        List.get(v).add(u);
    }
    public List<Integer> getNeighbours(int v){
        return List.get(v);
    }

    public void printGraph(){
        for (int i = 0; i < List.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < List.get(i).size(); j++) {
                System.out.print(List.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        graph gp = new graph(vertex);

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            gp.addEdge(u,v);
        }

        gp.printGraph();
    }
}
