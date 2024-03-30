package ds.heaps;

public class ImplementAHeapWithArray {
    static int heapSize;
    public static void main(String[] args)
    {
        int[] arr = new int[1000];
        arr[0] = 3;
        arr[1] = 10;
        arr[2] = 12;
        arr[3] = 8;
        arr[4] = 2;
        arr[5] = 14;
        int N = 6;

        buildHeap(arr, N);
        printHeap(arr);

        System.out.println("Deleting ");
        delete(arr, 2);
        printHeap(arr);

        System.out.println("Inserting");
        insert(arr, 15);
        insert(arr, 5);
        printHeap(arr);
    }

    public static void buildHeap(int[] arr, int N){
        heapSize = N;
        //for all non-leaf nodes, starting with last non-leaf nodes, call heapify
        for(int i=(N/2-1); i>=0; i--)
            heapify(arr, i);            //heapifies the subtree of this ith node by checking its child nodes
    }

    static void insert(int[] arr, int key){
        int newEleIndex = heapSize;         //insert new node at the last
        arr[newEleIndex] = key;
        heapSize++;
        heapifyParent(arr, newEleIndex);        //call heapify which checks its parent nodes
    }

    static void delete(int[] arr, int deleteIndex){
        swap(heapSize-1, deleteIndex, arr);     //swap the element to be deleted with the last node
        heapSize--;             //delete last node
        heapify(arr, deleteIndex);               //heapifies the subtree of replaced node
    }

    static void heapifyParent(int[] arr, int child){
        //get the parent node and check if parent<this child
        while(child!=0 && arr[parent(child)]<arr[child]){
            swap(parent(child), child, arr);        //if yes, then swap parent with this child
            child = parent(child);              //set child as parent to keep checking upwards
        }
    }

    static void heapify(int[] arr, int i){
        //get the child nodes
        int left = 2*i + 1;
        int right = 2*i + 2;

        int max = i;                    //create a max var
        if(left<heapSize && arr[left]>arr[i])       //if left child is greater, set max as left
            max = left;
        if(right<heapSize && arr[right]>arr[max])       //else if right child is greater, set max as right
            max = right;

        if(max!=i){
            swap(i, max, arr);          //swap the greater child with parent
            heapify(arr, max);          //call heapify for that greater child node
        }
    }

    static int parent(int child){
        return (child-1)/2;
    }

    static void printHeap(int[] arr){
        System.out.println(
                "Array representation of Heap is:");

        for (int i = 0; i < heapSize; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
