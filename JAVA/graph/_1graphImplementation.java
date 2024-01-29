import java.util.*;
public class _1graphImplementation{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of vetices");
        int n=sc.nextInt();
        System.out.println("Enter the no of edges");
        int e=sc.nextInt();

        int adjMatrix[][]=new int[n][n];

        for(int i=0;i<e;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            adjMatrix[v1][v2]=1;
            adjMatrix[v2][v1]=1;
        }


        dftraversal(adjMatrix);
    }

    public static void dftraversal(int adjMatrix[][]) {
        boolean visted[]=new boolean[adjMatrix.length];
        dftraversal(adjMatrix,0,visted);
    }
    public static void dftraversal(int adjMatrix[][],int currentVertex,boolean visted[]){
        System.out.print(currentVertex+" ");
        visted[currentVertex]=true;
        for(int i=0;i<adjMatrix.length;i++){   //next vertex to be visited  is to be false visted[i]==false
            if(adjMatrix[currentVertex][i]==1&&visted[i]==false){
                //i is neighbour of current vertex
                dftraversal(adjMatrix,i,visted);
            }
        }
    }
}