/*
Joiney Nguyen

Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
*/

import java.util.Collections;
import java.util.PriorityQueue;

class KthLargest 
{
    int chosenK;
    PriorityQueue<Integer> pq;
    
    
    public KthLargest(int k, int[] nums) 
    {
        chosenK = k;
        //Create priority queue with 3 max size so when we poll the queue it gets the 3rd largest element
        pq = new PriorityQueue<Integer>(3);
        
        for(int i : nums)
        {
           add(i); 
        }
    }
    
    public int add(int val) 
    {
        //If the queue size is smaller than k then we add them to fill up queue for comparing new additions
        if(pq.size() < chosenK)
        {
            pq.offer(val);
        }
        else
        {
            //We do not want to add smaller numbers then the head of queue (smallest element) because it would be 4th largest number
            if(val > pq.peek())
            {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
