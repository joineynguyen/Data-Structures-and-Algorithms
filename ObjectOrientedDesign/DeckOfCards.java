
/*
    Joiney Nguyen

    Design the data structures for a generic deck of cards. Explain how you would
    subclass the data structures to implement blackjack.

*/

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author joineynguyen
 */

//automates the whole black jack game from player and dealer actions to dealing and handling the cards
class BlackJackAutomater
{
    //initiate deck of cards and dealer hand
    int numOfPlayers;
    int numOfRounds;
    BlackJackHand[] playerHand;
    BlackJackHand dealerHand = new BlackJackHand();
    Deck deck = new Deck();
    
    //initate number of players' hand excluding dealer
    BlackJackAutomater(int numOfPlayers, int numOfRounds)
    { 
        this.numOfPlayers = numOfPlayers;
        this.numOfRounds = numOfRounds;
        
        playerHand = new BlackJackHand[numOfPlayers];
 
        for(int i = 0; i < numOfPlayers; i++)
        {
            playerHand[i] = new BlackJackHand();
            playerHand[i].setName("Player " + (i + 1));
        }
               
        dealerHand.setName("Dealer");
        
        
    }
    //loops the game for how many rounds user wishes to automate the game for
    void playBlackJack()
    {
        int gamesPlayed = 0;

        while(gamesPlayed < numOfRounds)
        {
            dealInitialCards();
            playersTurn();
            dealerTurn();
            calculateAndPrintWinners();
            clearHands();

            System.out.println("\n---------------------------------");

            gamesPlayed += 1;
        }
    }
   
   
    //deal 2 cards to dealer and players in beginning of round
    void dealInitialCards()
    {
        dealerHand.addCardToHand(deck.getNextCard());
        dealerHand.addCardToHand(deck.getNextCard());
        
        for(int i = 0; i < numOfPlayers; i++)
        {
            playerHand[i].addCardToHand(deck.getNextCard());
            playerHand[i].addCardToHand(deck.getNextCard());
            
        }
    }
    
    void hit(Hand currentHand)
    {
        currentHand.addCardToHand(deck.getNextCard());
    }
    
    //let players play and get save their score by the end of their turn
    void playersTurn()
    {
      
        for(int i = 0; i < numOfPlayers; i++)
        {
            //keeps looping current player's turn until they bust or stand or win
            while(true)
            {
                int currentPlayerScore = playerHand[i].getScore();
                playerHand[i].printCardsInHand();
                System.out.println("Score: " + currentPlayerScore + "\n");
                
                if(currentPlayerScore == 21)
                {
                    break;
                }
                else if(currentPlayerScore > 21)
                {
                    break;
                }
                
                //randomizes player's action: number 0 for stand or 1 for hit
                int randomChoice = (int) (Math.random() * 2) + 0;
                
                if(randomChoice == 0)
                {
                    break;
                }
                else 
                {
                    hit(playerHand[i]);
                    System.out.println(playerHand[i].getName() + " hits!\n");
                }
                     
            }
        }
    }
    
    //let dealer play and get save their score at the end of their turn
    void dealerTurn()
    {
        
        while(true)
        {
            int dealerScore = dealerHand.getScore();
            dealerHand.printCardsInHand();
            System.out.println("Score: " + dealerScore + "\n");
            
            //if dealer gets blackjack, we check to see if other players have blackjack as well to decide on a tie
            if(dealerScore == 21)
            {
                break;
            }
            else if(dealerScore > 21)
            {
                break;
            }
            
            //randomizes dealer's action: number 0 for stand or 1 for hit
             int randomChoice = (int) (Math.random() * 2) + 0;

             if(randomChoice == 0)
             {
                 break;
             }
             else
             {
                 hit(dealerHand);
                 System.out.println(dealerHand.getName() + " hits!\n");
             }
        }
            
    }
    
    
    //calculate players' hands and compare to dealer's
    void calculateAndPrintWinners()
    {
        ArrayList<BlackJackHand> playersGotBlackJack = new ArrayList<BlackJackHand>();
        ArrayList<BlackJackHand> playersDidNotBust = new ArrayList<BlackJackHand>();
        ArrayList<BlackJackHand> playersBust = new ArrayList<BlackJackHand>();
        
        //place players' scores in potential winning or losing lists
        for(int i = 0; i < numOfPlayers; i++)
        {
            int currentPlayerScore = playerHand[i].getScore();
            
            if(currentPlayerScore == 21)
            {
                playersGotBlackJack.add(playerHand[i]);
            }
            else if(currentPlayerScore < 21)
            {
                playersDidNotBust.add(playerHand[i]);
            }
            else if(currentPlayerScore > 21)
            {
                playersBust.add(playerHand[i]);
            }
        }
        
       //displays players who busts, first,
       for(int i = 0; i < playersBust.size(); i++)
       {
           System.out.println(playersBust.get(i).getName() + " bust!");
       }
        
        int dealerScore = dealerHand.getScore();
        
        //if dealer has black jack
        if(dealerScore == 21)
        {
            //any player with blackjack while dealer has blackjack results in tie
            if(playersGotBlackJack.size() > 0)
            {
                for(int i = 0; i < playersGotBlackJack.size(); i++)
                {
                    System.out.println("Dealer tied with " + playersGotBlackJack.get(i).getName());
                }
            }
            
            //dealer beats any player that does not have blackjack
            if(playersDidNotBust.size() > 0)
            {
                for(int i = 0; i < playersDidNotBust.size(); i++)
                {
                    System.out.println("Dealer beats " + playersDidNotBust.get(i).getName());
                }
            }
        
        }
        
        //if dealer busts, every player that did not bust wins
        else if(dealerScore > 21)
        {
            if(playersGotBlackJack.size() > 0)
            {
                for(int i = 0; i < playersGotBlackJack.size(); i++)
                {
                    System.out.println(playersGotBlackJack.get(i).getName() + " beats dealer!");
                }
                
            }
            
            if(playersDidNotBust.size() > 0)
            {
                for(int i = 0; i < playersDidNotBust.size(); i++)
                {
                    System.out.println(playersDidNotBust.get(i).getName() + " beats dealer!");
                }
            }
        }
        
        //if dealer did not bust or get black jack... we compare it to players' hands for winners
        if(dealerScore < 21)
        {
            if(playersGotBlackJack.size() > 0)
            {
                for(int i = 0; i < playersGotBlackJack.size(); i++)
                {
                    System.out.println(playersGotBlackJack.get(i).getName() + " beats dealer!");
                }
            }
            
            if(playersDidNotBust.size() > 0)
            {
                for(int i = 0; i < playersDidNotBust.size(); i++)
                {
                    int currentPlayerScore = playersDidNotBust.get(i).getScore();
                    
                    if(dealerScore > currentPlayerScore)
                    {
                        System.out.println("Dealer beats " + playersDidNotBust.get(i).getName());
                    }
                    else if(dealerScore < currentPlayerScore)
                    {
                        System.out.println(playersDidNotBust.get(i).getName() + " beats dealer!");
                    }
                }
            }
         
        }
    }   
    
