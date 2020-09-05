package practice;

public class Prac
{
    //lb = lower bound/beginning index of array. ub = upperbound of array or end index of array 
    static int partition(int[] array, int lb, int ub)
    {
        /*
        We automatically choose the beginning index of array as our pivot element. 
        We pivot everything less than the pivot to its left and greater than pivot to its right
        */
        int pivot = array[lb];
        //Help us to swap
        int temp;
        
        while(lb < ub)
        {
            //We are increasing the lowerbound pointer until we find an element that is larger than pivot
            while(array[lb] < pivot)
            {
                lb++;
            }
            //We are decreasing the uppberound pointer until we find an element that is smaller than pivot
            while(array[ub] > pivot)
            {
                ub--;
            }
            //We then swap the elements from lb and ub pointers since they are on the wrong side of the partition
            if(lb < ub)
            {
                temp = array[lb];
                array[lb] = array[ub];
                array[ub] = temp;
            }
        }
            
            
        return ub;
    }
    
    /*Quick sort uses divide and conquer technique to sort. 
    The algorthm partitions the array until the lower bound is no longer less than upperbound, hence a single element array.
    */    
    static int[] quickSort(int[] array, int lb, int ub)
    {
        //Base case. Stop when lowerbound index is higher than upperbound index
        if(lb < ub)
        {
            int lock = partition(array, lb, ub);
            //Performs recursion on left side of partition
            quickSort(array, lb, lock - 1);
            //Performs recursion on right side of partition
            quickSort(array, lock + 1, ub);
        }
        return array;
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
        int[] array = {4, 6, 3, 2, 1, 7, 9, 8, 10};
        
        array = quickSort(array, 0, array.length - 1);
        print(array);
    }
    
}
