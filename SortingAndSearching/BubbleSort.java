/*
Joiney Nguyen

Bubble sorting an unsorted int array. Bubble sorting is iterating through with two indexes: i-1 and i. If i-1 index is greater than i index, we swap them. We do the same procedure as we iterate through the whole array. We repeat these steps until we no longer need to swap, hence the array is sorted
*/
public class Prac 
{
	static void bubbleSort(int[] arr)
	{
		int arrSize = arr.length;
		int temp;
		boolean swapped;
		
    //Keep bubble sorting until there is no more swapping, hence the swap boolean to break out of loop
		do
		{
			swapped = false;
			
			for(int i = 1; i < arrSize - 1; i++)
			{
				if(arr[i - 1] > arr[i])
				{
					temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					swapped = true;
				}
			}
			
		}while(swapped);
		
	}
	
	static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i ++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {9, 8, 7, 6, 3, 1, 2};
		bubbleSort(arr);
		printArray(arr);
		
	}
}
