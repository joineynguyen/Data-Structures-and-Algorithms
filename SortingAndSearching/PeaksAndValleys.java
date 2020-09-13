/*
Joiney Nguyen

In an array of integers, a "peak" is an element which is greater than or equal to
the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers.
For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {S, 2} are valleys. Given an array
of integers, sort the array into an alternating sequence of peaks and valleys.
*/
package prac;

import java.util.Arrays;

public class prac
{
    public static void sortPeakValley(int[] array)
    {
        if(array.length <= 1)
        {
            return;
        }
        
        Arrays.sort(array);
        
        for(int i = 1; i < array.length; i += 2)
        {
            swap(array, i, i + 1);
        }
    }
    
    public static void print(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void swap(int[] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    
    public static void main(String[] args)
    {
        int[] array = {5, 3, 1, 2, 3};
        sortPeakValley(array);
        print(array);
        //1 2 3 3 5
    }   //1 3 2 5 3
}
