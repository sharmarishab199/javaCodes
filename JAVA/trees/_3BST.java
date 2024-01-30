import java.util.*;

public class _3BST{
    public static void main(String[] args) {

        int arr[]={50,30,70,20,40,60,80};

        BinaryTreeNode<Integer> root=null;
        for(int i:arr){
            root=takeInput(root,i);
        }
        // 4 2 6 1 3 5 7 -1 -1 -1 -1 -1 -1 -1 -1
        //print(root);
        //System.out.println(findNodeBST(root, 7));
        //printBetweenK1K2(root,2,6);

        // int arr[]={1,2,3,4,5,6,7};
        // BinaryTreeNode<Integer> root=constructTree(arr, 0,arr.length-1);
        //print(root);
        leftView(root);
        rightView(root);
        //System.out.println(isTarget(root, 15, 0));

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

    // take input
    public static BinaryTreeNode<Integer> takeInput(BinaryTreeNode<Integer> root,int val) {
        if(root==null){
            root=new BinaryTreeNode<>(val);
            return root;
        }

        if(val<root.data){
            root.left=takeInput(root.left, val);
        }else{
            root.right=takeInput(root.right, val);
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

    //left view
    public static void leftView(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");

        leftView(root.left);
    }
    //right view
    public static void rightView(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");

        rightView(root.right);
    }

    //target
    public static boolean isTarget(BinaryTreeNode<Integer> root,int target,int ans){
        if(root==null){
            if(target==ans)return true;
            else return false;
        }

        boolean op1=isTarget(root.left, target, ans+root.data);
        boolean op2=isTarget(root.right, target, ans+root.data);

        return op1||op2;
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