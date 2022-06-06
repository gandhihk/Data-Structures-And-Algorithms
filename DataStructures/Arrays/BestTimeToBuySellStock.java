class BestTimeToBuySellStock {
  /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Solution:
    1. Keep 2 variables: min(to buy) and max_profit(after selling). At any pos, min=minimum of all left elements. max_profit=max profit after selling at some pos till this pos
    2. Traverse array and check 2 conditions:
      a. if curr_ele<min, set min=curr_ele
      b. if curr_ele-min(found so far)>max_profit, the set max_profit=curr_ele-min
  */
  public static void main(String[] args) {
    int[] arr = {7,1,5,3,6,4};
    System.out.println(findMaxProfit(arr));
  }

  static int findMaxProfit(int[] arr){
    int max_profit = 0;
    int min = Integer.MAX_VALUE;
    for(int i=0; i<arr.length; i++){
      if(min>arr[i])    //check if can buy
        min=arr[i];
      else if(max_profit<arr[i]-min)    //check if can sell
        max_profit=arr[i]-min;
    }
    return max_profit;
  }
}
