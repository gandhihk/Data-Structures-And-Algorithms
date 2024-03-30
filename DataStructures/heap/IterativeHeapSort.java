package ds.heaps;

public class IterativeHeapSort {
    public static void main(String[] args)
    {
        int[] arr = {10, 20, 15, 17, 9, 21};
        int n = arr.length;

        System.out.print("Given heap: ");
        ImplementAHeapWithArray.buildHeap(arr, arr.length);
        printArray(arr);

        heapSort(arr, n);

        System.out.print("Sorted array: ");
        printArray(arr);
    }

    static void heapSort(int[] arr, int N){
        // One by one extract an element from heap,
        // and keep reducing the size of heap so that all rest of elements of array are not considered for sorting
        for(int i=N-1; i>0; i--){
            swap(arr, 0, i);            //move top of heap to end of heap

            int curr = 0, left, right;      //curr points to current node that needs to be checked for heap properties
            int max = curr;         //create a max var

            do{
                //get child elements
                left = 2*curr+1;
                right = 2*curr+2;

                if(left<i && arr[left]>arr[curr])           //if left child is greater, set max as left
                    max = left;
                if(right<i && arr[right]>arr[max])          //else if right child is greater, set max as right
                    max = right;

                if(curr!=max)
                    swap(arr, max, curr);           //swap the greater child with parent

                curr = max;         //go to the greater child to be checked in next loop
            }while(left < i);           //repeat this till child is within heap limits
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr)
    {
        int n = arr.length;
        for (int j : arr) System.out.print(j + " ");
        System.out.println();
    }
}
