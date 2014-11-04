package dynamicprogramming;

public class ChessRice
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] materix = new int[][] { {1,2}, 
				{5,6}, 
				{9,10}};
		System.out.println(highestChessPath(materix));
	}
	
	public static int highestChessPath(int[][] chess)
	{
		int[][] solution = new int[chess.length][chess[0].length];
		for(int i=0; i<chess.length; i++)
		{
			for(int j=0; j<chess[0].length; j++)
			{
				int wi1j = 0;
				int wij1 = 0;
				if (i-1 >= 0)
				{
					wi1j = solution[i-1][j];
				}
				if (j-1 >= 0)
				{
					wij1 = solution[i][j-1];
				}
				solution[i][j] = Math.max(wi1j, wij1) + chess[i][j];
			}
		}
		return solution[chess.length-1][chess[0].length-1];
	}

}
