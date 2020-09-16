/* 
Joiney Nguyen

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
*/

import java.util.PriorityQueue;
import java.util.Comparator;
import java.lang.Math;

class Solution 
{
    public int[][] kClosest(int[][] points, int K) 
    {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>()
                                                           {
                                                                //Custom comparator to compare distances of each point
                                                                public int compare(int[] point1, int[] point2) 
                                                                {
                                                                    int point1_distance = getDistance(point1);
                                                                    int point2_distance = getDistance(point2);
                                                                    //Think of +1, -1, or 0 as priority points. the higher the points the more priority       
                                                                    if(point1_distance < point2_distance)//Since we want the least distance to origin, we +1 when first point is shorter than 2nd point
                                                                    {
                                                                        return 1;
                                                                    }
                                                                    else if(point1_distance > point2_distance)// -1 if first point is father than second point
                                                                    {
                                                                        return -1;
                                                                    }
                                                                    else 
                                                                    {
                                                                        return 0;
                                                                    }
                                                                }

                                                                public int getDistance(int[] point)
                                                                {
                                                                    return point[0] * point[0] + point[1] * point[1];
                                                                }
                                                           });
        //We insert each point from array of points onto the priority queue and removing the largest distant point if the priority queue size is larger than K
        for(int[] point : points)
        {
            pq.offer(point);
            
            if(pq.size() > K)
            {
                pq.poll();
            }
        }
        //We make a new array with only K number of smallest points to origin, and 2 elements in each outter element because each point has x and a y coordinate
        int[][] result = new int[K][2];
        
        for(int i = 0; i < K; i++)
        {
            result[i] = pq.poll();
        }
        
        return result;
    }
}
