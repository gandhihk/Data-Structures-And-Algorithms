class UnionAndIntersectionOfSortedArrays {
  /*
    Given two sorted arrays, find their union and intersection.
    Solution: Use merge method of mergeSort
  */
  public static void main(String[] args) {
    int[] arr1 = {1, 2, 4, 5, 6};
    int[] arr2 = {2, 3, 5, 7};
    union(arr1, arr2);
    intersection(arr1, arr2);
  }

  static void union(int[] arr1, int[] arr2){
    int a=0, b=0, m=arr1.length, n=arr2.length;
    while(a<m && b<n){
      if(arr1[a]==arr2[b]){
        System.out.println(arr1[a]);
        a = next_distinct(arr1, a);
        b = next_distinct(arr2, b);
      }else if(arr1[a]<arr2[b]){
        System.out.println(arr1[a++]);
        a = next_distinct(arr1, a);
      }else{
        System.out.println(arr2[b]);
        b = next_distinct(arr2, b);
      }
    }

    while(a<m){
      System.out.println(arr1[a]);
      a = next_distinct(arr1, a);
    }
    while(b<n){
      System.out.println(arr2[b]);
      b = next_distinct(arr2, b);
    }
  }

  static void intersection(int[] arr1, int[] arr2){
    int a=0, b=0, m=arr1.length, n=arr2.length;
    while(a<m && b<n){
      if(arr1[a]==arr2[b]){
        System.out.println(arr1[a]);
        a = next_distinct(arr1, a);
        b = next_distinct(arr2, b);
      }else if(arr1[a]<arr2[b]){
        a = next_distinct(arr1, a);
      }else{
        b = next_distinct(arr2, b);
      }
    }
  }

  static int next_distinct(int[] arr, int i){
    do{
      i++;
    }while(i>=0 && i<arr.length && arr[i-1]==arr[i]);
    return i;
  }
}
