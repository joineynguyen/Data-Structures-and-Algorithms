/*	Joiney Nguyen
	
	You have an integer and you can flip exactly one bit from a 13 to a 1. Write code to
	find the length of the longest sequence of ls you could create.

*/

public class Solution
{

	int longestOneSequence(int num)
	{
		//special case if num has all 1's, then its negation would equal to zero.
		//we would then return all 1's that take up integer's byte size of 4 times 8 bits, for total bits of sequential 1's
		if(~num == 0)
		{
			return Integer.BYTES * 8;
		}

		//acts as a runner scanner, to scan all the 1's before running into a 0
		int currentScanned = 0;
		//once the runner scanner bumps into a 0, it will save the num of 1's it ran into in this variable prevScanned
		int prevScanned = 0;
		//used to hold max of currentScanned + prevScanned found
		int max = 0;

		//while num is not 0 since we are rightshifting the num each iteration for bit by bit algorithm
		while(num > 0)
		{
			//we AND num's bit to bit 1 (0001) to see if it equals to 1 to let us know, 1 is the current bit of the right most index
			if((num & 1) == 1)
			{
				currentScanned += 1;
			}
			//we AND num's bit to bit 1 (001) to see if it equals to 0 to let us know, 0 is the current bit 
			else if((num & 1 == 0))
			{
				//if the most right current bit is 0, we check to see if the bit next to it is also 0
				//two consecutive 0's would reset the prevScanned variable since we can only flip one bit
				prevScanned = (num & 2) == 0 ? 0 : currentScanned;
				//since prevScanned saved the num of 1's scanned from currentScanned, we can reset currentScanned
				currentScanned = 0;

			}
			//each iteration of bit by bit, we add the prevScanned to currentScanned
			max = Math.max(prevScanned + currentScanned, max);
			//we right shift num to get the next right most bit
			num >>= 1;
		}
		//we return max number of consecutive 1's plus another 1 for the one 0 that we skipped
		return max + 1;
	}

}
