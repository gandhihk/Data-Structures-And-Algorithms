class MinNoOfOpsToMakeArrayPalindrome {
  /*
    Given an array of positive integers. We need to make the given array a ‘Palindrome’. The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means replacing them with their sum. The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.
    Solution:
    Keep 2 pointers at start and end. Traverse array and check below conditions to merge-
    1. If arr[i] == arr[j], then no merge, move ahead
    2. If arr[i] > arr[j], then merge at j(right)
    3. If arr[i] < arr[j], then merge at i(left)
  */
  public static void main(String[] args) {
    int[] arr = {11, 14, 15, 99};
    System.out.println(makePalindrome(arr));
  }

  static int makePalindrome(int[] arr){
    int count=0;

    for(int i=0,j=arr.length-1; i<=j; ){
      if(arr[i]==arr[j]){      //no need to merge as left and right elements are same
        i++; j--;
      }else if(arr[i]>arr[j]){    //merge at j end
        arr[j-1]+=arr[j];    //merge j, j-  1 elements
        j--;    //move right pointer only
        count++;        //update no. of ops
      }else{      //merge at i end
        arr[i+1]+=arr[i];      //merge i, i+1 elements
        i++;          //move left pointer only
        count++;    //update no. of ops
      }
    }
    return count;
  }
}
