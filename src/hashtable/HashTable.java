package hashtable;

/*********************************************************
 * 
 * 08-722 Data Structures for Application Programmers 
 * Homework 4 HashTable Implementation
 * 
 * Name : Ammar Alrashed
 * Andrew ID: aalrashe
 * 
 *********************************************************/

/**
 * @author Ammar
 *
 */
public class HashTable implements HashtableInterface 
{
	/**
	 * Holds the default capacity of the array when it is not specified.
	 */
	private final int DEFAULT_CAPACITY = 10;
	
	/**
	 * The hash factor used for the hash function.
	 */
	private final int HASH_FACTOR = 27;
	
	/**
	 * The load factor to be maintained in this hash table.
	 */
	private final double LOAD_FACTOR = 0.5;
	
	/**
	 * The array size of the hash table.
	 */
	private int arraySize;
	
	/**
	 * The hash array that holds the data items.
	 */
	private DataItem[] hashArray;
	
	/**
	 * The collision counter to keep track of the number of collisions.
	 */
	private int collisionCounter = 0;
	
	/**
	 * The number of elements of the hash table.
	 */
	private int numOfElements = 0;
	
	/**
   	 * Default constructor
     * @return A new object.
     */
	public HashTable()
	{
		arraySize = DEFAULT_CAPACITY;
		hashArray = new DataItem[arraySize];
	}
	
	/**
   	 * Constructor with a size for initial array size.
     * @param size The size of the initial array.
     * @return A new object.
     */
	public HashTable(int size)
	{
		arraySize = size;
		hashArray = new DataItem[arraySize];
	}
	
	/**
	 * @see HashtableInterface#insert(java.lang.String)
	 */
	@Override
	public void insert(String value) 
	{
		// Keeps track if the value has a collision.
		boolean collisioned = false;
		
		// Gets rid of the values that are not words.
		if (value == null || !value.matches("^[a-zA-Z]+$"))
			return;
		int hashVal = hashFunc(value);
		
		// Iterate over the items until an opening is found (null) or if a same value already exists.
		while (hashArray[hashVal] != null && !hashArray[hashVal].getValue().equals(value))
		{
			// If it is the first time, then check if the current item has the same hash value as the new one.
			if (!collisioned && hashFunc(hashArray[hashVal].getValue()) == hashVal)
			{
				collisioned = true;
			}
			hashVal++;
			hashVal %= arraySize;
		}
		
		// If the item is a new item, then put it in place and increase the number of elements.
		if (hashArray[hashVal] == null)
		{
			hashArray[hashVal] = new DataItem(value.toLowerCase(), 1);
			numOfElements++;
			if (collisioned)
			{
				collisionCounter++;
			}
		}
		// else the item already exists and increase the counter.
		else
		{
			hashArray[hashVal].increaseFrequency();
		}
		
		// If after inserting the value, the load factor threshold is reached, then rehash the hash table.
		if (((double) size()) / arraySize > LOAD_FACTOR)
			rehash();
	}

	
	/**
	 * @see HashtableInterface#size()
	 */
	@Override
	public int size() 
	{
		return numOfElements;
	}

	/**
	 * @see HashtableInterface#display()
	 */
	@Override
	public void display() 
	{
		System.out.print("Table: ");
		for (DataItem item : hashArray)
		{
			if (item != null)
				System.out.print(item + " ");
			else
				System.out.print("** ");
		}
		System.out.println();
	}
	
	/**
	 * Gets the index of the item.
	 * @param key The item to get.
	 * @return int The index in the array.
	 */
	private int get(String key)
	{
		int hashVal = hashFunc(key);
		while (hashArray[hashVal] != null)
		{
			if (hashArray[hashVal].getValue().equals(key))
				return hashVal;
			hashVal++;
			hashVal %= arraySize;
		}
		return -1;
	}

	/**
	 * @see HashtableInterface#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String key) 
	{
		int index = get(key);
		if (index == -1)
			return false;
		return true;
	}

	/**
	 * @see HashtableInterface#numOfCollisions()
	 */
	@Override
	public int numOfCollisions() 
	{
		return collisionCounter;
	}

	/**
	 * @see HashtableInterface#hashValue(java.lang.String)
	 */
	@Override
	public int hashValue(String value) 
	{
		return hashFunc(value);
	}

	/**
	 * @see HashtableInterface#showFrequency(java.lang.String)
	 */
	@Override
	public int showFrequency(String key)
	{
		int index = get(key);
		if (index == -1)
			return 0;
		return hashArray[index].getFrequency();
	}

