//By: Joiney Nguyen
//Description: Add sum of numbers in two lists and output to a new list
//UPDATE (7/23/2020): Used class ListNode instead of LinkedList for cleaner approach.
public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
{
	ListNode currentNode = new ListNode(0);
	ListNode head = currentNode;

	int carry = 0;

	while(l1 != null || l2 != null || carry != 0)
	{
	    ListNode new_node = new ListNode(0);

	    int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + carry;

	    new_node.val = sum % 10;
	    carry = sum / 10;

	    currentNode.next = new_node;
	    currentNode = new_node;

	    l1 = (l1 == null) ? l1 : l1.next;
	    l2 = (l2 == null) ? l2 : l2.next;
	}

	return head.next;
}
