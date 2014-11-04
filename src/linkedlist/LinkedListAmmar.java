package linkedlist;
import java.util.*;

public class LinkedListAmmar<T> implements Iterable<T>
{
	public Node head;

	public LinkedListAmmar()
	{
		head = null;
	}
	
	public int size()
	{
		if (head == null)
			return 0;
		int count = 0;
		Node cur = head;
		while (cur != null)
		{
			count++;
			cur = cur.next;
		}
		return count;
	}

	public void insert(Integer dataItem)
	{
		if (head == null)
			head = new Node(dataItem, head);
		else
		{
			Node tmp = head;
			while (tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.next = new Node(dataItem, null);
		}
	}

	/**
	 * Find object that is kth to last node of linkedlist
	 * 
	 * @param k
	 *            kth position from the last. 1 means the last node
	 * @return Object that is located at kth from the last
	 */
	public Integer kthToLast(int k)
	{
		if (k <= 0 || head == null)
			throw new IllegalArgumentException("There is no such element.");
		Node runner = head;
		Node pointer = head;
		int counter = 1;
		for (; runner.next != null && counter < k; counter++)
		{
			runner = runner.next;
		}
		if (counter < k && runner.next == null)
			return null;
		while (runner.next != null)
		{
			runner = runner.next;
			pointer = pointer.next;
		}
		return pointer.data;
	}

	public Node reverse()
	{
		Node curr = head;
		Node previous = null;
		Node next = null;
		while (curr != null)
		{
			next = curr.next;
			curr.next = previous;
			previous = curr;
			curr = next;
		}
		head = previous;
		return head;
	}

	public Node thirdToLast()
	{
		if (head == null)
			throw new IllegalArgumentException();
		Node runner = head;
		Node current = head;
		int count = 0;
		for (; runner != null && count < 3;)
		{
			runner = runner.next;
			count++;
		}

		if (runner == null)
			throw new IllegalArgumentException();

		while (runner != null)
		{
			runner = runner.next;
			current = current.next;
		}
		return current;
	}

	/**
	 * Find object that is kth to last node of linkedlist
	 * 
	 * @param k
	 *            kth position from the last. 1 means the last node
	 * @return Object that is located at kth from the last
	 */
	public Integer kthToLast2(int k)
	{
		if (k <= 0 || head == null)
			throw new IllegalArgumentException("There is no such element.");
		Node last = head;

		// Keep a counter to count the number of elements.
		int counter = 1;

		// Reach until the end
		while (last.next != null)
		{
			last = last.next;
			counter++;
		}
		if (k > counter)
			return null;

		// Get the kth element position relative to the beginning.
		int pos = counter - k;
		Node elementAtK = head;

		// Traverse to the Kth element.
		for (int i = 0; i < pos; i++)
			elementAtK = elementAtK.next;
		return elementAtK.data;
	}
	
	public void sortLL()
	{
		this.head = mergeSort(this.head);
	}
	
	public Node mergeSort(Node node)
	{
		if (node == null)
			return null;
		else if(node.next == null)
			return node;
		System.out.println("Dividing: " + node);
		Node right = divide(node);
		System.out.println("Left: " + node);
		node = mergeSort(node);
		System.out.println("Right: " + right);
		right = mergeSort(right);
		System.out.println("Before merge: " + node + "** " + right);
		node = merge(node, right);
		System.out.println("Merge: " + node);
		return node;
	}
	
	public Node divide(Node node)
	{
		if(node.next == null)
		{
			return null;
		}
		Node right = node;
		right = node;
		Node head = node;
		while(node.next != null && node.next.next != null)
		{
			right = right.next;
			node = node.next.next;
		}
		node = right;
		right = right.next;
		node.next = null;
		node = head;
		return right;
	}
	
	public Node merge(Node left, Node right)
	{
		Node merged = null;
		Node node = null;
		if(left == null)
		{
			merged = right;
			return merged;
		}
		else if (right == null)
		{
			merged = left;
			return merged;
		}
		if(left.data < right.data)
		{
			merged = left;
			node = left;
			left = left.next;
		}
		else
		{
			merged = right;
			node = right;
			right = right.next;
		}
		while (left != null && right != null)
		{
			if(left.data < right.data)
			{
				merged.next = left;
				left = left.next;
			}
			else
			{
				merged.next = right;
				right = right.next;
			}
			merged = merged.next;
		}
		if (left != null)
		{
			merged.next = left;
		}
		if (right != null)
		{
			merged.next = right;
		}
		return node;
	}

	/**
	 * Returns a string representation
	 * 
	 */
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		for (Object x : this)
			result.append(x + " ");

		return result.toString();
	}
	
	public static void main(String[] args)
	{
		LinkedListAmmar<Integer> list = new LinkedListAmmar<>();
		list.insert(4);
		list.insert(3);
		list.insert(1);
		list.insert(5);
		list.insert(2);
		list.insert(10);
		System.out.println(list);
		list.sortLL();
		System.out.println(list);
		
	}

	/*******************************************************
	 * 
	 * The Iterator class
	 * 
	 ********************************************************/
	public Iterator iterator()
	{
		return new LinkedListLabIterator();
	}

	private class LinkedListLabIterator implements Iterator<Integer>
	{
		private Node nextNode;

		public LinkedListLabIterator()
		{
			nextNode = head;
		}

		public boolean hasNext()
		{
			return nextNode != null;
		}

		public Integer next()
		{
			if (!hasNext())
				throw new NoSuchElementException();
			Integer result = nextNode.data;
			nextNode = nextNode.next;
			return result;
		}

		// do not support remove()
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}

	/******************************************************
	 * 
	 * Node (static inner class)
	 * 
	 ******************************************************/
	public static class Node implements Comparator<Node>
	{
		public Integer data;
		public Node next;

		public Node(Integer data, Node next)
		{
			this.data = data;
			this.next = next;
		}

		public Integer getData()
		{
			return data;
		}

		@Override
		public int compare(Node o1, Node o2)
		{
			return o1.data.compareTo(o2.data);
		}
		
		@Override
		public String toString()
		{
			return data + " " + (next == null? "" : next.toString());
		}
	}

}