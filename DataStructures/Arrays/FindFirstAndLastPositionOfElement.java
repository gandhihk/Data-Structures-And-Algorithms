import java.util.*;
class FindFirstAndLastPositionOfElement {
    public static void main(String[] args){
      int[] arr={1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
      int val=2;
      System.out.println(Arrays.toString(searchRange(arr, val)));
    }
  
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length==1){
            if(nums[0]==target){
                res[0]=0; res[1]=0;
                return res;
            }else{
                res[0]=-1; res[1]=-1;
                return res;
            }
        }
        int a1 = lowerIndex(nums, nums.length, target);
        if(a1>=0 && a1<nums.length && nums[a1]==target)
            res[0]=a1;
        else
            res[0]=-1;
        a1 = upperIndex(nums, nums.length, target);
        if(a1>=0 && a1<nums.length && nums[a1]==target)
            res[1]=a1;
        else
            res[1]=-1;
        return res;
    }
    
    static int lowerIndex(int arr[], int n, int x)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
          int mid = (l + h) / 2;
          //check if arr[mid]=x and if mid is the 1st position
          if(arr[mid]==x && (mid==0 || arr[mid-1]<x))
            return mid;
          else if (x>arr[mid])    //x is in right subarray
              l = mid + 1;
          else               //2 conditions are possible: either x<arr[mid] or x==arr[mid] but there are other occurrences of x in left subarray, so check left
              h = mid - 1;
        }
        return l;
    }
     
    static int upperIndex(int arr[], int n, int y)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            //check if arr[mid]==y and if mid is the last position of y
            if(arr[mid]==y && (mid==n-1 || arr[mid+1]>y))
              return mid;
            else if (y<arr[mid])    //y is in left subarray
              h = mid - 1;
            else          //2 conditions are possible:either y>arr[mid] or y==arr[mid] but there are other occurrences of y in right subarray, so check right
              l = mid + 1;
        }
        return h;
    }
}
