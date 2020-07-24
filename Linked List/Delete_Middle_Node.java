//By: Joiney Nguyen
//Description: Delete the middle node of the linked list.
//UPDATE (7/23/2020): Changed LinkedList class to ListNode class for cleaner code.

public void deleteMiddleNode(ListNode head)
{
	int lenght = 0;

	ListNode currentNode = head;

	while(currentNode != null)
	{
		length ++;

		currentNode = currentNode.next;
	}

	length /= 2;

	
	ListNode prevNode = null;
	currentNode = head;


	if(legnth > 0)
	{
		while(length > 0)
		{
			prevNode = currentNode;
			currentNode = currentNode.next;
			length --;
		}

	}

	prevNode.next = currentNode.next;
}

