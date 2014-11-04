package linkedlist;


public class LLReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedListAmmar<Integer> list = new LinkedListAmmar<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		System.out.println(list.toString());
		list.reverse();
		System.out.println(list.toString());
	}

}
