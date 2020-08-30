package newPackage;

public class Main 
{
    public static void main(String[] args) 
    {
        //we automate a blackjack game of 4 players, excluding dealer, for 3 rounds.
        BlackJackAutomater myGame = new BlackJackAutomater(4, 3);
        myGame.playBlackJack();
     
    }
}
