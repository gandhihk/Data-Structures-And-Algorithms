package ds.Arrays;

public class MergeKSortedArraysWithMergeSort {
    static int N = 4;
    public static void main(String[] args)
    {

        // Change n at the top to change number of elements
        // in an array
        int[][] arr = { { 2, 6, 12, 34 },
                { 1, 9, 20, 1000 },
                { 23, 34, 90, 2000 } };

        int K = arr.length;
        int[] output = new int[N * K];

        // Function call
        mergeKArrays(arr, 0, 2, output);

        System.out.print("Merged array is "
                + "\n");
        printArray(output, N * K);
    }

    static void mergeKArrays(int[][] arr, int start, int end, int[] ans){
        //base case, if its only 1 array then return itself in ans
        if(start==end){
            for(int i=0; i<ans.length; i++)
                ans[i] = arr[start][i];
            return;
        }

        //if there are 2 arrays, then call merge function by passing those 2 arrays and store it in ans array
        if(end-start == 1){
            merge(arr[start], arr[end], N, N, ans);
            return;
        }

        //else get the mid number of arrays
        int mid = (start+end)/2;
        int[] out1 = new int[N*(mid-start+1)];          //size of array after merging all left side arrays
        int[] out2 = new int[N*(end-mid)];              //size of array after merging all right side arrays

        mergeKArrays(arr, start, mid, out1);            //recursive call to divide left group of arrays and merge them into out1
        mergeKArrays(arr, mid+1, end, out2);        //recursive call to divide right group of arrays and merge them into out2

        //call merge function by passing the merged left group and merged right group
        merge(out1, out2, N*(mid-start+1), N*(end-mid), ans);
    }

    static void merge(int[] a, int[] b, int N1, int N2, int[] ans){
        int i=0, j=0, k=0;

        // Traverse both array and add smaller element to ans array
        while(i<N1 && j<N2){
            if(a[i] < b[j])
                ans[k++] = a[i++];
            else
                ans[k++] = b[j++];
        }

        while(i<N1)
            ans[k++] = a[i++];

        while(j<N2)
            ans[k++] = b[j++];
    }

    // A utility function to print array elements
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }
}
