//By: Joiney Nguyen
//Description: Add the sum values of the list and place each digit of the total in new linked list

public class LinkedList
{
	Node head;
	Node tail;

	static class Node
	{
		int data;
		Node next;
		Node prev;

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
			new_node.next = null;
			new_node.prev = null;
			list.tail = new_node;
		}
		else
		{
			Node last = list.head;

			while(last.next != null)
			{
				last = last.next;
			}

			last.next = new_node;
			new_node.next = null;
			new_node.prev = last;
			list.tail = new_node;
		}
	}

	public static void push(LinkedList list, int data)
	{
		Node new_node = new Node(data);

		if(list.head == null)
		{
			list.head = new_node;
			list.tail = new_node;
			new_node.next = null;
			new_node.prev = null;
		}
		else
		{
			new_node.next = list.head;
			list.head.prev = new_node;
			new_node.prev = null;
			list.tail = list.head;
			list.head = new_node;
			
		}
	}

	public static LinkedList sumListBackward(LinkedList list1, LinkedList list2)
	{
		Node currentNode;
		int currentVal;
		String temp;
		int list1Num = 0;
		int list2Num = 0;
		int total;
		int singleDigit;

		StringBuilder sb = new StringBuilder();
		LinkedList output = new LinkedList();
		

		if(list1.tail != null)
		{
			currentNode = list1.tail;

			while(currentNode != null)
			{
				currentVal = currentNode.data;
				sb.append(currentVal);
				currentNode = currentNode.prev;
			}

			temp = sb.toString();

			list1Num = Integer.parseInt(temp);

			sb.setLength(0);
		}

		if(list2.tail != null)
		{
			currentNode = list2.tail;

			while(currentNode != null)
			{
				currentVal = currentNode.data;
				sb.append(currentVal);
				currentNode = currentNode.prev;
			}

			temp = sb.toString();

			list2Num = Integer.parseInt(temp);
		}


		total = list1Num + list2Num;

		System.out.println("Backward" + total);

		while (total > 0) 
		{
		    //get ones-place digit from total
		    singleDigit = total % 10;
		    //take away ones-place digit from total
		    total = total / 10;

		    append(output,singleDigit);

		}

			
		

		return output;
	}


	public static LinkedList sumListForward(LinkedList list1, LinkedList list2)
	{
		Node currentNode;
		int currentVal;
		int list1Num = 0;
		int list2Num = 0;
		int total;
		int singleDigit;
		String temp;

		StringBuilder sb = new StringBuilder();
		LinkedList output = new LinkedList();

		if(list1.head != null)
		{
			
			currentNode = list1.head;

			while(currentNode != null)
			{
				currentVal = currentNode.data;
				sb.append(currentVal);
				currentNode = currentNode.next;
			}

			temp = sb.toString();
			list1Num = Integer.parseInt(temp);
			sb.setLength(0);
		}

			
		if(list2.head != null)
		{
			currentNode = list2.head;

			while(currentNode != null)
			{
				currentVal = currentNode.data;
				sb.append(currentVal);
				currentNode = currentNode.next;

			}

			temp = sb.toString();
			list2Num = Integer.parseInt(temp);

		}
			
		total = list1Num + list2Num;

		System.out.println("Forward" + total);

		while(total > 0)
		{
    		singleDigit = total % 10;
    
    		total = total / 10;
    
    		push(output, singleDigit);
		}

		

		return output;
	}



	public static void print(LinkedList list)
	{
		Node currentNode = list.head;

		while(currentNode != null)
		{
			System.out.print(currentNode.data + " -> ");

			currentNode = currentNode.next;
		}

		System.out.println();
	}


	public static void main(String[] args)
	{
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList sumBackward = new LinkedList();
		LinkedList sumForward = new LinkedList();

		append(list1, 6);
		append(list1, 1);
		append(list1, 7);


		append(list2, 2);
		append(list2, 9);
		append(list2, 5);

		print(list1);
		print(list2);

		//sumBackward = sumListBackward(list1, list2);

		//print(sumBackward);

		sumForward = sumListForward(list1, list2);

		print(sumForward);



	}






}