package newPackage;

public class Card 
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
