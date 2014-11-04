package fib;

public class Fibonacci
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));
		
	}
	
	public static long fib(int n)
	{
		int result = 1;
		int f0 = 1;
		int f1 = 1;
		for (int i=2; i<=n; i++)
		{
			result = f0 + f1;
			f0 = f1;
			f1 = result;
		}
		return result;
	}
}
