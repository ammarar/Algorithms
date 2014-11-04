package strings;

import java.util.LinkedList;
import java.util.List;

public class LongestPalindromicSubstring
{
	public static void main(String[] args)
	{

	}

	public static String longestPalindromicSubstring(String s)
	{
		if (s.length() == 0)
			return "";
		String longest = s.substring(0, 1);
		for(int i=0; i < s.length()-1; i++)
		{
			String p1 = expandAroundCenter(i, i, s);
			if (p1.length() > longest.length())
				longest = p1;

			String p2 = expandAroundCenter(i, i+1, s);
			if (p2.length() > longest.length())
				longest = p2;
		}
		return null;
	}

	public static String expandAroundCenter(int l, int r, String s)
	{
		while(l >= 0 && r <= s.length()-1 && s.charAt(l) == s.charAt(r))
		{
			l++;
			r++;
		}
		return s.substring(l+1, r-l-1);
	}
}
