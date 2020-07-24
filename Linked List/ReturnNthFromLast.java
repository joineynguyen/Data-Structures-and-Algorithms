//By: Joiney Nguyen
//Description: Return node value of the node that is Nth position from the end.
//UPDATE (7/25/2020): Changed LinkedList class to ListNode class for cleaner code.

public Integer returnKthToLast(LinkedList head, int k)
{
	if(head == null)
	{
		return;
	}

	ListNode currentNode = head;
	int length = 0;

	//get length of list by iterating through it
	while(currentNode != null)
	{
		length ++;

		currentNode = currentNode.next;
	}

	//target index is list length minus the kth index from last
	int hit = length - k;
	currentNode = head;
	length = 0;

	//iterate to wanted node and get element
	while(length != hit)
	{
		currentNode = currentNode.next;
		lenght ++;
	}

	return currentNode.data;

}
