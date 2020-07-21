//By: Joiney Nguyen
//Description: Remove duplicates in the linked list.

import java.util.*;

public class LinkedList
{

	Node head;

	static class Node
	{
		int data;
		Node next;

		Node(int d)
		{
			data = d;
		}
	}


	public static void append(LinkedList list, int data)
	{
		Node new_node = new Node(data);
		

		if(list.head == null)
		{
			list.head = new_node;
			new_node.next = null;
		}
		else
		{
			Node last = list.head;

			while(last.next != null)
			{
				last = last.next;
			}

			last.next = new_node;
			new_node.next = null;
			
		}

	}

	public static void deleteDuplicate(LinkedList list)
	{
		HashSet<Integer> set = new HashSet<Integer>();

		if(list.head == null)
		{
			return;
		}
		else
		{
			Node currentNode = list.head;
			Node prevNode = null;
			
			while(currentNode != null)
			{
				int currentInt = currentNode.data;	
				
				if(set.contains(currentInt) == true)
				{
					prevNode.next = currentNode.next;
					currentNode = currentNode.next;
				}
				else
				{
					set.add(currentInt);
					prevNode = currentNode;
					currentNode = currentNode.next;
				}

			}
		}
	}

		public static void print(LinkedList list)
		{
			if(list.head == null)
			{
				return;
			}
			else
			{
				Node currentNode = list.head;

				while(currentNode != null)
				{
					System.out.println(currentNode.data);
					
					currentNode = currentNode.next;
				}
			}
		}
	



	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		append(list, 1);
		append(list, 1);
		append(list, 2);
		append(list, 3);
		append(list, 4);
		append(list, 5);
		append(list, 5);
	    
	    print(list);
	    
	    deleteDuplicate(list);
	    
	    System.out.println();
	    print(list);
	}
}