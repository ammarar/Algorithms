package permutations;

public class Permutation
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		permutation("ABCDE");
	}
	
	public  static void permutation(String str) 
	{ 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) 
	{
		if (str.length() == 0)
			System.out.println(prefix);
		else
		{
			for (int i=0; i<str.length(); i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
		}
	}
}