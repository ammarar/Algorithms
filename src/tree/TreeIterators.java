package tree;
import java.util.List;



public class TreeIterators 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BST<Integer> theList = new BST<Integer>();
		theList.insert(5);
		theList.insert(6);
		theList.insert(9);
		theList.insert(2);
		theList.insert(1);
		theList.insert(4);
		theList.insert(3);
		theList.printLevels();
//		String ar = theList.serialize();
//		System.out.println(ar);
//		BST<Integer> bst = BST.deserialize(ar);
//		bst.breadthFirstTraversal();
		
//		BST<Integer> sec = new BST<Integer>();
//		sec.insert(2);
//		sec.insert(1);
//		sec.insert(4);
//		
//		System.out.println(theList.isSubtree(sec));
	}
	
}
