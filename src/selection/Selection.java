package selection;

public class Selection
{
	public static void main(String[] args)
	{
		int[] arr = new int[] {5, 4 ,9, 1, 6};
		System.out.println(selection(arr, 5));
	}
	
	public static int selection(int[] arr, int k)
	{
		if (k > arr.length)
			return -1;
		return selection(arr, k-1, 0, arr.length-1);
	}

	private static int selection(int[] arr, int k, int left, int right)
	{
		int pivot = arr[right];
		int partition = sort.Sorts.partition(arr, left, right, pivot);
		if (k == partition)
			return arr[k];
		else if (k < partition)
			return selection(arr, k, left, partition - 1);
		else
			return selection(arr, k, partition + 1, right);
	}
}
