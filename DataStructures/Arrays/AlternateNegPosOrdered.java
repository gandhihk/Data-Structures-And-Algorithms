import java.util.*;
class AlternateNegPosOrdered {
  /*
    Rearrange given array such that elements at alternate positions are of opposite signs with +ve element at 1st position. Any extra +ve/-ve elements will be placed last. Order should be preserved.
    TC=> O(n^2), SC=> O(1)
    Solution:
      1. Find the wrong pos
      2. Find next correct pos that can be put in above wrong pos, and rotate all elements between them
      3. Repeat 2 and 3
  */
  public static void main(String[] args) {
    int[] arr = {-1,1};
    rearrange(arr);
    System.out.println(Arrays.toString(arr));
  }

  static void rearrange(int[] arr){
    int wrongIndex = -1;
    for(int i=0; i<arr.length; i++){
      if(wrongIndex==-1){    //find next wrong index
        if((arr[i]>=0 && i%2==1) || arr[i]<0 && i%2==0)    //if +ve/-ve elements are not in correct place
          wrongIndex = i;
      }
      else{                  //got the wrong index, now find next correct element and rotate in between elements
        if((arr[wrongIndex]>=0 && arr[i]<0) || arr[wrongIndex]<0 && arr[i]>=0){    //check if current entry can be swapped to wrong pos
          rotateRight(arr, wrongIndex, i);

          if(i-wrongIndex>=2)    //correct element is 2 places ahead, so move ahead
            wrongIndex+=2;
          else
            wrongIndex=-1;
        }
      }
    }
  }

  static void rotateRight(int[] arr, int i, int j){
    int t = arr[j];
    for(int itr=j;itr>i;itr--){
       arr[itr] = arr[itr-1];
    }
    arr[i] = t;
  }
}
