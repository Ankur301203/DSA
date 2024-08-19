package ankur.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSU {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DSU(int n){
        for (int i = 0; i <= n ; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node,ultimateParent);
        return parent.get(node);
    }
    public void unionByRank(int u, int v){
        int ultimateOfU = findParent(u);
        int ultimateOfV = findParent(v);
        if(ultimateOfU == ultimateOfV){
            return;
        }
        if(rank.get(ultimateOfU) > rank.get(ultimateOfV)){
            parent.set(ultimateOfV,ultimateOfU);
        }
        else if(rank.get(ultimateOfV) > rank.get(ultimateOfU)){
            parent.set(ultimateOfU,ultimateOfV);
        }
        else{
            parent.set(ultimateOfV,ultimateOfU);
            int rankU = rank.get(ultimateOfU);
            rank.set(ultimateOfU,rankU + 1);
        }
    }
    public void unionBySize(int u, int v){
        int ultimateOfU = findParent(u);
        int ultimateOfV = findParent(v);
        if(ultimateOfU == ultimateOfV){
            return;
        }
        if(size.get(ultimateOfU) < size.get(ultimateOfV)){
            parent.set(ultimateOfU,ultimateOfV);
            size.set(ultimateOfV, size.get(ultimateOfU)+size.get(ultimateOfV));
        }
        else{
            parent.set(ultimateOfV,ultimateOfU);
            size.set(ultimateOfU, size.get(ultimateOfU)+size.get(ultimateOfV));
        }
    }

    public static void main(String[] args) throws Exception {

        DSU dsu = new DSU(7);
        dsu.unionBySize(1,2);
        dsu.unionBySize(2,3);
        dsu.unionBySize(4,5);
        dsu.unionBySize(6,7);
        dsu.unionBySize(5,6);

        if(dsu.findParent(3) == dsu.findParent(7)){
            System.out.println("Same component");
        }
        else{
            System.out.println("Different component");
        }
        dsu.unionBySize(3,7);
        if(dsu.findParent(3) == dsu.findParent(7)){
            System.out.println("Same component");
        }
        else{
            System.out.println("Different component");
        }
    }
}
