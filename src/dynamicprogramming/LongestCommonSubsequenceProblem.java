package dynamicprogramming;

public class LongestCommonSubsequenceProblem
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(getLongestCommonSubsequence("ABABC", "BABCA"));
	}
	
	public static String getLongestCommonSubsequence(String str1, String str2)
	{
		int[][] sol = new int[str1.length()+1][str2.length()+1];
		int max = -1;
		for(int i = 1; i < str1.length() + 1; i++)
		{
			for(int j = 1; j < str2.length() + 1; j++)
			{
				if(str1.charAt(i-1) == str2.charAt(j-1))
				{
					sol[i][j] = sol[i-1][j-1] + 1;
					if (max < sol[i][j])
						max = sol[i][j];
				}
				else
				{
					sol[i][j] = 0;
				}
			}
		}
		StringBuilder b = new StringBuilder();
		for(int i = str1.length(); i > 0; i--)
		{
			for(int j = str2.length(); j > 0; j--)
			{
				if(max > 0 && sol[i][j] == max)
				{
					b.append(str1.charAt(i - 1));
					max--;
				}
			}
		}
		return b.reverse().toString();
	}
}