    void clearHands()
    {
        dealerHand.clearHand();
        
        for(int i = 0; i < numOfPlayers; i++)
        {
            playerHand[i].clearHand();
        }
        
    }
    
   
   
}

//blackjack hand is different from card hand because of how cards J,Q,K have value of 10 and Ace have value of either 1 or 11
class BlackJackHand extends Hand
{
    
    @Override
    int getScore()
    {
        calculateHandValue();
        return this.score;
    }
    
    @Override
    void calculateHandValue()
    {
        int total = 0;
        
        for(int i = 0; i < cardsInHand.size(); i++)
        {
            int currentCardValue = cardsInHand.get(i).getCardNumber();
            
            if(currentCardValue == 1)
            {
               
                if((total + 11) <= 21)
                {
                    currentCardValue = 11;
                }
                else
                {
                    currentCardValue = 1;
                }
                
            }
            else if(currentCardValue == 11 || currentCardValue == 12 || 
                    currentCardValue == 13)
            {
                currentCardValue = 10;
            }
            
            
            
            total += currentCardValue;
        }
        
        this.score = total;
    }
    
}


class Hand
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


class Deck
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

class Card
{
    
    //0(spade), 1(club), 2(diamond), 3(heart)
    private int suitValue;
    
    //spade(0), club(1), diamond(2), heart(3) 
    private String suitName;
    
    //1,2,3,4,5,6,7,8,9,10,11,12,13
    private int cardNumber;
    
    //2,3,4,5,6,7,8,9,10,J,Q,K,A
    private String cardName;
    
    //Ex: 2 of Spade
    private String card;

    Card(Integer suitValue, Integer cardNumber)
    {
        this.suitValue = suitValue;
        this.suitName = convertToSuitName(suitValue);
        this.cardNumber = cardNumber;
        this.cardName = convertToCardName(cardNumber);
        this.card = cardName + " of " + suitName;

    }

    String convertToCardName(Integer cardValue)
    {
        String cardName = null;

        if(cardValue == 1)
        {
            cardName = "A";
            return cardName;
        }

        else if(cardValue > 1 && cardValue < 11)
        {
            return cardValue.toString();
        }
        else
        {
             switch(cardValue) 
            {

              case 11:
                cardName = "J";
                break;
              case 12:
                cardName = "Q";
                break;
              case 13:
                cardName = "K";
                break;

            }
        }
       

        return cardName;
    }

    String convertToSuitName(Integer suitValue)
    {
        String suitName = null;

        switch(suitValue)
        {
            case 0:
                suitName = "Spade";
                break;
            case 1:
                suitName = "Club";
                break;
            case 2:
                suitName = "Diamond";
                break;
            case 3:
                suitName = "Heart";
                break;
        }

        return suitName;
    }

    String getCard()
    {
        return this.card;
    }

    int getSuitValue()
    {
        return this.suitValue;
    }

    int getCardNumber()
    {
        return this.cardNumber;
    }

}

public class Main 
{
    
    public static void main(String[] args) 
    {
        //we automate a blackjack game of 4 players, excluding dealer, for 3 rounds.
        BlackJackAutomater myGame = new BlackJackAutomater(4, 3);
        myGame.playBlackJack();
     
    }
       
}
