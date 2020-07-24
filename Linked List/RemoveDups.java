//By: Joiney Nguyen
//Description: Remove duplicates in the linked list.
//UPDATE (7/23/2020) Changed LinkedList class to ListNode class for cleaner code. Also added a second solution that uses no buffer.
 public void removeDups(ListNode n) 
    {
        if(n == null)
        {
            return;
        }

        HashSet<Integer> myHash = HashSet<Integer>();

        ListNode prevNode = null;
   
        while(n != null)
        {
            if(myHash.contains(n.data))
            {
                prevNode.next = n.next;
            }
            else
            {
                myHash.add(n.data);
                prevNode = n;
            }

            
            n = n.next;
        }
    }


public void removeDups(ListNode head) //no buffer
{
	if(head == null)
	{
		return;
	}

	ListNode currentNode = head;

	while(currentNode != null)
	{
		ListNode scannerNode = currentNode;

		while(scannerNode.next != null)
		{
			if(scanner.next.data == currentNode.data)
			{
				scanner.next = scanner.next.next;
			}
			else
			{
				scanner = scanner.next;
			}

			currentNode = currentNode.next;
		}
	}
}
