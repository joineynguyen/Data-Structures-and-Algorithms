//By: Joiney Nguyen
//Description: Place nodes in linked list with values lower than X node on the left of X node and nodes with values bigger or equal to X node to the right of the node X.

public class LinkedList
{
	Node head;
	Node tail;

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
			list.tail = new_node;
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
			list.tail = new_node;
			new_node.next = null;
		}
	}



	//place data smaller or bigger/equal to n in respect of lists then merge the two list.
	public static void partitionList(LinkedList list, int n)
	{
		LinkedList smallerList = new LinkedList();
		LinkedList biggerList = new LinkedList();

		Node currentNode;

		if(list.head == null)
		{
			return;
		}
		else
		{
			currentNode = list.head;

			while(currentNode != null)
			{

				if(currentNode.data < n)
				{
					append(smallerList, currentNode.data);
				}
				else if(currentNode.data >= n)
				{
					append(biggerList, currentNode.data);
				}

				currentNode = currentNode.next;
			}

			smallerList.tail.next = biggerList.head;

			list.head = smallerList.head;



		}


		
		
	}

	public static void print(LinkedList list)
	{
		Node currentNode;

		if(list.head == null)
		{
			return;
		}
		else
		{
			currentNode = list.head;

			while(currentNode != null)
			{
				System.out.print(currentNode.data + " -> ");

				currentNode = currentNode.next;
			}
		}
	}


	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();

		append(list,3);
		append(list,5);
		append(list,8);
		append(list,5);
		append(list,10);
		append(list,2);
		append(list,1);
	

		print(list);

		System.out.println();

		partitionList(list,5);

		print(list);


	}


}