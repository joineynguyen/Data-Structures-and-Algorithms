/*	Joiney Nguyen

	Write a function to determine the number of bits you would need to flip to convert
	integer A to integer B.
*/
public class Solution
{

	int findBitDifference(int num1, int num2)
	{
		int numOfDifference = 0;
	
		while(num1 != 0 || num2 != 0)
		{
			boolean num1isOne = (num1 & 1) != 0 ? true : false;
			boolean num2isOne = (num2 & 1) != 0 ? true : false;

			if(num1isOne != num2isOne)
			{
				numOfDifference += 1;
			}

			num1 >>= 1;
			num2 >>= 1;
		}

		return numOfDifference;
	}

	public static void main(String[] args)
	{
		Solution my = new Solution();

		int num1 = 29;
		int num2 = 15;

		System.out.println(my.findBitDifference(num1, num2));
	}
	    
	    
	


}
