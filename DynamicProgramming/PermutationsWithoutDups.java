/*
Joiney Nguyen

Write a method to compute all permutations of a string of unique
characters.
*/

import java.util.ArrayList;

public class MyClass 
{
    static ArrayList<String> getPerms(String s)
    {
        if(s == null)
        {
            return null;
        }
        
        ArrayList<String> perms = new ArrayList<>();
        
        if(s.length() == 0)
        {
            perms.add("");
            return perms;
        }
        
        String first = s.substring(0,1);
        String remainder = s.substring(1);
        
        ArrayList<String> remainderPerms = getPerms(remainder);
        
        for(String word : remainderPerms)
        {
            for(int i = 0; i <= word.length(); i++)
            {
                perms.add(insertLetterAt(word, i, first));
            }
        }
        
        return perms;
    }
    
    static String insertLetterAt(String word, int index, String letter)
    {
        String start = word.substring(0,index);
        String end = word.substring(index);
        String result = start + letter + end;
        return result;
    }
    
    public static void main(String args[]) 
    {
      ArrayList<String> list = getPerms("cat");
      
      for(String s : list)
      {
          System.out.println(s);
      }
    }
}
