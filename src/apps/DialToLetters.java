package apps;

import java.util.*;

public class DialToLetters
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Map<Integer, String> nc = new HashMap<>();
		nc.put(2, "ABC");
		nc.put(3, "DEF");
		nc.put(4, "GHI");
		nc.put(5, "JKL");
		nc.put(6, "MNO");
		nc.put(7, "PQRS");
		nc.put(8, "TUV");
		nc.put(9, "WXYZ");
	}
	
//	public static void printLettersRep(String num, Map<Integer, String> nc)
//	{
//		// Get number representitates
//		List<String> list = new ArrayList<String>();
//		for(char c : num.toCharArray())
//		{
//			list.add(nc.get(Integer.parseInt(String.valueOf(c))));
//		}
//		// Create mod counter
//		List<Integer> mods = new ArrayList<>(list.size());
//		for(int i=0; i<list.size(); i++) mods.set(i, 0);
//		// loop until finished
//		do {
//			
//		} while(incrementMods())
//			// print current mods
//			// increment
//	}

}
