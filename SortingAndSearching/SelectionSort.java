/*
 * Joiney Nguyen
 * 
 * Selection sort on unsorted int array. The smallest element is selected from the unsorted array and swapped with the leftmost element, and that element becomes a part of the sorted array. This process continues moving unsorted array boundary from one element to the right.
 */
public class Prac 
{
	static void selectionSort(int[] arr)
	{
		int arrSize = arr.length;
		int temp;
		
		for(int i = 0; i < arrSize - 1; i++)
		{
			for(int j = i + 1; j < arrSize - 1; j++)
			{
				if(arr[j] < arr[i])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
	
		}
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
		selectionSort(arr);
		printArray(arr);
		
	}
}
