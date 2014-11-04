package array;

public class SpiralPrint
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] materix = new int[][] { {1,2,3,4}, 
										{5,6,7,8}, 
										{9,10,11,12},
										{13,14,15,16}};
		printSpiral(materix);
	}
	
	public static void printSpiral(int[][] materix)
	{
		for(int k=0; k<materix.length/2; k++)
		{
			printRow(materix, k, materix.length - 1 - k, k);
			printCol(materix, k, materix.length - 1 - k, materix.length - 1 - k);
			printRow(materix, materix.length - 1 - k, k, materix.length - 1 - k);
			printCol(materix, materix.length - 1 - k, k, k);
		}
		if(materix.length%2 == 1)
		System.out.println(materix[materix.length / 2][materix.length /2]);
	}


	private static void printRow(int[][] materix, int from, int to, int col)
	{
		if (from < to)
			for(; from < to; from++)
			{
				System.out.println(materix[col][from]);
			}
		else
			for(; from > to; from--)
			{
				System.out.println(materix[col][from]);
			}
	}
	
	private static void printCol(int[][] materix, int from, int to, int row)
	{
		if (from < to)
			for(; from < to; from++)
			{
				System.out.println(materix[from][row]);
			}
		else
			for(; from > to; from--)
			{
				System.out.println(materix[from][row]);
			}
	}
	
}
