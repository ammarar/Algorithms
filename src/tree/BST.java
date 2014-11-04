package tree;
/*****************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Homework 5: Building Index using BST
 * 
 * Name: Ammar Alrashed
 * Andrew ID: aalrashe
 * 
 *****************************************************/

import java.util.*;

public class BST<T extends Comparable<T>> implements Iterable<T>, BSTInterface<T> 
{
	
	private Node<T> root; //root of the BST tree.
	
	/**
	 * Default constructor.
	 */
	public BST() 
	{
	}
	
	/**
	 * Returns the root data of this tree.
	 * @return root data 
	 */
	public T getRoot() 
	{
		return root.data;
	}
	
	/**
	 * Returns the height of this tree.
	 * @return int value of the height
	 */
	public int getHeight() 
	{
		return getHeight(root) - 1;
	}
	
	/**
	 * @see BST#getHeigh()
	 * @param node The node to be recursively called.
	 */
	private int getHeight(Node<T> node)
	{
		if (node == null)
			return 0;
		int right = getHeight(node.right);
		int left = getHeight(node.left);
		return right >= left ? 1 + right : 1 + left;
	}
	
	/**
	 * Returns the number of ndoes in this tree.
	 * @return int value of the number of nodes.
	 */
	public int getNumberOfNodes() 
	{
		return getNumberOfNodes(root);
	}
	
	/**
	 * @see BST#getNumberOfNodes()
	 * @param node The node to be recursively called.
	 */
	private int getNumberOfNodes(Node<T> node)
	{
		if (node == null)
			return 0;
		return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
	}
	
	/**
	 * Given the value to be searched, tries to find it.
	 * @param toSearch - value to be searched
	 * @return The value of the search result. If nothing found, null.
	 */
	public T search(T toSearch) 
	{
		return search(toSearch, root);
	}
	
	/**
	 * @see BST#search(T)
	 * @param node The node to be recursively called.
	 */
	private T search(T toSearch, Node<T> node)
	{
		if (node == null)
			return null;
		int result = toSearch.compareTo(node.data);
		if (result == 0)
			return node.data;
		else if (result > 0)
			return search(toSearch, node.right);
		else
			return search(toSearch, node.left);
	}
	
	/**
	 * Inserts a value to the tree.
	 * @param toInsert - a value to be inserted to the tree.
	 */
	public void insert(T toInsert) 
	{
		if (root == null)
			root = new Node<T>(toInsert);
		else
			insert(toInsert, root);
	}
	
	/**
	 * @see BST#insert(T)
	 * @param node The node to be recursively called.
	 */
	private void insert(T toInsert, Node<T> node)
	{
		int result = toInsert.compareTo(node.data);
		if (result == 0)
			return;
		else if (result > 0)
		{
			if (node.right == null)
			{
				node.right = new Node<T>(toInsert);
				return;
			}
			else
				insert(toInsert, node.right);
		}
		else
		{
			if (node.left == null)
			{
				node.left = new Node<T>(toInsert);
				return;
			}
			else
				insert(toInsert, node.left);
		}
	}
	
	/**
	 * In-order iterator
	 * @return iterator object
	 */
	@Override
	public Iterator<T> iterator() 
	{
		return new InOrderIterator();
	}
	
