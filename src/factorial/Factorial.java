package factorial;

public class Factorial
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
	}

	public static long factorial(int n)
	{
		long result = 1;
		for (; n > 1; n--)
		{
			result *= n;
		}
		return result;
	}
}
