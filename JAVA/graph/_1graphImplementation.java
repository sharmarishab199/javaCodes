import java.sql.Array;
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


        //bftraversal(adjMatrix);
        //dftraversal(adjMatrix);

        //System.out.println(hasPath(adjMatrix,0, 5));
        System.out.println(isConnected(adjMatrix));
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

    //bfs traversal
    public static void bftraversal(int [][]adjMatrix){
        Queue<Integer> pendingVertices=new LinkedList<>();
        boolean visted[]=new boolean[adjMatrix.length];
        visted[0]=true;//mark source as visited
        pendingVertices.add(0);

        while(!pendingVertices.isEmpty()){
            int currentVertex=pendingVertices.remove();
            System.out.print(currentVertex+" ");

            for(int i=0;i<adjMatrix.length;i++){
                if(adjMatrix[currentVertex][i]==1&&!visted[i]){
                    //i is unvited neighbour of current vertex
                    pendingVertices.add(i);
                    visted[i]=true;
                }
            }
        }
    }


    //has path bfs
    public static ArrayList<Integer> hasPath(int [][]adjMatrix,int sv,int ev){
        Queue<Integer> pendingVertices=new LinkedList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean visted[]=new boolean[adjMatrix.length];
        visted[sv]=true;//mark source as visited
        pendingVertices.add(sv);
        map.put(sv,-1);
        boolean pathFound=false;

        while(!pendingVertices.isEmpty()){
            int currentVertex=pendingVertices.remove();

            for(int i=0;i<adjMatrix.length;i++){
                if(adjMatrix[currentVertex][i]==1&&!visted[i]){
                    //i is unvited neighbour of current vertex
                    pendingVertices.add(i);
                    map.put(i,currentVertex);
                    visted[i]=true;

                    if(i==ev){
                        pathFound=true;
                    }
                }
            }
        }
        if(pathFound){
            ArrayList<Integer> path=new ArrayList<>();
            int currentVertex=ev;
            while(currentVertex!=-1){
                path.add(currentVertex);
                int parent=map.get(currentVertex);
                currentVertex=parent;
            }
            return path;
        }
        else return null;
    }

    //connected or not
    public static boolean isConnected(int [][]adjMatrix){
        boolean visited[]=new boolean[adjMatrix.length];
        dftraversal(adjMatrix, 0, visited);
        for(boolean i:visited){
            if(!i)return i;
        }
        return true;
    }
}

// 5 4
// 0 2
// 0 3
// 2 1
// 3 4


// 6 5
// 0 1
// 0 2
// 0 3
// 1 4 
// 2 5