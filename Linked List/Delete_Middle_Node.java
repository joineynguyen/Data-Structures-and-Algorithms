//By: Joiney Nguyen
//Description: Delete the middle node of the linked list.

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
			new_node.next = null;
			new_node.prev = last;
			list.tail = new_node;
		}
	}

	public static void deleteMiddleNode(LinkedList list)
	{
		Node leftNode;
		Node rightNode;

		if(list.head != null && list.tail != null)
		{
			leftNode = list.head;
			rightNode = list.tail;

			//if head node and tail node doesnt point to each other AND head and tail is not the same node
			if(list.head != list.tail && list.head.next != list.tail)
			{
				

				//while left node and right node not pointing at same node
				while(leftNode.next != rightNode.prev)
				{
					
					leftNode = leftNode.next;
					rightNode = rightNode.prev;

					//if no middle node but left and right node collide in middle
					if(leftNode.next == rightNode)
					{
						leftNode.prev.next = rightNode;
						rightNode.prev = leftNode.prev;
						return;
					}

					
				}

				//delete middle node that left and right node is pointing to
				leftNode.next = rightNode;
				rightNode.prev = leftNode;
			}

			
		}
	}

	public static void print(LinkedList list)
	{
		Node currentNode;

		if(list.head != null)
		{
			currentNode = list.head;

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
		append(list,2);
		append(list,3);
		append(list,4);
		append(list,5);
		append(list,6);
		append(list,7);
		append(list,8);
		append(list,9);
		append(list,10);

		print(list);

		System.out.println();

		deleteMiddleNode(list);

		print(list);
	}
}
