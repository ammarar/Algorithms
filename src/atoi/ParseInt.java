package atoi;

public class ParseInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(parse("-0000132000232"));
	}
	
	public static int parse(String s)
	{
		int result = 0;
		int sign = 1;
		int i = 0;
		if (s.charAt(0) == '-')
		{
			sign = -1;
			i = 1;
		}
		else if (s.charAt(0) == '+')
		{
			i = 1;
		}
		for (; i < s.length(); i++)
		{
			char num = s.charAt(i);
			if (num == '0')
				result = result * 10;
			else if (num == '1')
				result = result * 10 + 1;
			else if (num == '2')
				result = result * 10 + 2;
			else if (num == '3')
				result = result * 10 + 3;
			else if (num == '4')
				result = result * 10 + 4;
			else if (num == '5')
				result = result * 10 + 5;
			else if (num == '6')
				result = result * 10 + 6;
			else if (num == '7')
				result = result * 10 + 7;
			else if (num == '8')
				result = result * 10 + 8;
			else if (num == '9')
				result = result * 10 + 9;
		}
		return result * sign;
	}

}
