package array;

public class MatrixTranspose
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[][] materix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate(materix);
		print(materix);
	}

	private static void print(int[][] materix)
	{
		for(int i=0; i<materix.length; i++)
		{
			for(int j=0; j<materix.length; j++)
			{
				System.out.print(materix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix)
	{
		for (int k = 0; k < matrix.length / 2; ++k)
		{
			int first = k;
			int last = matrix.length - k - 1;
			for (int i = first; i < last; i++)
			{
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				
				matrix[last - offset][first] = matrix[last][last - offset];
				
				matrix[last][last - offset] = matrix[i][last];
				
				matrix[i][last] = top;
			}
		}
	}

}
