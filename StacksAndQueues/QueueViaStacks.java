/* Joiney Nguyen

Implement a MyQueue class which implements a queue using two stacks. */

import java.util.*;

public class myQue
{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void add(int value)
    {
        stack1.push(value);
    }

    public Integer poll()
    {
        if(stack1.isEmpty())
        {
            return null;
        }

        while(!stack1.isEmpty())
        {
            int item = stack1.pop();
            stack2.push(item);
        }

        int itemToPop = stack2.pop();
        
        while(!stack2.isEmpty())
        {
            int item = stack2.pop();
            stack1.push(item);
        }

        return itemToPop;
    }

    public Integer peek()
    {
        if(stack1.isEmpty())
        {
            return null;
        }

        while(!stack1.isEmpty())
        {
            int item = stack1.pop();
            stack2.push(item);
        }

        int itemToPeek = stack2.peek();
        
        while(!stack2.isEmpty())
        {
            int item = stack2.pop();
            stack1.push(item);
        }

        return itemToPeek;
    }

    public static void main(String[] args)
    {
        myQue m = new myQue();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);

        System.out.println(m.peek());
        System.out.println(m.poll());
        System.out.println(m.peek());
        System.out.println(m.poll());

    }


}



