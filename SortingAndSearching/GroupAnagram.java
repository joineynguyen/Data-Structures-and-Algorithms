/*
Joiney Nguyen

Write a method to sort an array of strings so that all the anagrams are next to
each other.
*/
package practice;

public class Prac
{
    //We compare and sort the string by each string's acsi value of all char in them
    static void sortAnagrams(String[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
        {
            //Start off i as min
            int minIndex = i;
            
            for(int j = i + 1; j < array.length; j++)
            {
                //If we find another min, update the min 
                if(hash(array[j]) < hash(array[minIndex]))
                {
                    minIndex = j;
                }
            }
            //Only if the new min is not the current unsorted string, we swap the two
            if(minIndex != i)
            {
                String temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
    
    /*Iterate through all chars in the string and add up their asci values.
    Matching sum of two string's asci value tells us that they have the same letters but not same order
    */
    static int hash(String string)
    {
        int total = 0;
        
        for(int i = 0; i < string.length(); i++)
        {
            total += (int)string.charAt(i);
        }
        return total;
    }
    
    static void print(String[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
     
    public static void main(String[] args)
    {
        String[] strings = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sortAnagrams(strings);
        print(strings);
       
    }
        
    
}
