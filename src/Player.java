package blackJack;

import java.util.ArrayList;

public class Player {
	
    //private Card[] hand = new Card[10];
    private ArrayList<Card> hand = new ArrayList<Card>();

    /**
     * The Player constructor
     */
    public Player(String name) {
        this.emptyHand();
    }

    /**
     * This method resets the player's hand
     */
    public void emptyHand() {
        this.hand.clear();
    }

    /**
     * This method adds a card to player's hand
     */
    public boolean addCardToHand(Card card) {
        this.hand.add(card);
        
        return (this.getPlayersHandTotal() <= 21);
    }

    /**
     * This method gets the sum of cards in player's hand.
     */
    public int getPlayersHandTotal() {
        int handSum = 0;
        int cardNum;
        int acesNum = 0;

        for (Card c : this.hand) {
            cardNum = c.getValue(); // this method is from the card class
            if (cardNum == 11)
            { // Ace
                acesNum++;
                handSum += 11;
            }
            else if (cardNum >= 10) 
                handSum += 10;
            else
                handSum += cardNum;
        }

        while(handSum > 21 && acesNum > 0) {
            handSum -= 10;
            acesNum--;
        }

        return handSum;
    }
    
    public ArrayList<Card> getHand(){
    	return this.hand;
    }
}