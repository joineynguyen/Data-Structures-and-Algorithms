/*Joiney Nguyen

Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and isEmpty. */

import java.util.*;

public class sortStack
{
   
   public static Stack sorter(Stack stack1)
   {
        //stack 2 used as temp stack for sorting
        Stack<Integer> stack2 = new Stack<Integer>();

        while(!stack1.isEmpty())
        {
            int temp = (Integer)stack1.pop();

            //keeps popping items in stack 2 to stack 1 until temp variable is the next in sorting order of stack 2
            //sorts min number at bottom of stack 2
            while(!stack2.isEmpty() && temp > stack2.peek())
            {
                stack1.push(stack2.pop());
            }

            stack2.push(temp);

        }

        //pop elements from sorted stack 2 into stack 1 to make min element on top
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

        return stack1;

   }
   

   


   public static void main(String[] args)
   {
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(30);
        stack1.push(23);
        stack1.push(11);
        stack1.push(49);
        stack1.push(5);
        stack1.push(77);
        stack1.push(43);
        stack1.push(52);
        stack1.push(14);

        stack1 = sorter(stack1);

        System.out.println(Arrays.toString(stack1.toArray()));



   }

}
