/*
Joiney Nguyen

Merge sort first divides the array into equal halves and then combines them in a sorted manner.
*/

package practice;

public class MergeSort
{
    //Dividing the array in half recursively until it is only 1 element then merge their sorted neighbor as we go back up the recursion
    static int[] mergeSort(int[] array)
    {
        //base case for recursion
        if(array.length <= 1)
        {
            return array;
        }
        
        int middle = array.length / 2;
        
        int[] left = new int[middle];
        int[] right;
        
        //In case the array is odd, we want the right array to have +1 to offset
        if(array.length % 2 == 0)
        {
            right = new int[middle];
        }
        else
        {
            right = new int[middle + 1];
        }
        
        //We fill in the new left array with left half of current array in recusrion
        for(int i = 0; i < middle; i++)
        {
            left[i] = array[i];
        }
        /*We fill in the new right array with right half of current array in recusrion. 
        Notice how we the if loop condition ends with right lenght instead of middle is because right side array may have a +1 to offset any odd arrays
        */
        for(int j = 0; j < right.length; j++)
        {
            right[j] = array[j + middle];
        }
        
        //We use this result array to store when we merge the left and right arrays as we go up the recursion
        int[] result = new int[array.length];
        
        //Dividing the array left and right until we hit the base case
        left = mergeSort(left);
        right = mergeSort(right);
        
        //Merge the left and right arrays as we go up the recursion
        result = merge(left, right);
        
        return result;
    }
    //As we merge left and right arrays, we import the element from left and right arrays in ascending order to the new result array
    static int[] merge(int[] left, int[] right)
    {
        //the new result array must be big enough to hold both left and right arrays
        int[] result = new int[left.length + right.length];
        //Pointers to help us keep track where we are at for each array
        int resultPointer, leftPointer, rightPointer;
        
        leftPointer = rightPointer = resultPointer = 0;
        
        //While there is still elements left in left or right array
        while(leftPointer < left.length || rightPointer < right.length)
        {
            //If there is still more elements in both left and right arrays
            if(leftPointer < left.length && rightPointer < right.length)
            {
                //We add the lower value one to the result array and increase their pointers to let us know we have used that element
                if(left[leftPointer] < right[rightPointer])
                {
                    result[resultPointer++] = left[leftPointer++];
                }
                else if(right[rightPointer] < left[leftPointer])
                {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            //If there are only elements in the left or right array, then we automatically add it to the result array since it is default to be in order
            else if(leftPointer < left.length)
            {
                result[resultPointer++] = left[leftPointer++];
            }
            else if(rightPointer < right.length)
            {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
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
        
        array = mergeSort(array);
        print(array);
    }
    
}
