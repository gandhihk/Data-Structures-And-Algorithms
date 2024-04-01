package ds.heaps;

public class KSmallestElementsInArray {
    public static void main(String[] args){
        int[] arr = {56, 34, 7, 9, 0, 48, 41, 8 };

        int size = arr.length;
        int k = 4;

        System.out.println("For the array: " );
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("The " + k + " smallest elements of the array are: " );
        findKSmallestElements(arr, size, k );
    }

    static void findKSmallestElements(int[] arr, int N, int k){
        int[] heap = new int[k];
        int i=0;
        //add first k elements to heap and build maxheap
        for(; i<k; i++)
            heap[i] = arr[i];
        ImplementAHeapWithArray.buildHeap(heap, k);

        //traverse rest of the elements
        for(; i<N; i++){
            if(arr[i] < heap[0]) {          //if curr element is less than the largest, then delete largest and add curr element
                ImplementAHeapWithArray.delete(heap, 0);
                ImplementAHeapWithArray.insert(heap, arr[i]);
            }
        }
        //finally, maxheap will have K smallest elements with largest of them at top
        ImplementAHeapWithArray.printHeap(heap);
    }
}
