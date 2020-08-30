package newPackage;

import java.util.ArrayList;

public class BlackJackAutomater 
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
