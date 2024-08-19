package ankur.graph;

import java.util.*;

public class CycleDetection {
    List<List<Integer>> adjList;
    CycleDetection(int v){
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }
    public void addEdge(int src, int dest, int option){
        adjList.get(src).add(dest);
        if(option == 1){
            adjList.get(dest).add(src);
        }
    }

    public boolean dfs(List<List<Integer>> adjList, int v){
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if(!vis[i]){
                if(dfsRecur(adjList,i,vis,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfsRecur(List<List<Integer>> adjList, int src, boolean[] vis, int parent){
        vis[src] = true;
        for(int u : adjList.get(src)){
            if(!vis[u]){
                if(dfsRecur(adjList,u,vis,src)){
                    return true;
                }
            }
            else if (u != parent){
                System.out.println(adjList.get(src));
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter no. of edges: ");
        int e = sc.nextInt();


        CycleDetection graph = new CycleDetection(v);
        List<List<Integer>> adjList = graph.adjList;
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(u,w,0);
        }
        System.out.println(graph.adjList);
        if(graph.dfs(adjList,v)){
            System.out.println("There is cycle");
        }
        else{
            System.out.println("no cycle in graph");
        }



    }
}

