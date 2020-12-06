/*
Joiney Nguyen
You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

*/

class Solution 
{
    public String interpret(String command) 
    {
        StringBuilder total = new StringBuilder();
        StringBuilder current = new StringBuilder();
        
        for(int i = 0; i < command.length(); i++)
        {
            current.append(command.charAt(i));
            
            if(current.toString().contains("G"))
            {
                total.append("G");
                current = new StringBuilder();
            }
            else if(current.toString().contains("()"))
            {
                total.append("o");
                current = new StringBuilder();
            }
            else if(current.toString().contains("(al)"))
            {
                total.append("al");
                current = new StringBuilder();
            }
        }
        
        return total.toString();
    }
}
