/*Joiney Nguyen 
 * 
 * Given an input file with four billion non-negative integers, provide an algorithm to
 * generate an integer that is not contained in the file. Assume you have 1 GB of memory available for
 * this task.
 */

package test;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Test 
{
	 public static void findMisingNumber()
	 {
        /* Since we can only use 1GB of memory, we use boolean array since a boolean only takes 1 bit. 
        So, 4 billion times 1 bit is 4 gigabit or (divide by 8 to get gigabyte) 0.5 gigabyte, which is under 1 gigabyte of memory
        Also, since array indices can only be integers, the max integer value is roughly 2 billion.
        Since we need 4 billion value integer, we need to make more than 1 boolean array
        */
		final int size = 2000000000;
		 
        boolean[][] array = new boolean[2][size];
        
        try
        {
            File myFile = new File("input.txt");
            Scanner myReader = new Scanner(myFile);
            
            while(myReader.hasNextLine())
            {
                String line = myReader.nextLine();
                //Long to store numbers over 2 billion since integers cannot store them
                long longNum = Long.parseLong(line);
                /*We divide the long number by 2 billion so it can fit into an integer
                Any long between 0 -  1,999,999,999 will have which = 0
                Any long between 2,000,000,000 - 3,999,999,999 will have which = 1
                */
                int which = (int) (longNum / size);
                int moddedNum = (int) (longNum % size);
           
                
                array[which][moddedNum] = true;
            }
        }
        catch(FileNotFoundException e)
        {
               System.out.println("Cannot open textfile.");  
               e.printStackTrace();
        }
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(!array[i][j])
                {
                    //i represents the number of times the position has passed the size limit of 2 bilion, so we times that by our size and plus the remainderr/j
                	System.out.println(i * size + j);
                    return;
                }
            }
        }
    
	}
	
	public static void main(String[] args)
	{
		findMisingNumber();
	}
}
