import java.util.*;

public class _3BST{
    public static void main(String[] args) {
        //BinaryTreeNode<Integer> root=takeInputLevelWise();
        // 4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1
        //print(root);
        //System.out.println(findNodeBST(root, 7));
        //printBetweenK1K2(root,2,6);

        int arr[]={1,2,3,4,5,6,7};
        BinaryTreeNode<Integer> root=constructTree(arr, 0,arr.length-1);
        print(root);

    }
    //find node in BST
    public static boolean findNodeBST(BinaryTreeNode<Integer> root,int val){
        if(root==null)return false;

        if(root.data==val)return true;
        else if(root.data>val)return findNodeBST(root.left, val);
        else return findNodeBST(root.right, val);
    }

    //Print in range
    public static void printBetweenK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        if(root==null)return;//printBetweenK1K2(root,2,6);

        //in between
        if(root.data>=k1&&root.data<=k2)System.out.print(root.data+" ");
        //4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1
        //root data (4)<(6) k2
        if(root.data<k2)printBetweenK1K2(root.right, k1, k2);
        //root data (4)>(2) k1
        if(root.data>k1)printBetweenK1K2(root.left, k1, k2);
    }

    // take level wise
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

        System.out.println("Enter the Root data");

        int rootData = sc.nextInt();
        if (rootData == -1)
            return null;// base case

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> font = pendingNodes.remove();

            System.out.println("Enter the Left childeren of " + font.data);

            int leftChild = sc.nextInt();
            if (leftChild != -1) {
                font.left = new BinaryTreeNode<>(leftChild);
                pendingNodes.add(font.left);
            }

            System.out.println("Enter the Right childeren of " + font.data);

            int rightChild = sc.nextInt();
            if (rightChild != -1) {
                font.right = new BinaryTreeNode<>(rightChild);
                pendingNodes.add(font.right);
            }
        }

        return root;

    }

    // print
    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;

        String s = root.data + " ";

        if (root.left != null) {
            s += "L:" + root.left.data + ",";
        }
        if (root.right != null) {
            s += "R:" + root.right.data;
        }

        System.out.println(s);

        print(root.left);
        print(root.right);
    }

    //sorted array to BST  
    public static BinaryTreeNode<Integer> constructTree(int arr[],int st,int ed) {
        if(st>ed)return null;
        int mid=(st+ed)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(arr[mid]);

        root.left=constructTree(arr, st, mid-1);
        root.right=constructTree(arr,mid+1,ed);

        return root;
    }                                                                                                            

}
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
    }
}