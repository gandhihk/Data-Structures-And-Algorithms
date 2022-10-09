package ds.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = binarySearchIterative(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
        result = binarySearchRecursive(arr, 0, arr.length-1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
	}
	
	static int binarySearchIterative(int[] arr, int x) {
		int l=0, h=arr.length-1,mid;
		while(l<=h) {
			mid = l+(h-l)/2;
			if(arr[mid]==x)
				return mid;
			else if(arr[mid]<x)
				l = mid+1;
			else
				h=mid-1;
		}
		return -1;
	}
	
	static int binarySearchRecursive(int[] arr, int l, int h, int x) {
		if(l>h)
			return -1;
		int mid=l+(h-l)/2;
		if(arr[mid]==x)
			return mid;
		else if(arr[mid]<x)
			return binarySearchRecursive(arr, mid+1, h, x);
		else
			return binarySearchRecursive(arr, 0, mid-1, x);
	}

}
