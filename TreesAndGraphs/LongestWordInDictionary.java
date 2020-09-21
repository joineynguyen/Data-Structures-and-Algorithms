/*
Joiney Nguyen

Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input: 
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation: 
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
*/

package prac;

public class Trie
{
	final int NUM_ALPHABET = 26;

	class TrieNode
	{
		TrieNode[] children;
		boolean endOfWord;
		String word;

		public TrieNode()
		{
			children = new TrieNode[NUM_ALPHABET];
			endOfWord = false;
			word = "";

			for(int i = 0; i < NUM_ALPHABET; i++)
			{
				children[i] = null;
			}
		}
	}

	TrieNode root;
	String longestWord;

	public Trie()
	{
		root = new TrieNode();
		longestWord = "";
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

	public String getLongestWord()
	{
		dfs(root);
		return longestWord;
	}

	public void dfs(TrieNode current)
	{
		if(current == null)
		{
			return;
		}

		if(current.word.length() > longestWord.length())
		{
			longestWord = current.word;
		}
	  	else if(current.word.length() == longestWord.length() && current.word.compareTo(longestWord) < 0)
        {
            longestWord = current.word;
        }


		for(TrieNode child : current.children)
		{
			dfs(child);
		}
	}

	public static void main(String[] args)
	{
		String[] words = {"one", "two", "three"};

		Trie t = new Trie();

		for(String word : words)
		{
			t.insert(word);
		}

		System.out.println(t.getLongestWord());
	}



}
