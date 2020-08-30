package newPackage;

import java.util.ArrayList;
import java.util.Collections;

public class Deck 
{
	final int maxSuitValue = 3;
    final int maxCardValue = 13;

    private ArrayList<Card> deck;
 
    Deck()
    {
        this.deck = new ArrayList<Card>();
        addNewSetOfCardsToDeck();

    }

    void addNewSetOfCardsToDeck()
    {
        for(int i = 0; i <= maxSuitValue; i ++)
        {
            for(int j = 1; j <= maxCardValue; j++)
            {
                    deck.add(new Card(i, j));
            }
        }
        
        shuffleDeck();
    }
    
    void shuffleDeck()
    {
        Collections.shuffle(deck);
    }
    
    Card getNextCard()
    {
       if(deck.size() < 1)
       {
           addNewSetOfCardsToDeck();
       }
        
        Card currentCard = deck.get(deck.size() - 1);
        
        deck.remove(deck.size() - 1);
        
        return currentCard;
        
    }
       
    int getDeckSize()
    {
        return deck.size();
    }
}
