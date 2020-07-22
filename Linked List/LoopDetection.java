//By: Joiney Nguyen
//Description: Check if linked list is a loop

public static boolean isLoop(LinkedList list)
{
	if(list.head == null)
	{
		return false;
	}

	Node slow, fast;

	slow = fast = list.head;

	while(true)
	{
		slow = slow.next;

		if(fast.next != null)
		{
			fast = fast.next.next;
		}
		else
		{
			return false;
		}

		if(slow == null || fast == null)
		{
			return false;
		}

		if(slow == fast)
		{
			return true;
		}

	}
}