//Joiney Nguyen
/* Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
(that is, pop ( ) should return the same values as it would if there were just a single stack).
import java.util.*; 
FOLLOW UP
Implement a function popAt (int index) which performs a pop operation on a specific sub-stack. */

import java.util.*;

public class SetOfStacks
{
    ArrayList<Stack> stackSet = new ArrayList<Stack>();
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> tempStack = new Stack<Integer>(); //for last stack

    int maxSize = 5; //to keep count of max 5 ints per stack
    
    public void push(int value)
    {
        //when stack full, add stack to arraylist and create new stack to push to arraylist
        if(stackSet.size() == 0 || stack.size() == maxSize)
        {
            newStackPush(value);
            return;
        }
        
        stack.push(value);
    }
    
    //pop item if only arraylist is not empty and then delete the stack after popping if stack becomes empty
    public Integer pop()
    {
        if(stackSet.size() == 0)
        {
            return null;
        }

        tempStack = getLastStack();

        int itemToPop = tempStack.pop();

        if(tempStack.size() == 0)
        {
            stackSet.remove(stackSet.size() - 1);
        }

        return itemToPop;
       
    }

    //pop the chosen stack only if stack num is larger than 0 less than actual arraylist size
    public Integer popByStack(int stackNum)
    {
        if(stackNum > stackSet.size() || stackNum == 0)
        {
            return null;
        }

        return (Integer)stackSet.get(stackNum - 1).pop();
    }
    
    //use get method to return last stack in arraylist
    public Stack getLastStack() 
    {
        if(stackSet.isEmpty())
        {
            return null;
        }

        return stackSet.get(stackSet.size() - 1);



    }

    //make new stack to push value in and then add new stack to arraylist
    public void newStackPush(int value)
    {
        stack = new Stack<Integer>();
        stack.push(value);
        stackSet.add(stack);
    }
    
    public static void main(String[] args)
    {
        SetOfStacks s = new SetOfStacks();
        
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);
        
        System.out.println(Arrays.toString(s.stackSet.toArray()));
        System.out.println(s.popByStack(3));
     
    }

}
