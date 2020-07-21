//By: Joiney Nguyen
//Description: Return node value of the node that is Nth position from the end.

public class LinkedList
{
	Node head;
	Node tail;

	static class Node
	{
		int data;
		Node next;
		Node prev;

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
			list.tail = new_node;
			new_node.next = null;
			new_node.prev = null;

		}
		else
		{
			Node last = list.head;

			while(last.next != null)
			{
				last = last.next;
			}

			last.next = new_node;
			new_node.prev = last;
			new_node.next = null;
			list.tail = new_node;
		}
	}

	public static Integer returnNthFromLast(LinkedList list, int n)
	{
		Node currentNode;
		
		if(list.tail == null)
		{
			return null;
		}
		else
		{
			currentNode = list.tail;
	
			for(int i = 0; i < n - 1; i++)
			{
				currentNode = currentNode.prev;
			}
		}

		return currentNode.data;
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
		append(list, 2);
		append(list, 3);
		append(list, 4);
		append(list, 5);

		print(list);

		System.out.println();

		int ans = returnNthFromLast(list, 2);

		System.out.println(ans);

		

	}
}


