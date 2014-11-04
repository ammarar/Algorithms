package sort;
import java.util.Arrays;


public class Sorts 
{
	public static void main(String[] args) 
	{
		int[] arr = new int[] {5, 4 ,9, 1, 6};
		arr = mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void bubbleSort(int[] data)
	{
		for (int out = data.length-1; out >= 1; out--)
		{
			for (int in = 0; in < out; in++)
			{
				if (data[in] > data[in+1])
				   swap(data, in, in+1);
			}
		}
	}

	public void selectionSort(int[] data)
	{
		int min;
		for (int out = 0; out < data.length; out++)
		{
			min = data[out];
			for (int in = out + 1; in < data.length; in++) 
			{
				if (data[in] < data[min])
				   min = in;
			}
			swap (data, out, min);
		}
	}

	public void insertionSort(int[] data)
	{
		for (int out = 1; out < data.length; out++)
		{
			int temp = data[out];
			int in = out;
	
			while (in > 0 && data[in-1] > temp)
			{
				data[in] = data[in-1];
				in--;
			}
			
			data[in] = temp;
		}
	}

	public static int[] mergeSort(int[] data)
	{
		if (data.length == 1)
		   return data;
	
		int mid = data.length/2;
		
		int[] left = new int[mid];
		System.arraycopy(data, 0, left, 0, mid);
		
		int[] right = new int[data.length - left.length];
		System.arraycopy(data, mid, right, 0, right.length);
	
		left = mergeSort(left);
		right = mergeSort(right);
	
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right)
	{
		int[] combined = new int[left.length + right.length];
		int iLeft = 0, iRight = 0, iCombined = 0;
	
		while (iLeft < left.length && iRight < right.length)
		{
			if (left[iLeft] < right[iRight])
			{
				combined[iCombined++] = left[iLeft++];
			}
			else
				combined[iCombined++] = right[iRight++];
		}
		
		while (iLeft < left.length)
		      combined[iCombined++] = left[iLeft++];
	
		while (iRight < right.length)
		      combined[iCombined++] = right[iRight++];
		return combined;
	}

	public static void quickSort(int[] arr, int left, int right)
	{
		if (left >= right) 
			return;
		int pivot = arr[right];
		int partition = partition(arr, left, right, pivot);
		
		quickSort(arr, left, partition - 1);
		quickSort(arr, partition + 1, right);
	}

	public static int partition(int[] arr, int left, int right, int pivot)
	{
		int leftPointer = left - 1;
		int rightPointer = right;
		
		while (true)
		{
			while(arr[++leftPointer] < pivot);
			while(rightPointer > 0 && arr[--rightPointer] > pivot);
			if (leftPointer >= rightPointer) break;
			else swap(arr, leftPointer, rightPointer);
		}
		swap(arr, leftPointer, right);
		return leftPointer;
	}

	public static void swap(int arr[], int leftPointer, int rightPointer)
	{
		int temp = arr[leftPointer];
		arr[leftPointer] = arr[rightPointer];
		arr[rightPointer] = temp;
	}
	
}
