package array;

public class StockExchange {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(largestDifference(new int[]{6, 9, 5, 7}));
	}
	
	public static int largestDifference(int[] prices)
	{
		int lowest = prices[0];
		int largestDifference = -1;
		for(int i=1; i<prices.length; i++)
		{
			if (largestDifference < (prices[i] - lowest))
				largestDifference = prices[i] - lowest;
			if(prices[i] < lowest)
				lowest = prices[i];
		}
		return largestDifference;
	}
}
