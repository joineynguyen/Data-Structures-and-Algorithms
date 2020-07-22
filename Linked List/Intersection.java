//By: Joiney Nguyen
//Description: Given two separate single linked list, return the node that is the intersection of the two.

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

	public static void printByList(LinkedList list)
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

			System.out.println();
		}
	}

	public static void printByNode(Node currentNode)
	{
		
		if(currentNode != null)
		{

			while(currentNode != null)
			{
				System.out.println(currentNode.data);

				currentNode = currentNode.next;
			}

			System.out.println();
		}
	}



	public static boolean checkTailsSameValue(LinkedList list1, LinkedList list2)
	{

		if(list1.tail != null && list2.tail != null)
		{
			if(list1.tail.data == list2.tail.data)
			{
				
				return true;
			}
		}
        
		return false;

	}

	public static Integer getListLength(LinkedList list)
	{
		Node currentNode;
		int length = 0;

		if(list.head != null)
		{
			currentNode = list.head;

			while(currentNode != null)
			{
				length ++;
				currentNode = currentNode.next;
			}

			return length;
		}
		
		return null;
	}

	public static Node getIntersectingNode(LinkedList list1, LinkedList list2)
	{
		int biggerListSkipCount;
		int list1Length;
		int list2Length;
		Node biggerListCurrentNode;
		Node smallerListCurrentNode;
		Node intersectingNodeStart;
	
		
		if(list1.head != null && list2.head != null)
		{

			if(checkTailsSameValue(list1, list2))
			{
				
				list1Length = getListLength(list1);

				list2Length = getListLength(list2);

				if(list1Length > list2Length)
				{
					biggerListSkipCount = list1Length - list2Length;

					biggerListCurrentNode = list1.head;
					smallerListCurrentNode= list2.head;

					for(int i = 0; i < biggerListSkipCount; i++)
					{
						biggerListCurrentNode = biggerListCurrentNode.next;
					}

					while(biggerListCurrentNode != null && smallerListCurrentNode != null)
					{
						if(biggerListCurrentNode.data == smallerListCurrentNode.data)
						{
							intersectingNodeStart = biggerListCurrentNode;
						
							return intersectingNodeStart;
						}
						biggerListCurrentNode = biggerListCurrentNode.next;
						smallerListCurrentNode = smallerListCurrentNode.next;
					}	

				}
				else if(list2Length > list1Length)
				{
					biggerListSkipCount = list2Length - list1Length;

					biggerListCurrentNode = list2.head;
					smallerListCurrentNode= list1.head;

					for(int i = 0; i < biggerListSkipCount; i++)
					{
						biggerListCurrentNode = biggerListCurrentNode.next;
					}

					while(biggerListCurrentNode != null && smallerListCurrentNode != null)
					{
						if(biggerListCurrentNode.data == smallerListCurrentNode.data)
						{
							intersectingNodeStart = biggerListCurrentNode;
							
							return intersectingNodeStart;
						}
						biggerListCurrentNode = biggerListCurrentNode.next;
						smallerListCurrentNode = smallerListCurrentNode.next;
					}	
				}


			}
		}
        
        return null;		
	}


	public static void main(String[] args)
	{	
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		Node intersectingNode;

		append(list1, 3);
		append(list1, 1);
		append(list1, 5);
		append(list1, 9);
		append(list1, 7);
		append(list1, 2);
		append(list1, 1);

		append(list2, 4);
		append(list2, 6);
		append(list2, 7);
		append(list2, 2);
		append(list2, 1);

		printByList(list1);
		printByList(list2);

		intersectingNode = getIntersectingNode(list1, list2);
	
        

		printByNode(intersectingNode);


	}
}