	public void preorderTraversal()
	{
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<T> node)
	{
		if (node == null) return;
		System.out.print(node + ", ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	public void inorderTraversal()
	{
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<T> node)
	{
		if (node == null) return;
		inorderTraversal(node.left);
		System.out.print(node + ", ");
		inorderTraversal(node.right);
	}
	
	public void postorderTraversal()
	{
		postorderTraversal(root);
	}
	
	private void postorderTraversal(Node<T> node)
	{
		if (node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node + ", ");
	}
	
	public void preorderIterative()
	{
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(root);
		while (!stack.isEmpty())
		{
			Node<T> n = stack.pop();
			System.out.print(n + ", ");
			if (n.right != null)
				stack.push(n.right);
			if (n.left != null)
				stack.push(n.left);
		}
	}
	
	public void breadthFirstTraversal()
	{
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.offer(root);
		while (!queue.isEmpty())
		{
			Node<T> n = queue.poll();
			System.out.print(n + ", ");
			if (n.left != null)
				queue.offer(n.left);
			if (n.right != null)
				queue.offer(n.right);
		}
	}
	
	public String serialize()
	{
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	
	public static BST<Integer> deserialize(String s)
	{
		StringBuilder sb = new StringBuilder(s);
		BST<Integer> tree = new BST<Integer>();
		Node<Integer> node = new Node<Integer>();
		deserialize(node, sb);
		tree.root = node;
		return tree;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void printLevels()
	{
		Queue queue = new LinkedList();
		queue.offer(0);
		queue.offer(root);
		while (!queue.isEmpty())
		{
			int curLevel = (int) queue.poll();
			Node<T> node = (Node<T>) queue.poll();
			System.out.print(node);
			if ((!queue.isEmpty() && curLevel != (int) queue.peek()) || queue.isEmpty())
				System.out.println();
			if (node.left != null)
			{
				queue.offer(curLevel + 1);
				queue.offer(node.left);
			}
			if (node.right != null)
			{
				queue.offer(curLevel + 1);
				queue.offer(node.right);
			}
			
		}
		
	}
	
	private static Node<Integer> deserialize(Node<Integer> node, StringBuilder sb)
	{
		System.out.println(sb);
		if (sb.length() == 0)
			return null;
		if (sb.charAt(0) == '#')
		{
			sb = sb.deleteCharAt(0);
			return null;
		}
		else
		{
			node.data = Integer.parseInt(sb.substring(0, 1));
			sb = sb.deleteCharAt(0);
			node.left = deserialize(new Node<Integer>(), sb);
			node.right = deserialize(new Node<Integer>(), sb);
			return node;
		}
	}
	
	public void serialize(Node<T> node, StringBuilder sb)
	{
		if (node == null)
		{
			sb.append("#");
			return;
		}
		
		sb.append(node.data);
		serialize(node.left, sb);
		serialize(node.right, sb);
	}
	
	public boolean isSubtree(BST<T> tree)
	{
		Node<T> found = find(tree.root);
		System.out.println(found);
		if (found == null)
			return false;
		return same(found, tree.root);
	}
	
	public boolean same(Node<T> node, Node<T> otherNode)
	{
		if (node == null && otherNode == null)
			return true;
		if (node == null && otherNode != null)
			return false;
		if (node != null && otherNode == null)
			return false;
		if (!node.data.equals(otherNode.data))
			return false;
		return same(node.right, otherNode.right) && same(node.left, otherNode.left);
	}
	
	public Node<T> find(Node<T> node)
	{
		Node<T> curr = root;
		while (node != null)
		{
			int comp = node.data.compareTo(curr.data);
			if (comp == 0)
				return curr;
			else if (comp > 0)
				curr = curr.right;
			else 
				curr = curr.left;
		}
		return curr;
	}
	
	/**
	 * Has the in order iterator of BST.
	 */
	public class InOrderIterator implements Iterator<T> 
	{
		private Stack<Node<T>> stack; //the stack used for getting next node.
		
		/**
		 * Default constructor.
		 */
		public InOrderIterator()
		{
			stack = new Stack<Node<T>>();
			Node<T> current = root;
			while (current != null)
			{
				stack.push(current);
				current = current.left;
			}
		}
		
		/**
		 * @see java.util.Iterator#hasNext()
		 */
		@Override
		public boolean hasNext() 
		{
			return !stack.isEmpty();
		}

		/**
		 * @see java.util.Iterator#next()
		 */
		@Override
		public T next() 
		{
			Node<T> result = stack.pop();
			if (result.right != null)
			{
				Node<T> current = stack.push(result.right).left;
				while (current != null)
				{
					stack.push(current);
					current = current.left;
				}
			}
			return result.data;
		}

		/**
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() 
		{
			// Not to be implemented.
		}
	}
	
	/**
	 * private static inner class for Node
	 */
	private static class Node<T> 
	{
		public T data; // The data for the node.
		private Node<T> left; // The left child.
		private Node<T> right; // The right child.
		
		public Node()
		{
			
		}
		
		/**
		 * Default constructor.
		 * @param data The data to be constructed with.
		 */
		public Node(T data)
		{
			this(data, null, null);
		}
		
		/**
		 * Initializes all the instance variables with constructing the object.
		 * @param data The data instance variable.
		 * @param left The left instance variable.
		 * @param right The right instance variable.
		 */
		public Node(T data, Node<T> left, Node<T> right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			return data.toString();
		}
	}
	
   /***********************************************************
	* For debug purpose:
	* Test your BST with this first to make sure your BST works
	***********************************************************/
	public static void main(String[] args) 
	{
		BST<Integer> b = new BST<Integer>();
		int[] ar = {31, 16, 49, 5, 18, 51, 4, 13, 17, 19, 8};
		System.out.println("begin");
		for(Integer x : ar) b.insert(x);
		
		for(Integer x : b) 
			System.out.print(x+" ");
		
		System.out.println();
		System.out.println(b.search(8));
		System.out.println(b.getHeight());
		System.out.println(b.getNumberOfNodes());
	}

}
