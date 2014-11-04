package tree;

import java.util.LinkedList;
import java.util.Queue;

import linkedlist.LinkedListAmmar;

public class BinaryTree
{
	Integer value;
	BinaryTree left;
	BinaryTree right;
	
	public static void main(String[] args)
	{
		LinkedListAmmar<Integer> list = new LinkedListAmmar<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(10);
		BinaryTree bt = toCompleteTree(list);
		System.out.println(bt);
		bt.printLevels();
	}
	
	public static BinaryTree toCompleteTree(LinkedListAmmar<Integer> list)
	{
		BinaryTree head = new BinaryTree();
		BinaryTree node = head;
		Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
		queue.offer(node);
		int count = list.size();
		LinkedListAmmar.Node ll = list.head;
		while(ll != null)
		{
			BinaryTree cur = queue.poll();
			System.out.println("Curr: " + cur);
			cur.value = ll.data;
			count--;
			if (count > queue.size())
			{
				cur.left = new BinaryTree();
				cur.right = new BinaryTree();
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
			ll = ll.next;
		}
		
		return head;
	}
	
	public void print()
	{
		Queue<BinaryTree> q = new LinkedList<>();
		Queue<BinaryTree> next = new LinkedList<>();
		q.offer(this);
		while(!q.isEmpty())
		{
			BinaryTree cur = q.poll();
			System.out.print(cur + " ");
			if (cur != null)
			{
				next.offer(cur.left);
				next.offer(cur.right);
			}
			if(q.isEmpty())
			{
				System.out.println();
				Queue<BinaryTree> temp = q;
				q = next;
				next = temp;
			}
		}
	}
	
	public void printLevels()
	{
		Queue<BinaryTree> q = new LinkedList<>();
		q.offer(this);
		int curLevel = 1;
		int nextLevel = 0;
		while(!q.isEmpty())
		{
			BinaryTree cur = q.poll();
			System.out.print(cur + " ");
			curLevel--;
			if(cur.left != null)
			{
				nextLevel++;
				q.offer(cur.left);
			}
			if(cur.right != null)
			{
				nextLevel++;
				q.offer(cur.right);
			}
			if (curLevel == 0)
			{
				System.out.println();
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}
	}
	
	public String toString()
	{
		return "BT: " + String.valueOf(value);
	}
}
