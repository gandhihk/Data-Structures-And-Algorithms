class BestTimeToBuyAndSellAnyNumber{
    public static void main(String args[]){
    	int[] prices = {7,1,5,3,6,4};
    	System.out.println(maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2)
            return 0;
        int sellingDate = 0;
        int buyingDate = 0;
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1])
                sellingDate++;
            else {
                totalProfit += (prices[sellingDate] - prices[buyingDate]);
                sellingDate = buyingDate = i;
            }
        }
        totalProfit += (prices[sellingDate] - prices[buyingDate]);
        return totalProfit;
    }
}
