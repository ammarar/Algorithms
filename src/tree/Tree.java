package tree;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Tree<T>
{
	public Node<T> root;
	
	public void printTreeLevels()
	{
		Queue<Node<T>> queue = new LinkedList<>();
		int level = 1;
		queue.offer(root);
		queue.offer(null);
		while (!queue.isEmpty())
		{
			Node<T> node = queue.poll();
			
			if (node == null)
			{
				System.out.println(level++);
				if (queue.isEmpty())
					return;
				queue.offer(null);
			}
			else
			{
				System.out.print(node);
				if(node.children != null)
				for (Node<T> child : node.children)
				{
					queue.offer(child);
				}
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		List<Node<Character>> children = new LinkedList<>();
		List<Node<Character>> children1 = new LinkedList<>();
		List<Node<Character>> children2 = new LinkedList<>();
		children1.add(new Node<Character>('Z'));
		children1.add(new Node<Character>('X'));
		children1.add(new Node<Character>('Y'));
		children2.add(new Node<Character>('U'));
		children2.add(new Node<Character>('I'));
		children2.add(new Node<Character>('P'));
		children.add(new Node<Character>('B', children1));
		children.add(new Node<Character>('C'));
		children.add(new Node<Character>('D'));
		children.add(new Node<Character>('E', children2));
		children.add(new Node<Character>('F'));
		
		Tree<Character> tree = new Tree<>();
		tree.root = new Node<Character>('A', children);
		tree.printTreeLevels();
	}
	
	private static class Node<T> 
	{
		public T data; // The data for the node.
		public List<Node<T>> children;
		
		
		/**
		 * Default constructor.
		 * @param data The data to be constructed with.
		 */
		public Node(T data)
		{
			this.data = data;
		}
		
		/**
		 * Initializes all the instance variables with constructing the object.
		 * @param data The data instance variable.
		 * @param left The left instance variable.
		 * @param right The right instance variable.
		 */
		public Node(T data, List<Node<T>> children)
		{
			this.data = data;
			this.children = children;
		}
		
		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			return data.toString();
		}
	}
}
