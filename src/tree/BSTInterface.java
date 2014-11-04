package tree;
/*****************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Homework 5: Building Index using BST
 * 
 * Interface: DO NOT MODIFY THIS!
 * 
 *****************************************************/

public interface BSTInterface<T> {
	/**
	 * Given the value to be searched, tries to find it.
	 * @param toSearch - value to be searched
	 * @return The value of the search result. If nothing found, null.
	 */
	T search(T toSearch);
	
	/**
	 * Inserts a value to the tree.
	 * @param toInsert - a value to be inserted to the tree.
	 */
	void insert(T toInsert);
}
