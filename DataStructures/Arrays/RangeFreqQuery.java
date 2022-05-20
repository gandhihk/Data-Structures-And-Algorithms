import java.util.*;
class RangeFreqQuery {
  /*
    Given an array of n non-negative integers. The task is to find frequency of a particular element in the arbitrary range of array[]. There will be many queries.
    Solution:
      1. Create hashmap(element, list of all its positions)
      2. For each query range(l,r,value),
        a. if map not contains value, then return 0
        b. get list of positions for given value from map
        c. get upper_bound(r) and lower_bound(l) from the list
        d. frequency=upper_bound-lower_bound
    TC=> O(logn) for each query, SC=> O(n)
  */
    HashMap<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        List<Integer> list;
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }else{
                map.get(arr[i]).add(i);
            }
        }
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value))
            return 0;
        List<Integer> list = map.get(value);
        int up_bound = recursive_upper_bound(list, 0, list.size()-1, right);
        
        int low_bound = recursive_lower_bound(list, 0, list.size()-1, left);
        return up_bound-low_bound;
    }
    
    static int recursive_lower_bound(List<Integer> array, int low, int high, int key)
    {
        // Base Case
        if (low > high) {
            return low;
        }
 
        // Find the middle index
        int mid = low + (high - low) / 2;
 
        // If key is lesser than or equal to
        // array[mid] , then search
        // in left subarray
        if (key <= array.get(mid)) {
 
            return recursive_lower_bound(array, low, mid - 1, key);
        }
 
        // If key is greater than array[mid],
        // then find in right subarray
        return recursive_lower_bound(array, mid + 1, high, key);
    }
    
    static int recursive_upper_bound(List<Integer> arr, int low, int high, int key)
    {
        // Base Case
        if (low > high || low == arr.size())
            return low;
  
        // Find the value of middle index
        int mid = low + (high - low) / 2;
  
        // If key is greater than or equal
        // to array[mid], then find in
        // right subarray
        if (key >= arr.get(mid)) {
            return recursive_upper_bound(arr, mid + 1, high, key);
        }
  
        // If key is less than array[mid],
        // then find in left subarray
        return recursive_upper_bound(arr, low, mid - 1, key);
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
