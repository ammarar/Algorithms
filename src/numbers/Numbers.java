package numbers;

import java.util.HashSet;
import java.util.Set;

public class Numbers
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		System.out.println(rotate(123));
//		System.out.println(reverse(123));
//		System.out.println(rotate(123, 2));
//		System.out.println(rotate(123, -2));
		System.out.println(findTrailingZeros(5*3));
	}

	public static int rotate(int n)
	{
		int numberOfDigits = (int) Math.ceil(Math.log10(n));
		for (int i = 0; i < numberOfDigits/2; i++)
		{
			int temp = n % 10;
			n = n - temp + temp * (int) Math.pow(10, numberOfDigits);
			n /= 10;
		}
		return n;
	}
	
	public static int rotate(int num, int n)
	{
		if (n < 0)
		{
			num = rotateLeft(num, n);
		}
		else if (n > 0)
		{
			num = rotateRight(num, n);
		}
		return num;
	}
	
	private static int rotateRight(int num, int n) 
	{
		int numberOfDigits = (int) Math.ceil(Math.log10(num));
		while (n > 0)
		{
			int factorOff = ((int) Math.pow(10, numberOfDigits - 1));
			int msd = num / factorOff;
			num = (num - msd * factorOff) * 10 + msd;
			n--;
		}
		return num;
	}

	private static int rotateLeft(int num, int n) 
	{
		int numberOfDigits = (int) Math.ceil(Math.log10(num));
		while (n < 0)
		{
			int power = ((int) Math.pow(10, numberOfDigits - 1));
			int lsd = num % 10;
			num = lsd * power + num/10;
			n++;
		}
		return num;
	}

	public static int reverse(int n)
	{
		int reversedNumber = 0;
		while (n > 0)
		{
			int temp = n % 10;
			reversedNumber = reversedNumber * 10 + temp;
			n /= 10;
		}
		return reversedNumber;
	}
	
	public static int reversePalindromic(int n)
	{
		while (!isPalindrome(n))
		{
			n = n + reverse(n);
			System.out.println(n);
		}
		return n;
	}
	
	public static boolean isPalindrome(int n)
	{
		return n == reverse(n);
	}
	
	public static int maximumSubarraySum(int[] arr)
	{
		int maxSoFar = 0, maxEndingHere = 0;
		for (int num: arr)
		{
			maxEndingHere = Math.max(0, maxEndingHere + num);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}
	
	public static boolean happyNumber(int n)
	{
		Set<Integer> set = new HashSet<>();
		while (true)
		{
			System.out.println(n);
			n = sumSquaresOfDigits(n);
			if (n == 1)
				return true;
			if (!set.contains(n))
			{
				set.add(n);
			}
			else
				return false;
		}
	}
	
	public static int sumSquaresOfDigits(int n)
	{
		int result = 0;
		while (n > 0)
		{
			int temp = n % 10;
			result = result + temp*temp;
			n /= 10;
		}
		return result;
	}
	
	public static int squareRoot(int s)
	{
		int xn = 1;
		int error = 10;
		while (error > 0)
		{
			xn = (xn + s/xn)/2;
			error  = error * error / (2 * (1 + error)) * 1000;
			System.out.println(error);
		}
		return xn;
	}
	
	public static int countSetBits(int n)
	{
		int count = 0;
		while (n > 0)
		{
			if ((n & 1) == 1) {
				count++;
			}
			n = n >>> 1;
		}
		return count;
	}
	
	public  static  int  findTrailingZeros(int  number)  
	{

		int count = 0;
		if(number < 0)
		{
			System.out.println("Error: There is no Factorial for a number less than 0");
			return -1; //error condition
		}
		/*
		start from 5, multiply j by 5 each loop, but
		stop iterating when number/j is no longer greater
		than 1
		*/
		for ( int j = 5; number/j > 1; j *= 5 )
		{
			/*
			assuming that number/j will just give you the
			integer result of the division of number/j and
			also truncate:
			*/
			count  +=  number  /  j;
		}
		return count;
	}
}
