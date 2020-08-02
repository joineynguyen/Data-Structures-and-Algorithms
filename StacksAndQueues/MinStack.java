//Joiney Nguyen
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
class MinStack 
{
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) 
    {
        if(minStack.isEmpty() || x < minStack.peek())
        {
            minStack.push(x);
        }

        stack.push(x);
    }
    
    public void pop() 
    {
        if(minStack.peek() == stack.peek())
        {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() 
    {
        return stack.peek();
    }
    
    public int getMin() 
    {
        return minStack.peek();
    }
}
