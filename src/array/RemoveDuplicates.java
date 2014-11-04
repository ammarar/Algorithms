package array;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int[] arr = new int[]{3, 4, 6, 2, 4, 1, 4, 8, 8, 19, 1};
		System.out.println(Arrays.toString(arr));
		removeDuplicates(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void removeDuplicates(int[] arr)
	{
		Arrays.sort(arr);
		int ele = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			System.out.println(ele + " " + arr[i]);
			if(ele == arr[i])
			{
				System.out.println("Heiohso");
				arr[i] = -1;
			}
			else
				ele = arr[i];
		}
		System.out.println(Arrays.toString(arr));
		ele = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] == -1)
			{
				arr[i] = ele;
			}
			else
				ele = arr[i];
		}
	}
	
	public static String removeDups(String s)
	{
		char[] arr = s.toCharArray();
		if (arr == null) return null;
		if (arr.length < 2) return s;
		int end = 1;
		
		for(int i = 0; i<arr.length; i++)
		{
			int j = 0;
			for(; j<end; j++)
			{
				if(arr[i] == arr[j])
				{
					break;
				}
			}
			if (j==end)
			{
				arr[end] = arr[i];
				end++;
			}
		}
		return new String(arr, 0, end);
	}

}
