package strings;
import java.util.HashSet;
import java.util.Set;


public class MaximumNonDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(maximumNonDuplicateSubstring("abcdax"));
	}

	public static String maximumNonDuplicateSubstring(String str)
	{
		Set<Character> encountered = new HashSet<Character>();
		int i = 0, 
				firstCharacterIndex = 0, 
				count = 0, 
				largestCharacterIndex = 0,
				largestCount = -1;
		while (i <= str.length())
		{
			if (i == str.length())
			{
				System.out.println("Yes");
				if (count > largestCount)
				{
					largestCount = count;
					largestCharacterIndex = firstCharacterIndex;
				}
				break;
			}
			System.out.print(i);
			if (encountered.contains(str.charAt(i)))
			{
				System.out.println();
				System.out.println(encountered.contains(str.charAt(i)) + " " + encountered);
				if (count > largestCount)
				{
					largestCount = count;
					largestCharacterIndex = firstCharacterIndex;
				}
				encountered.clear();
				encountered.add(str.charAt(i));
				if (i + 1 == str.length())
				{
					
				}
				System.out.println("First chr: " + firstCharacterIndex);
				i = firstCharacterIndex;
				firstCharacterIndex += 1;
			}
			else
			{
				encountered.add(str.charAt(i));
				count++;
			}
			i++;
		}
		System.out.println(largestCount);
		return str.substring(largestCharacterIndex, largestCharacterIndex + largestCount);
	}
}
