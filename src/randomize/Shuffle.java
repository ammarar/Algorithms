package randomize;
import java.util.Arrays;
import java.util.Random;


public class Shuffle {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		shuffle(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void shuffle(int[] arr)
	{
		Random rand = new Random();
		for (int i = 1; i < arr.length; i++)
		{
			int change = rand.nextInt(i + 1);
			swap(arr, i, change);
		}
	}
	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
