class MajorityElement {
  /*
    Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
    Solution: Using Boyer-Moore voting algorithm
    Keep a maj_e and count for frequency of maj_e. Traverse array and check following-
    1. If count==0, then consider curr element(arr[i]) as maj_e and set count to 1
    2. else if maj_e==arr[i], then count++
    3. else count-- (maj_e!=arr[i])
    Based on observation that a maj_e will always occur together atleast once since its frequency>n/2.
  */
  public static void main(String[] args) {
    int[] arr = {2,2,1,1,1,2,2};
    int e = findMajority(arr);
    int count=0;
    for(int i=0; i<arr.length; i++)    //check if returned element is truly majority
      if(e==arr[i])
        count++;
    System.out.println(count>=arr.length/2 ? e : -1);
  }

  static int findMajority(int[] arr){
    int count=0, majE=-1;    
    for(int i=0; i<arr.length; i++){
      if(count==0){      //forget about all previous elements, consider curr ele as maj_e and reset count to 1
        majE = arr[i];
        count = 1;
      }else if(majE == arr[i])    //keep incrementing for all occurrences of majE
        count++;
      else     //other elements
        count--;
    }
    return majE;
  }
}
