package newPackage;

import java.util.ArrayList;

public class Hand 
{
String name;
    
    ArrayList<Card> cardsInHand;
    
    int score;

    Hand()
    {
        cardsInHand = new ArrayList<Card>();
    }
    
    void addCardToHand(Card card)
    {
        cardsInHand.add(card);
    }
      
    void clearHand()
    {
        cardsInHand.clear();
    }
    
    void calculateHandValue()
    {
        int total = 0;
        
        for(int i = 0; i < cardsInHand.size(); i++)
        {
            int currentCardValue = cardsInHand.get(i).getCardNumber();
            
            total += currentCardValue;
        }
        
        this.score = total;
    }
    
    void printCardsInHand()
    {
        System.out.println(this.getName() + "'s hand:");
        for(int i = 0; i < cardsInHand.size(); i++)
        {
            System.out.println(cardsInHand.get(i).getCard());
        }
    }
    
    void setName(String name)
    {
        this.name = name;
    }
    
    String getName()
    {
        return name;
    }
    
    int getScore()
    {
        calculateHandValue();
        return score;
    }
    
    
}
