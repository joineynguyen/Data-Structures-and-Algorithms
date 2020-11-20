/*
Joiney Nguyen

Write a recursive function to multiply two positive integers without using
the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
minimize the number of those operations.

*/

public class Solution 
{
    
    static void multiply(int a, int b)
    {
        int smaller = a < b ? a : b;
        int bigger = a > b ? a : b;
        
        int[] memo = new int[smaller + 1];
        
        System.out.println(multiply(smaller, bigger, memo));
    }
    
    static int multiply(int smaller, int bigger, int[] memo)
    {
         if(smaller == 0)
         {
             return 0;
         }
         else if(smaller == 1)
         {
             return bigger;
         }
         else if(memo[smaller] > 0)
         {
             return memo[smaller];
         }
         
         int halfOfSmaller = smaller >> 1;
         
         int side1 = multiply(halfOfSmaller, bigger, memo);
         int side2 = side1;
         
         if(side2 % 2 == 1)
         {
             side2 = multiply(smaller - halfOfSmaller, bigger, memo);
         }
         
         memo[smaller] = side1 + side2;
         return memo[smaller];
    }

    
    public static void main(String args[]) 
    {
      multiply(17, 3);
    }
}
