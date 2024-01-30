import java.util.*;
public class _2kruskalAlgo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int e=sc.nextInt();

        Edge[] edges=new Edge[e];
        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int weight=sc.nextInt();
            Edge edge=new Edge(v1, v2, weight);
            edges[i]=edge;
        }

        Edge[] mst=kruskalAlgorithm(edges,n);

        System.out.println("v1 "+"v2 "+" weight");
        for(int i=0;i<mst.length;i++){
            if(mst[i].v1<mst[i].v2){
                System.out.println(mst[i].v1+" "+mst[i].v2+" "+mst[i].weight);
            }else{
                System.out.println(mst[i].v2+" "+mst[i].v1+" "+mst[i].weight);
            }
        }
    }

    //kruskal algo
    public static Edge[] kruskalAlgorithm(Edge[] edges,int n) { 
        Arrays.sort(edges);
        Edge mst[]=new Edge[n-1];
        int parent[]=new int[n];
        for(int x=0;x<n;x++)parent[x]=x;

        int count=0,i=0;
        while(count!=n-1){
            Edge currentEdge=edges[i++];
            int v1Parent=findParent(currentEdge.v1,parent);
            int v2Parent=findParent(currentEdge.v2,parent);

            if(v1Parent!=v2Parent){
                //include curr edge
                mst[count]=currentEdge;
                count++;
                parent[v1Parent]=v2Parent;
            }
        }

        return mst;
    }
    //find parent
    private static int findParent(int v,int parent[]){
        // 0 1 2 idx
        // 1 2 2 array
        if(v==parent[v])return v;

        return findParent(parent[v], parent);
    }
}
class Edge implements Comparable<Edge>{
    int v1;
    int v2;
    int weight;
    Edge(int v1,int v2,int weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }
     
    public int compareTo(Edge o){
        return this.weight-o.weight;
    }
}

// 6
// 10
// 0 1 1
// 4 5 2
// 1 3 3 
// 0 3 4
// 0 2 5
// 2 1 6
// 4 3 7
// 4 2 8
// 5 2 9
// 2 3 10

// v1 v2 weight