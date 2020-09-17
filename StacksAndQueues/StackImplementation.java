/*
Joiney Nguyen

Stack implementation
*/


package prac;

public class Stack
{
    int top = -1;
    int[] array;
    int maxSize;
    
    public Stack(int capacity)
    {
        maxSize = capacity;
        array = new int[capacity];
    }
    
    public boolean isFull()
    {
        return top == maxSize - 1 ;
    }
    
    public boolean isEmpty()
    {
        return top == -1;
    }
    
    public void push(int num)
    {
        if(isFull())
        {
            System.out.println("Can't push into full stack.");
            return;
        }
        
        array[++top] = num;
    }
    
    public Integer pop()
    {
        if(isEmpty())
        {
            System.out.println("Can't pop empty stack.");
            return null;
        }
        
        return array[top--];
    }
    
    public static void main(String[] args)
    {
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
