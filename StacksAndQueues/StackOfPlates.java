//Joiney Nguyen
/*Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
(that is, pop ( ) should return the same values as it would if there were just a single stack).
import java.util.*; */

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

    public Integer popByStack(int stackNum)
    {
        if(stackNum > stackSet.size())
        {
            return null;
        }

        return (Integer)stackSet.get(stackNum - 1).pop();
    }

    public Stack getLastStack() 
    {
        if(stackSet.isEmpty())
        {
            return null;
        }

        return stackSet.get(stackSet.size() - 1);



    }

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
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(1);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(1);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.push(16);
        s.push(17);
        s.push(16);
        s.push(15);
        s.push(14);
        s.push(13);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }

}
