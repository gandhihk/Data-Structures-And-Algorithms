import java.util.*;
class MajorityElement2 {
  /*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    Solution: Boyer-Moore voting algorithm
      Similar to MajorityElement solution, only diff is we have to find elements with frequency >n/3.
      Inuition: There can be atmost 2 such elements. So apply above algo to find 2 such elements
  */
  public static void main(String[] args) {
    int[] arr = {1,2};
    System.out.println(findMajority(arr));
  }

  static List<Integer> findMajority(int[] nums) {
    int count1=0,count2=0,majE1=-1,majE2=-1;
    for(int i : nums){
      if(majE1 == i) count1++;
      else if(majE2 == i) count2++;
      else if(count1 == 0) {
        majE1=i;
        count1=1;
      }
      else if(count2 == 0) {
        majE2=i;
        count2=1;
      }
      else{
        count1--;
        count2--;
      }
    }
    List<Integer> ans = new ArrayList<>();
    count1=0;
    count2=0;
    for(int i : nums){
      if(majE1==i) count1++;
      if(majE2==i) count2++;
    }
    if(count1 > Math.floor(nums.length/3))
      ans.add(majE1);
    if(majE1!=majE2)
        if(count2 > Math.floor(nums.length/3)) ans.add(majE2);
        return ans;
  }
}
