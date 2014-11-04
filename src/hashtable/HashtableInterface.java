package hashtable;

/******************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Basic HashTable interface
 * 
 * Do not change anything in this interface
 * 
 ******************************************************/
public interface HashtableInterface {
	
	/**
	 * Inserts a new String value. 
	 * Frequency of a word will be stored too.
	 * @param value String value to be added.
	 */
	void insert(String value);
	
    /**
	 * Returns the size, number of items, of the hashTable 
	 * @return the number of items in the table.
	 */
	int size();

    /**
	 * Displays the values of the table
	 * If an index is empty, it shows **
	 * If previously existed dataitem is deleted, 
	 * then it should show #DEL#
	 */
	void display();

    /**
	 * Returns true if value is contained in the table
	 * @param key String key value to be searched
	 * @return true if found, false if not found.
	 */
	boolean contains(String key);

    /**
	 * Returns the number of collisions. 
	 * When rehashing process happens, 
	 * the collisions value should be properly updated. 
	 * @return number of collisions
	 */
	int numOfCollisions();
	
	/**
	 * Returns the hash value of a String
	 * @param value value for which the hash value should be calculated
	 * @return int hash value of a String. 
	 */
	int hashValue(String value);
	
	/**
	 * Returns the frequency of a key String
	 * @param key key string value to find its frequency
	 * @return frequency value if found. 
	 * If not found, print out not found message
	 */
	int showFrequency(String key);
	
	/**
	 * Removes and returns moved value
	 * @param value String value to be removed
	 * @return value that is removed
	 */
	String remove(String value);

}
