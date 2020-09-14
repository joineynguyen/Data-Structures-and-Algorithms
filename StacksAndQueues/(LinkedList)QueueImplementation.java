/*Joiney Nguyen
 * 
 * Queue implementation using linked lists
 */

package test;

class ListNode
{
	ListNode next;
	int data;
	
	public ListNode(int num)
	{
		data = num;
	}
}

public class QueueLinkedList 
{
	ListNode head, tail; //head to point at beginning of queue for dequeue. tail point at end for easy enqueue
	
	public void enqueue(int num)
	{
		ListNode new_node = new ListNode(num);
		
		if(head == null)
		{
			head = tail = new_node;
			
			System.out.println(new_node.data + " pushed.");
			return;
		}
		
		tail.next = new_node;
		tail = new_node;
		System.out.println(new_node.data + " pushed.");
		
	}
	
	public void dequeue()
	{
		if(head == null)
		{
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(head.data + " popped.");
		head = head.next;
	}
	

	public void print()
	{
		if(head == null)
		{
			return;
		}
		
		ListNode current = head;
		
		while(current != null)
		{
			System.out.println(current.data + " ");
			current = current.next;
		}
	}
	
	public static void main(String[] args)
	{
		QueueLinkedList q = new QueueLinkedList();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
	}
}
