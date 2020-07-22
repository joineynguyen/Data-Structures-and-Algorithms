//By: Joiney Nguyen
//Description: Given two separate single linked list, return the node that is the intersection of the two.

public static node returnIntersectingNode(Node head1, Node head2)
{
	int lengthHead1 = length(head1);
	int lengthHead2 = length(head2);

	while(lengthHead1 > lengthHead2)
	{
		head1 = head1.next;
		lengthHead1 --;
	}

	while(lengthHead2 > lengthHead1)
	{
		head2 = head2.next;
		lengthHead2 --;
	}

	while(head1 != head2)
	{
		head1 = head1.next;
		head2 = head2.next;
	}

	return head1;
}

public static Integer length(Node node)
{
	int length = 0;

	while(node != null)
	{
		length ++;
		node = node.next;
	}

	return length;
}
