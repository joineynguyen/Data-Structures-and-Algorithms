//By: Joiney Nguyen
//Description: Implementing n number of stacks in one array.

public class Stack 
{
	int[] topOfStack;
	int[] dataArray;
	int[] nextIndex;

	int nextAvailable = 0;
	int currentIndex = 0;

	Stack(int numOfStacks, int capacity)
	{
		topOfStack = new int[numOfStacks];
		for(int i = 0; i < topOfStack.length; i++)
		{
			topOfStack[i] = -1;
		}

		dataArray = new int[capacity];

		nextIndex = new int[capacity];
		for(int i = 0; i < nextIndex.length - 1; i++)
		{
			nextIndex[i] = i + 1;
		}
		nextIndex[nextIndex.length - 1] = -1;
	}

	public void push(int stack, int value)
	{
		if(stack < 0 || stack >= topOfStack.length)
		{
			throw new IndexOutOfBoundsException();
		}

		if(nextAvailable < 0)
		{
			return;
		}

		currentIndex = nextAvailable;
		nextAvailable = nextIndex[currentIndex];
		dataArray[currentIndex] = value;
		nextIndex[currentIndex] = topOfStack[stack];
		topOfStack[stack] = currentIndex;

	}

	public int pop(int stack)
	{
		if(stack < 0 || stack >= topOfStack.length || topOfStack[stack] < 0)
		{
			throw new IndexOutOfBoundsException();
		}

		currentIndex = topOfStack[stack];
		int value = dataArray[currentIndex];
		topOfStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;

		return value;
	}
}






