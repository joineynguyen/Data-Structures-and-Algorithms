/*  Joiney Nguyen
    You are given two 32-bit numbers, Nand M, and two bit positions, i and
  j. Write a method to insert Minto N such that M starts at bit j and ends at bit i. You
  can assume that the bits j through i have enough space to fit all of M. That is, if
  M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for
  example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.
*/

int insertion(int bigNum, int smallNum, int smallIndex, int bigIndex)
	{
		if(smallIndex > bigIndex || smallIndex < 0 || bigIndex >= 32)
		{
			return 0;
		}

		int allOnes = ~0; 

		//make numbers from highest index to bigIndex all 1's
		int left = allones << (bigIndex + 1);
		//make numbers from smallIndex to lowest index
		int right = (1 << smallIndex) - 1;
		//make a dummy number with all 1's with 0s inclusively from bigIndex to smallIndex
		int mask = left | right;

		//keep bigNum same as is but with 0's inclusively form bigIndex to smallIndex
		int bigNum_cleared = bigNum & mask;

		int smallNum_shifted = smallNum << smallIndex;

		return bigNum_cleared | smallNum_shifted;





	}
