package bit;

public class Xoring
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int result = Integer.MIN_VALUE;
		for(int i=Integer.MIN_VALUE + 1; i<Integer.MAX_VALUE; i++)
		{
			result = result ^ i;
		}
		System.out.println(result);
		
		for(int i=Integer.MIN_VALUE; i<4; i++)
		{
			result = result ^ i;
		}
		
		for(int i=5; i<Integer.MAX_VALUE; i++)
		{
			result = result ^ i;
		}
		
		System.out.println(result);
	}

}
