package newPackage;

public class BlackJackHand extends Hand
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
