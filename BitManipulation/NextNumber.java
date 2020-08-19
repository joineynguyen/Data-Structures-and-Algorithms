/*	Joiney Nguyen

	Given a positive integer, print the next smallest and the next largest number that
	have the same number of 1 bits in their binary representation.
*/
public class Solution
{

	Integer getLeftMostOneIndex(int num)
	{
		//to prevent any changes from actual num
		int tempNum = num;
		//to store current iteration as we right shift tempNum
		int currentIndex = 0;
		//hold highest index that is 1
		int highestIndex = 0;

		//after right shifting tempNum and tempNum is not 0 aka still a number with 1's
		while(tempNum > 0)
		{
			//if the most right bit is 1, we set highestIndex as the current index we are on
			if((tempNum & 1) == 1)
			{
				highestIndex = currentIndex;
			}

			currentIndex += 1;
			//shift tempNump right to inspect next bit
			tempNum >>= 1;
		}

		return highestIndex;
	}


	Integer getNextLargest(int num)
	{
		//if num is 0, we already know 0 plus 1 before it (10) is 2
		if(num == 0)
		{
			return 2;
		}

		int highestIndex = getLeftMostOneIndex(num);

		//we make a mask that has a 1 big added to the left most bit of num
		int mask = 1 << (highestIndex + 1);

		//we combine the mask bits and num bits
		return num | mask;
	}

	Integer getNextSmallest(int num)
	{
		//if num is 0 or 1, we already know the next smallest integer is 0, since we cannot possibly have any more 1's on the right side
		if(num == 0 || num == 1)
		{
			return 0;
		}
		
		int tempHighestIndex = getLeftMostOneIndex(num);
		//we minus 1 to the highest index having 1, because we are checking where is the next 1 to the right of it
		tempHighestIndex -= 1;
        int mask = 0;
        
		while(tempHighestIndex > 0)
		{
			
			mask = (1 << tempHighestIndex);

			if((num & mask) != 0)
			{
				break;
			}

			tempHighestIndex -= 1;
		}

	    //we make another mask called right ones to have all 1's from second highest index of 1 found
	    int rightOnes = (1 << (tempHighestIndex + 1)) - 1;

		return num & rightOnes;
		
	}
	
	public static void main(String[] args)
	{
	    Solution mySolution = new Solution();
	    Integer num = 10;

	    Integer nextLargest = mySolution.getNextLargest(num);
	    Integer nextSmallest = mySolution.getNextSmallest(num);

	    System.out.println("Next largest is: " + nextLargest);
	    System.out.println("Next smallest is: " + nextSmallest);
	    System.out.println("Left most one index is: " + mySolution.getLeftMostOneIndex(num));
	    
	    
	}


}
