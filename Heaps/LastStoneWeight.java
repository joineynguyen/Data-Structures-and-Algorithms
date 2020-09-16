/*
Joiney Nguyen

We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
*/

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution 
{
	public int lastStoneWeight(int[] stones)
	{
		//Originally, priority queues acts as a min heap, so we rever order it to make it a max heap
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i : stones)
		{
			pq.add(i);
		}
		
    //While the size is greater than one because we poll 2 elements at a time
		while(pq.size() > 1)
		{
			int y = pq.poll();
			int x = pq.poll();
			
      //If 1st poll and 2nd poll are equal just continue
			if(y == x)
			{
				continue;
			}
      //If they are not equal, then 1st poll has to be bigger in the heap. As we subtract 1st poll to 2nd poll we automatically get a non negative number
			else
			{
				pq.offer(y - x);
			}
		}
		
    //If we limit our while loop above to stop when size is 1 or smaller, we can only have one element left if queue or the queue is empty 
		return pq.isEmpty()? 0 : pq.poll();
		
	}
	
}
