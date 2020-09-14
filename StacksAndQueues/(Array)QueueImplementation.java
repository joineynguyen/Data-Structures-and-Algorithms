/* Joiney Nguyen
 * 
 * Queue implementation using arrays
 */

package test;

/*
 * Queue will be circular since we mod the front and rear pointers of the queue by the capacity
 */
public class Queue 
{
	int capacity;
	int front;
	int rear;
	int count;
	int[] array;
	
	public Queue(int queueCapacity)
	{
		capacity = queueCapacity;//capacity is number of elements are possible to have in array
		front = 0;
		rear = -1; //Start rear with -1 because pushing first number would then start it at index 0 
		count = 0; //Count will help us tell if we hit our capacity (full) or 0 (empty) to limit from enqueue or dequeue'ing
		array = new int[capacity];
	}
	
	public void enqueue(int num)
	{
		if(isFull())
		{
			System.out.println("Queue is full.");
			return;
		}
		
		rear = (rear + 1) % capacity;
		array[rear] = num;
		System.out.println(array[rear] + " pushed.");
		
		count ++;
	}
	
	public void dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println(array[front] + " popped.");
		front = (front + 1) % capacity;
		
		count--;
	}
	
	public boolean isFull()
	{
		if(count == capacity)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEmpty()
	{
		if(count == 0)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
	}
}
