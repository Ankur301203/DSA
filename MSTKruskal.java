package ankur.graph;

import java.util.*;


public class MSTKruskal {
    List<List<List<Integer>>> adj;
    MSTKruskal(int v){
        adj = new ArrayList<>();
        for(int i=0;i<=v;i++) adj.add(new ArrayList<>());
    }
    public void addEdge(int src, int dest, int wt){
        adj.get(src).add(new ArrayList<>(List.of(dest,wt)));
        adj.get(dest).add(new ArrayList<>(List.of(src,wt)));
    }
    public int kruskal(int V, List<List<List<Integer>>> adj){
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                edges.add(new Edge(i,adj.get(i).get(j).get(0),adj.get(i).get(j).get(1)));
            }
        }

        DSU dsu = new DSU(V);
        edges.sort(Comparator.comparingInt(o -> o.dest));
        int mstWeight = 0;
        List<BFS.Pair> vertices = new ArrayList<>();
        for(Edge edge : edges){
            int wt = edge.wt;
            int u = edge.src;
            int v = edge.dest;
            if(dsu.findParent(u) != dsu.findParent(v)){
                mstWeight += wt;
                vertices.add(new BFS.Pair(u,v));
                dsu.unionBySize(u,v);
            }
        }
        System.out.println("Vertices of mst: ");
        for(BFS.Pair pair : vertices){
            System.out.print(pair.first+" "+ pair.second);
        }
        return mstWeight;
    }
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>(accounts);
        int n = accounts.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String curr = accounts.get(i).get(j);
                for (int k = 0; k < n; k++) {
                    if(k == i){
                        continue;
                    }
                    for (int l = 1; l < accounts.get(k).size(); l++) {
                        if(curr.equals(accounts.get(k).get(l))){

                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int v = sc.nextInt();
//        int e = sc.nextInt();
//        MSTKruskal mstKruskal = new MSTKruskal(v);
//        for (int i = 0; i <e ; i++) {
//            int u = sc.nextInt();
//            int w = sc.nextInt();
//            int wt = sc.nextInt();
//            mstKruskal.addEdge(u,w,wt);
//        }
//        int mstWeight = mstKruskal.kruskal(v,mstKruskal.adj);
//        System.out.println(mstWeight);


    }
}
class Edge{
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
}