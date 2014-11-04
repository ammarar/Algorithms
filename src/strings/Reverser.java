package strings;
public class Reverser {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(reverseWords("Hello dude mew".toCharArray()));
	}
	
	public static char[] reverseWords(char[] words)
	{
		for (int i=0; i < words.length/2; i++)
		{
			char c = words[i];
			words[i] = words[words.length - 1 - i];
			words[words.length - 1 - i] = c;
		}
		System.out.println("Reversed: "+new String(words));
		for (int i=0; i<words.length; i++)
		{
			System.out.println("Word begin:" + i);
			int j;
			for (j=i; j < words.length && words[j] != ' ' ; j++)
				;
			System.out.println("Word ends:" + j);
			int wordBegin = i;
			System.out.println(wordBegin + (j-wordBegin)/2);
			int wordBackwardIndex = 0;
			for (; i < wordBegin + (j-wordBegin)/2 ; i++)
			{
				char c = words[i];
				System.out.println("Changing: " + c + " at " + i + " " + 
						words[j - 1 - wordBackwardIndex] + " at " + (j - 1 - wordBackwardIndex));
				words[i] = words[j - 1 - wordBackwardIndex];
				words[j - 1 - wordBackwardIndex] = c;
				wordBackwardIndex++;
			}
			i = j;
			System.out.println(new String(words));
		}
		return words;
	}
	
	public static String removeDuplicateSpace(String str)
	{
		StringBuilder b = new StringBuilder();
		boolean dup = false;
		for (int i = 0; i < str.length(); i++)
		{
			if (dup && str.charAt(i) == ' ')
				continue;
			else if (!dup && str.charAt(i) == ' ')
			{
				dup = true;
				b.append(str.charAt(i));
			} else
			{
				dup = false;
				b.append(str.charAt(i));
			}
		}
		return b.toString();
	}
}
