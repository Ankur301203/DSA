package ankur.graph;

import java.util.*;

public class TopoSortBFS {
    List<List<Integer>> adj;
    TopoSortBFS(int v){
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    void addEdge(int u, int v){
        adj.get(u).add(v);
    }
    int[] inDegree(List<List<Integer>> adj, int v){
        int[] degrees = new int[v];
        for(List<Integer> list : adj){
            for(int curr : list){
                degrees[curr]++;
            }
        }
        return degrees;
    }
    int[] topoSortBFS(List<List<Integer>> adj, int[] degrees, int v){
        int[] ans = new int[v];
        Queue<Integer> qe = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(degrees[i] == 0){
                qe.add(i);
            }
        }

        int j = 0;
        while(!qe.isEmpty()){
            int node = qe.poll();
            ans[j++] = node;

            for(int curr : adj.get(node)){
                degrees[curr]--;
                if(degrees[curr] == 0){
                    qe.add(curr);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of vertices: ");
        int v = sc.nextInt();

        TopoSortBFS graph = new TopoSortBFS(v);
        System.out.print("Enter no. of edges: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph.addEdge(u,w);
        }
        List<List<Integer>> adj = graph.adj;
        System.out.println(adj);

        int[] degrees = graph.inDegree(adj,v);
        System.out.println(Arrays.toString(degrees));

        System.out.println(Arrays.toString(graph.topoSortBFS(adj, degrees, v)));
    }
}
