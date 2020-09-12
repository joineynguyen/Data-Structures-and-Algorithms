/*Joiney Nguyen

Reverse Linked list
*/

package prac;

class ListNode
{
    ListNode next;
    int value;
    
    public ListNode(int value)
    {
        this.value = value;
    }
}

public class LinkedList
{
    ListNode head;
    
    public void add(int value)
    {
        ListNode new_node = new ListNode(value);
        
        if(head == null)
        {
            head = new_node;
            return;
        }
        else
        {
            ListNode current = head;
            
            while(current.next != null)
            {
                current = current.next;
            }
            
            current.next = new_node;
        }
        
    }
    
    public void print(ListNode head)
    {
        if(head == null)
        {
            return;
        }
        else
        {
            ListNode current = head;
            
            while(current != null)
            {
                System.out.print(current.value + " ");
                current = current.next;
            }
        }
    }
    
    //Iterates throgh list and points each node's pointer to point behind them with the helper nodes: prev, current, and next
    public ListNode reverseList(ListNode head)
    {
        if(head == null)
        {
            return null;
        }
        
        ListNode prev, current, next;
        current = head;
        prev = next = null;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        head = prev;
        return head;
    }
    
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        list.head = list.reverseList(list.head);
        list.print(list.head);
        
        
    }
}
