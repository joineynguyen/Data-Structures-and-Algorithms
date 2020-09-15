/*Joiney Nguyen

Max Heap implementation
*/

package prac;

public class MaxHeap
{
    int maxSize;
    int size; 
    int[] heap;
    
    public MaxHeap(int capacity)
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
    
    public boolean hasLeftChild(int pos)
    {
        return getLeftChildIndex(pos) < size;
    }
    
    public boolean hasRightChild(int pos)
    {
        return getRightChildIndex(pos) < size;
    }
    
    public int leftChild(int parentIndex)
    {
        return heap[getLeftChildIndex(parentIndex)];
    }
    
    public int rightChild(int parentIndex)
    {
        return heap[getRightChildIndex(parentIndex)];
    }
    
    public int parent(int childIndex)
    {
        return heap[getParentIndex(childIndex)];
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
    
    //Used for insertion by bubbling the inserted heap node and swapping with its 
    //parent if it's greater. Repeat process until the node is no longer bigger than its parent or is at the root
    public void heapifyUp()
    {
       int index = size - 1;
       
       while(index > 0 && parent(index) < heap[index])
       {
           swap(getParentIndex(index), index);
           index = getParentIndex(index);
           
       }
    }
    //Used after polling the top element. After polling, we replace the top of heap with the end of heap element. 
    //Then we heapify down, which is bubbling is down until it is no longer smaller than its children or no longer has children
    public void heapifyDown()
    {
        int index = 0;
        
        while(hasLeftChild(index))
        {
            int biggestChildIndex = getLeftChildIndex(index);
            
            if(hasRightChild(index) && rightChild(index) > leftChild(index))
            {
                biggestChildIndex = getRightChildIndex(index);
            }
            
            if(heap[index] < heap[biggestChildIndex])
            {
                swap(index, biggestChildIndex);
            }
            else
            {
                break;
            }
            index = biggestChildIndex;
        }
    }
    
    //Place new element at the end and heapify up to create heap order
    public void insert(int num)
    {
       if(isFull())
       {
           System.out.println("Heap is full.");
           return;
       }
       
       heap[size] = num;
       size ++;
       heapifyUp();
    }
    
    //remove then replace top element of heap with last element and then heapify down to make heap order
    public void poll()
    {
        if(isEmpty())
        {
            System.out.println("Heap is empty.");
            return;
        }
        
        System.out.println(heap[0] + " has been polled");
        heap[0] = heap[size - 1];
        size --;
        heapifyDown();
    }
    
    public void peek()
    {
        if(isEmpty())
        {
            System.out.println("Heap is empty.");
            return;
        }
        
        System.out.println(heap[0] + "is at the top");
    }
    
    public void printHeap()
    {
        if(isEmpty())
        {
            System.out.println("Can't print empty heap.");
            return;
        }
        
        for(int i = 0; i < size; i ++)
        {
            System.out.println(heap[i] + " ");
        }
    }
    
    
    public static void main(String[] args)
    {
        MaxHeap h = new MaxHeap(5);
        h.insert(1);
        h.insert(52);
        h.insert(12);
        h.insert(99);
        h.insert(2);
        
        h.poll();
        h.poll();
        h.poll();
        h.poll();
        h.poll();
    }
}
