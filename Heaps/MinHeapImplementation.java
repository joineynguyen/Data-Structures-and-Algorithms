/*Joiney Nguyen
 * 
 * Min Heap implementation 
 */

package test;

public class MinHeap 
{
	int maxSize;
	int size;
	int[] heap;
	
	public MinHeap(int capacity)
	{
		maxSize = capacity;
		size = 0;
		heap = new int[capacity];
	}
	
	public int getParentIndex(int childIndex)
	{
		return (childIndex - 1) / 2;
	}
	
	public int getLeftChildIndex(int parentIndex)
	{
		return (parentIndex * 2) + 1;
	}
	
	public int getRightChildIndex(int parentIndex)
	{
		return (parentIndex * 2) + 2;
	}
	
	public int parent(int childIndex)
	{
		return heap[getParentIndex(childIndex)];
	}
	
	public int leftChild(int parentIndex)
	{
		return heap[getLeftChildIndex(parentIndex)];
	}
	
	public int rightChild(int parentIndex)
	{
		return heap[getRightChildIndex(parentIndex)];
	}
	
	public boolean hasLeftChild(int parentIndex)
	{
		return getLeftChildIndex(parentIndex) < size;
	}
	
	public boolean hasRightChild(int parentIndex)
	{
		return getRightChildIndex(parentIndex) < size;
	}
	
	public boolean isFull()
	{
		return size == maxSize;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void swap(int index1, int index2)
	{
		int temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	}
	
	//Bubble the end element up till they become root or they are no longer smaller than their parent
	public void heapifyUp()
	{
		int index = size - 1;
		
		while(index > 0 && heap[index] < parent(index))
		{
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	//Bubble first element down until they are no longer smaller than their children or has no children
	public void heapifyDown()
	{
		int index = 0;
		
		while(hasLeftChild(index))
		{
			int smallestChildIndex = getLeftChildIndex(index);
			
			if(hasRightChild(index) && rightChild(index) < heap[smallestChildIndex])
			{
				smallestChildIndex = getRightChildIndex(index);
			}
			
			if(heap[smallestChildIndex] < heap[index])
			{
				swap(smallestChildIndex, index);
			}
			
			index = smallestChildIndex;
		}
	}
	
	//Add to heap by the end of heap array and bubble it up
	public void add(int num)
	{
		if(isFull())
		{
			return;
		}
		
		heap[size] = num;
		size++;
		heapifyUp();
	}
	
	//Remove top element and replace with end element then bubble down until element is no longer larger than its children
	public void poll()
	{
		if(isEmpty())
		{
			System.out.println("Can't poll empty heap.");
			return;
		}
		
		System.out.println(heap[0] + " has been polled.");
		heap[0] = heap[size - 1];
		size--;
		heapifyDown();
	}
	
	public void peek()
	{
		if(isEmpty())
		{
			System.out.println("Can't peek empty heap.");
			return;
		}
		System.out.println("Peeking " + heap[0]);
	}
	
	public static void main(String[] args)
	{
		MinHeap m = new MinHeap(5);
		m.add(99);
		m.add(55);
		m.add(79);
		m.add(44);
		m.add(84);
		m.poll();
		m.poll();
		m.poll();
		m.poll();
		m.poll();
		
	}
}
