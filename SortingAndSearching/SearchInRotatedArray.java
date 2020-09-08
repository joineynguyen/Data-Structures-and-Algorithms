/*
Joiney Nguyen

Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
number of times, write code to find an element in the array. You may assume that the array was
originally sorted in increasing order.
*/
package practice;

public class Prac
{
    //Find starting index of rotated array
    static int findStartingIndex(int[] array)
    {
        int left = 0;
        int right = array.length - 1;
        
        //Once left is no longer greater than right, the left and right pointer is met and we found our starting index
        while(left <= right)
        {
            int middle = left + (right - left) / 2;
            
            /*If left element is greater than right element, we know that it is 
            rotated and we must update the left pointer as middle + 1 to get closer to real starting index
            */
            if(array[middle] > array[right])
            {
                left = middle + 1;
            }
            else
            {
                right = middle;
            }
        }
        
        return left;
    }
    
    static int binarySearch(int[] array, int target)
    {
        int start = findStartingIndex(array);
        
        int left = 0;
        int right = array.length - 1;
        int middle = -1;
        
        if(target < array[start])
        {
            right = start;
        }
        else if(target > array[start])
        {
            left = start;
        }
        
        while(left < right)
        {
            middle = left + (right - left) / 2;
            
            if(target == array[middle])
            {
                return middle;
            }
            else if(target < array[middle])
            {
                right = middle - 1;
            }
            else if(target > array[middle])
            {
                left = middle + 1;
            }
        }
        
        return middle;
    }
      
    static void print(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
     
    public static void main(String[] args)
    {
        int[] array = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
       
        System.out.println("The number was found at index: " + binarySearch(array, 5));
       
    }
        
    
}
