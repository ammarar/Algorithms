package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedListRandom
{
	Integer value;
	LinkedListRandom next;
	LinkedListRandom rand;

	public static LinkedListRandom copy(LinkedListRandom ll)
	{
		Map<LinkedListRandom, LinkedListRandom> map = new HashMap<>();
		LinkedListRandom clone = new LinkedListRandom();
		LinkedListRandom cloneHead = clone;
		LinkedListRandom iter = ll;
		while(iter != null)
		{
			map.put(iter, clone);
			clone.value = ll.value;
			if(iter.next != null)
			{
				clone.next = new LinkedListRandom();
				clone = clone.next;
			}
			iter = iter.next;
		}
		
		
		
		return clone;
	}
}
