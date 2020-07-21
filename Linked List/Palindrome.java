//By: Joiney Nguyen
//Description: Check if the linked list is a palindrome.

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

	public static boolean isPalindrome(LinkedList list)
	{
		if(list.head != null && list.tail != null)
		{
			Node leftNode = list.head;
			Node rightNode = list.tail;

			while(leftNode != null && rightNode != null)
			{
				if(leftNode.data != rightNode.data)
				{
					return false;
				}

				leftNode = leftNode.next;
				rightNode = rightNode.prev;
			}


		}

		return true;
	}


	public static void print(LinkedList list)
	{
		Node currentNode = list.head;

		while(currentNode != null)
		{
			System.out.print(currentNode.data + " -> ");
		}

		System.out.println();
	}


	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		append(list,1);
		append(list,1);
		append(list,0);
		append(list,1);
		append(list,1);

		System.out.println(isPalindrome(list));

	}



}