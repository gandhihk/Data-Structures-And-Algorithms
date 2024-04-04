package ds.heaps;

public class CheckIfBinaryTreeIsAHeap {
    static class Node{
        int key;
        Node left, right;
        Node(int k){
            this.key = k;
            this.left = this.right = null;
        }
    }

    static int countOfNodes;

    public static void main(String args[])
    {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);

        if (isHeap(root) == true)
            System.out.println(
                    "Given binary tree is a Heap");
        else
            System.out.println(
                    "Given binary tree is not a Heap");
    }

    static boolean isHeap(Node root){
        if(root==null)
            return true;

        countOfNodes = countNodes(root);

        return isComplete(root, 0) && isHeapUtil(root);
    }

    static boolean isComplete(Node root, int currIndex){
        // An empty tree is complete
        if(root==null)
            return true;

        // If index assigned to current node is > number of nodes in tree, then tree is not complete
        if(currIndex >= countOfNodes)
            return false;

        //check for its left and right subtrees by passing their indexes
        return isComplete(root.left, 2*currIndex+1) && isComplete(root.right, 2*currIndex+2);
    }

    static boolean isHeapUtil(Node root){
        // Base case : single node satisfies property
        if(root.left==null && root.right==null)
            return true;

        // if only left child
        if(root.right==null)
            return root.left.key <= root.key;       //then left child should be < this node
        else{
            if(root.key>=root.left.key && root.key>=root.right.key)     //else both children should be < this node
                return isHeapUtil(root.left) && isHeapUtil(root.right);     //recursively check its child subtrees
            else
                return false;
        }
    }

    static int countNodes(Node root){
        if(root==null)
            return 0;
        return countNodes(root.left)+countNodes((root.right))+1;
    }
}
