public class BestTimeToBuyAndSellStock{



	public int maxProfit(int[] prices){
		if(prices == null && prices.length == 0){
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int profit = 0;

		for(int i : prices){
			min = Math.min(i, min);
			profit = Math.max(i - min, profit);
		}

		return profit;
	}

}






