	/**
	 * @see HashtableInterface#remove(java.lang.String)
	 */
	@Override
	public String remove(String value) 
	{
		int index = get(value);
		if (index == -1)
			return null;
		String temp = hashArray[index].getValue();
		hashArray[index].delete();
		
		// Decrease the number of elements.
		numOfElements--;
		return temp;
	}

	/*
	 * Helper method to hash a string
	 * For English lowercase alphabet and blank, we have 27 total. 
	 * For example, "cats" : 3*27^3 + 1*27^2 + 20*27^1 + 19*27^0 = 60,337
	 * 
	 * But, to make the hash process faster, 
	 * Horner's method should be applied as follows
	 * var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0
	 * can be rewritten as
	 * (((var4*n + var3)*n + var2)*n + var1)*n + var0
	 * 
	 * Note: I would encourage you to try with a prime number, not 27. 
	 * And compare the results but not required.
	 */
	private int hashFunc(String input) 
	{
		if (input == null || !input.matches("^[a-zA-Z]+$"))
			return -1;
		String lowered = input.toLowerCase();
		long hashVal = 0;
		
		// Horner's method
		for(int i = 0; i < lowered.length(); i++)
		{
			hashVal = hashVal * HASH_FACTOR + getCharacterOrder(lowered.charAt(i));
		}
		return (int)(hashVal % arraySize);
	}
	
	/**
	 * Used to get the character order in the alphabet.
	 * @param c The character to get the alphabet order.
	 * @return int The order of the character given.
	 */
	private static int getCharacterOrder(char c)
	{
		return ((int) c) - 96;
	}
	
	/**
	 * Doubles array size and rehash items whenever the load factor is reached.
	 */
	private void rehash() 
	{
		int newArraySize = getPrime(arraySize * 2);
		System.out.println("Rehashing " + size() + " items, new size " + newArraySize);
		DataItem[] oldArray = hashArray;
		arraySize = newArraySize;
		hashArray = new DataItem[newArraySize];
		numOfElements = 0;
		collisionCounter = 0;
		
		// Iterate the items in the old array and insert them in the new hash table.
		for (int i=0; i < oldArray.length; i++)
		{
			// If the item has frequency, then add it.
			if (oldArray[i] != null && !oldArray[i].isDeleted())
				for(int j = 0; j < oldArray[i].getFrequency(); j++)
					insert(oldArray[i].getValue());
		}
	}
	
	/**
	 * Gets the minimum prime number after after min.
	 * @see Data Structures & Algorithms in Java, Robert Lafore.
	 * @param min The given number on which to get the prime number.
	 * @return int The smallest prime number from min.
	 */
	private static int getPrime(int min)
	{
		for (int j = min + 1; true; j++)
			if (isPrime(j))
				return j;
	}
	
	/**
	 * Checks whether the number is prime or not.
	 * @see Data Structures & Algorithms in Java, Robert Lafore.
	 * @param n The number to check if prime or not.
	 * @return boolean True if it is prime, false otherwise.
	 */
	private static boolean isPrime(int n)
	{
		for (int j=2; (j*j <= n); j++)
			if (n % j == 0)
				return false;
		return true;
	}
	
	// private data item class
	/**
	 * A class that contains the data items used for the hash table.
	 * @author Ammar Alrashed
	 */
	private static class DataItem 
	{
		/**
		 * A constant that represents a deleted item.
		 */
		private final String DELETED = "#DEL#";
		
		/**
		 * The value of the data item.
		 */
		private String value;
		
		/**
		 * The frequency of the data item.
		 */
		private int frequency;
		
		/**
		 * Constructor of the data item.
		 * @param val The value to be saved.
		 * @param freq The frequency of the item.
		 */
		public DataItem(String val, int freq) 
		{
			value = val;
			frequency = freq;
		}

		/**
		 * The value getter.
		 * @return String value.
		 */
		public String getValue()
		{
			return value;
		}
		
		/**
		 * The frequency getter.
		 * @return int frequency.
		 */
		public int getFrequency()
		{
			return frequency;
		}

		/**
		 * Checks whether the data item is deleted or not.
		 * @return boolean True if the item is deleted, false otherwise.
		 */
		public boolean isDeleted() 
		{
			return value.equals(DELETED);
		}
		
		/**
		 * Increases the frequency of the item.
		 */
		public void increaseFrequency() 
		{
			frequency++;
		}
		
		/**
		 * Deletes the data item.
		 */
		public void delete()
		{
			value = DELETED;
			frequency = 0;
		}
		
		/**
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString()
		{
			if (isDeleted())
				return DELETED;
			else
				return "[" + value + ", " + frequency + "] ";
		}
	}
	
}