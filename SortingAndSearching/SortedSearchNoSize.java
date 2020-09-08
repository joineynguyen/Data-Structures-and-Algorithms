/* Joiney Nguyen

You are given an array-like data structure Listy which lacks a size
method. It does, however, have an elementAt (i) method that returns the element at index i in
0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
find the index at which an element x occurs. If x occurs multiple times, you may return any index.
*/

package practice;

public class Listy
{
    int[] array;
    
    public Listy(int[] array)
    {
        this.array = array.clone();
    }
    
    public int elementAt(int index)
    {
        if(index >= this.array.length)
        {
            return -1;
        }
        
        return this.array[index];
    }
    
    public int binarySearch(int target)
    {
        int index = 1;
        
        //Expoentially increase index of 1 by 2 until we reach dead end (-1) or the target is lower than the array at that index
        while(target > elementAt(index) && elementAt(index) != -1)
        {
            index *= 2;
        }
        
        int high = index;
        int low = index / 2;
        
        while(low <= high)
        {
            int middle = (high + low) / 2;
            
            if(target == elementAt(middle))
            {
                return middle;
            }
            //In case the element of middle is -1, we decrease the cap/high by middle - 1 to get back into bounds
            else if(target < elementAt(middle) || elementAt(middle) == -1)
            {
                high = middle - 1;
            }
            else if(target > elementAt(middle))
            {
                low = middle + 1;
            }
        }
        
        return -1;
        
    }
    
    public static void main(String[] args)
    {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        
        Listy object = new Listy(array);
        
        for(int i : array)
        {
            System.out.println(object.binarySearch(i));
        }
        
    }
}
