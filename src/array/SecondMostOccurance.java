package array;

import java.util.Arrays;

public class SecondMostOccurance
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(secondMostOccured(new int[]{3,5,4,4,3,4}));
	}
	
	public static int secondMostOccured(int[] array)
	{
	    if (array == null)
	        throw new IllegalArgumentException("Not a valid array.");
	    Arrays.sort(array);
	    int count = 0;
	    int maxCount = 0;
	    int mostOccurred = array[0];
	    int secondMostOccured = array[0];
	    int current = array[0];
	    boolean change = true;
	    for (int e : array)
	    {
	        if (e == current)
	        {
	            count++;
	            if (count > maxCount)
	            {
	                maxCount = count;
	                if (change)
	                {
	                    secondMostOccured = mostOccurred;
	                    change = false;
	                }
	                mostOccurred = current;
	            }
	        }
	        else
	        {
	            count = 1;
	            current = e;
	            change = true;
	        }
	    }
	    return secondMostOccured;
	}

}
