/*
Joiney Nguyen

Binary Search
*/
package practice;

public class Prac
{
    static int binarySearch(int[] array, int data)
    {
        int lb = 0;
        int ub = array.length - 1;
        
        //As long as lower bound did not pass upperbound, in other words lower bound is no longer representing a lower value number
        while(lb <= ub)
        {
            int middle = (lb + ub) / 2;
            
            if(data == array[middle])
            {
                return middle;
            }
            //If the target data is less than the middle of the array, we shift the upper bound to be left exactly before the middle index
            else if(data < array[middle])
            {
                ub = middle - 1;
            }
            //If the target data is greater than the middle of the array, we shift the lower bound to the right exactly after the middle inex
            else
            {
                lb = middle + 1;
            }   
        }
        System.out.println("Data not found in array.");
        return -1;
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
        int[] array = {44, 56, 66, 67, 84, 91, 104, 122};
        
        int index = binarySearch(array, 91);
        System.out.println("Element " + array[index] + " is found at index " + index);
    }
        
    
}
