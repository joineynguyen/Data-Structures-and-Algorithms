/*
Joiney Nguyen

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
*/


import java.util.List;

public class Solution
{
    class Trie
    {
        final int ALPHABET_NUM = 26;
        
        class TrieNode
        {
            TrieNode[] children;
            boolean endOfWord;
            String word;
            
            public TrieNode()
            {
                 children = new TrieNode[ALPHABET_NUM];
                 endOfWord = false;
                 word = "";
                
                for(int i = 0; i < ALPHABET_NUM; i++)
                {
                    children[i] = null;
                }
            }
        }
        
        TrieNode root;
        
        public Trie()
        {
            root = new TrieNode();
        }
        
        public void insert(String word)
        {
            TrieNode current = root;
            
            for(int i = 0; i < word.length(); i++)
            {
                int index = word.charAt(i) - 'a';
                if(current.children[index] == null)
                {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.endOfWord = true;
            current.word = word;
        }
        
        public String getRoot(String word)
        {
            TrieNode current = root;
            
            for(int i = 0; i < word.length(); i++)
            {
                int index = word.charAt(i) - 'a';
                
                if(current.children[index] == null)
                {
                    break;
                }
                
                if(current.children[index].endOfWord == true)
                {
                    return current.children[index].word;
                }
                current = current.children[index];
            }
        
            return word;
        }
    
    }
    
  
    public String replaceWords(List<String> dictionary, String sentence) 
    {
        Trie t = new Trie();
        
        for(String s : dictionary)
        {
            t.insert(s);
        }
        
        String[] words = sentence.split(" ");
        
        for(int i = 0; i < words.length; i++)
        {
            String currentWord = words[i];
            words[i] = t.getRoot(currentWord);
        }
        
        sentence = String.join(" ", words);
        
        return sentence;
    }
    
    
    public static void main(String[] args)
    {
        
    }
}
