package array;

import java.util.BitSet;

public class UniqueCharacters
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(isUnique("HelLoo"));
	}
	
	public static boolean isUnique(String s)
	{
		BitSet bits = new BitSet(256);
		for(char c:s.toCharArray())
		{
			if(bits.get(c))
				return false;
			else
				bits.set(c, true);
		}
		return true;
	}

}
