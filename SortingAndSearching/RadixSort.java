package practice;

import java.util.ArrayList;

public class Prac
{
    static void radixSort(int[] array)
    {
       /*We find max number to see max number of digits the integers in the array has
        since we are sorting by digits in each number. If our max number is 100, then we would
        need to sort all integers in the ones place from the original order, 
        then tens place from the order of one's place order, 
        and finally the hundredth place from the ten's place order.
        */
       int max = findMax(array);
       //Keeps count of how many digits in max number
       int digitCount = 0;
       //We divide the max number by tens until we reach 0, this will tell us how many digits is in our max number
       while(max != 0)
       {
           max /= 10;
           digitCount++;
       }
       
       //We have buckets to hold each integer with same numbers in the current digit's place, and we use 10 because 0-9 digits exists in integers
       ArrayList<Integer>[] buckets = new ArrayList[10];
       //We initialize each bucket with an arraylist to hold mutiple integers with same numbres in current digit's place
       for(int i = 0; i < buckets.length; i++)
       {
           buckets[i] = new ArrayList<Integer>();
       }
       
       //Digit place will represent by exponent of 10: 10^0 = 1, 10^1 = 10, 10^2 = 100, and so on.
       int exp = 0;
       /*We sort integers into buckets by same numbers in current digit place by max number's digit count number of times
       For example, we perform this loop of sorting 3 times since there are 3 digits in 100 (our max number)
       */
       while(exp < digitCount)
       {
           //We go through each number in the original array
           for(int i = 0; i < array.length; i++)
           {
                /*We convert the answer to int because math.pow takes double variable parameters
                We divide the interger by 1, 10, or 100 then mod the integer by 10 to get its one's, ten's, or hundred's digit 
                Example: dividing 123 by 100 then modding 10 will give us the hundreds place to be the number 1
                dividing 123 by 10 then modding 10 will give us the tens place to be the number 2
                dividing 123 by 1 then modding 10 will give us the ones place to be the number 3
                */
               int digitsPlace = (int) ((array[i] / Math.pow(10, exp)) % 10);
               
               buckets[digitsPlace].add(array[i]);
           }
           /*
           We are going to place order of integers from each bucket to replace original array
           Index will keep track where were at in original array, to increment to the next element after replacing integer from buckets
           */
           int index = 0;
           //Iterate through each bucket of integers
           for(int j = 0; j < buckets.length; j++)
           {
               //Iterate through all integers in each bucket
               for(Integer integerInBucket : buckets[j])
               {
                   array[index++] = integerInBucket;
               }
               //We clear buckets for next digit placement loop for sorting
               buckets[j].clear();
           }
           //Increment exponetial of 10 by 1 to start sorting by next digit place
           exp++;
       }
       
    }
   
    static int findMax(int[] array)
    {
        int max = array[0];
        
        for(int i = 1; i < array.length - 1; i++)
        {
            if(array[i] > max)
            {
                max = array[i];
            }
        }
        return max;
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
        int[] array = {7, 6, 10, 5, 9, 1, 15, 7};
        
        radixSort(array);
        print(array);
    }
    
}
