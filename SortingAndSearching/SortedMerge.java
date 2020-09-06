/*
Joiney Nguyen

Sorted Merge - You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.
*/
package practice;

public class Prac
{
    static void mergeSort(int[] arrayA, int[] arrayB)
    {
        int elementsInA = 0;
        //Find out how many real numbers in array a. If its not -1 then its real
        for(int i = 0; i < arrayA.length; i++)
        {
            if(arrayA[i] != -1)
            {
                elementsInA += 1;
            }
        }
        
        //lastIndexA is the last index of actual numbers in array a
        int lastIndexA = elementsInA - 1;
        //lastTotalIndex is the last index of the array a, along with the buffer.
        int lastTotalIndex = arrayA.length - 1;
        int lastIndexB = arrayB.length - 1;
        
        /*Sort between the bigger values of array a and array b from their last actual elements to place 
        from the end of the actual total array a
        */
        
        //While there are still numbers
        while(lastIndexA >= 0 || lastIndexB >= 0)
        {
            //If both arrays still have numbers, sort the bigger to be placed towards end of actual array a
            if(lastIndexA >= 0 && lastIndexB >= 0)
            {
                if(arrayA[lastIndexA] > arrayB[lastIndexB])
                {
                    arrayA[lastTotalIndex--] = arrayA[lastIndexA--];
                }
                else
                {
                    arrayA[lastTotalIndex--] = arrayB[lastIndexB--];
                }
            }
            //If only array A has numbers left, use them as default
            else if(lastIndexA >= 0)
            {
                arrayA[lastTotalIndex--] = arrayA[lastIndexA--];
            }
            //And if only array B has numbers left, use them as default
            else if(lastIndexB >= 0)
            {
                arrayA[lastTotalIndex--] = arrayB[lastIndexB--];
            }
        }
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
        int[] arrayA = {2, 4, 6, 8, 10, -1, -1, -1, -1 ,-1};
        
        int[] arrayB = {1, 3, 5, 7, 9};
        
        mergeSort(arrayA, arrayB);
        
        print(arrayA);
        
    }
        
    
}
