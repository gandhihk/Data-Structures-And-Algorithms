class MaxProfitBuyAndSellAtMostTwice {
  /*
    Given stock prices throughout the day, find out the maximum profit that a share trader could have made by buying and selling at most twice.
    Solution:
    1) Create an array profit[0..n-1] and initialize all values in it 0.
    2) Traverse price[] from right to left and update profit[i]=Math.max(profit[i + 1], max_price - price[i]) i.e. profit[i] stores maximum profit from 1 transaction in subarray price[i..n-1]
    3) Traverse price[] from left to right and update profit[i]=Math.max(profit[i – 1], profit[i] + (price[i] - min_price)) i.e. profit[i] stores maximum profit from 2 transactions in subarray price[0..i].
    4) Return profit[n-1]
    TC⇒ O(n), SC⇒ O(n)
  */
  public static void main(String[] args) {
    int price[] = { 2, 30, 15, 10, 8, 25, 80 };
    int n = price.length;
    System.out.println("Maximum Profit = "+ maxProfit(price, n));
  }

  static int maxProfit(int price[], int n){
    int profit[] = new int[n];

    //1st iteration from right to get max profits from 1 transaction
    int ma = price[n-1];
    for(int i=n-2; i>=0; i--){
      if(price[i]>ma)
        ma = price[i];
      else{
        profit[i] = Math.max(profit[i+1], ma-price[i]);
      }
    }

    //2nd iteration from left to right to get max profits from 2 transactions
    int mi = price[0];
    for(int i=1; i<n; i++){
      if(price[i]<mi)
        mi = price[i];
      else{
        profit[i] = Math.max(profit[i-1], profit[i]+price[i]-mi);
      }
    }

    return profit[n-1];
  }
}
