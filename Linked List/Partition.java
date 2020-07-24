//By: Joiney Nguyen
//Description: Place nodes in linked list with values lower than X node on the left of X node and nodes with values bigger or equal to X node to the right of the node X.
//UPDATE (7/23/2020): Changed LinkedList class to ListNode for cleaner code.

 public ListNode partition(ListNode head, int x) 
    {
        ListNode smallHead = new ListNode(0);
	    ListNode bigHead = new ListNode(0);

        ListNode smallCurrent = smallHead;
        ListNode bigCurrent = bigHead;	

        ListNode currentNode = head;
        
        while(currentNode != null)
        {
            if(currentNode.val < x)
            {
                smallCurrent.next = currentNode;
                smallCurrent = currentNode;
            }
            else if(currentNode.val >= x)
            {
                bigCurrent.next = currentNode;
                bigCurrent = currentNode;
            }

            currentNode = currentNode.next;

        }

        bigCurrent.next = null;
        
        smallCurrent.next = bigHead.next;

        return smallHead.next;
 
    }
