/*	Joiney Nguyen

	Write a program to swap odd and even bits in an integer with as few instructions as
	possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

*/
public class Solution
{

	static int swapBits(int num)
	{
		//0xAAAAAAAA is 1010 pattern
		int even = num & 0xAAAAAAAA;
		//shift it to make it in odd position
		even >>= 1;
    
        //0x55555555 is 0101 pattern
		int odd = num & 0x55555555;
		//shift it to make it in even position
		odd <<= 1;

		return (even | odd);
	}
	 
	    
	public static void main(String[] args)
	{
		int num = 23;

		System.out.println(swapBits(23));
	}


}
