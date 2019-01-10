import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardArrayList = new ArrayList<>();

    /**
     * Fills cardArrayList with one of each card
     * D - Diamonds
     * C - Clubs
     * H - Hearts
     * S - Spades
     */
    public void fillDeck() {
        for (int i = 2; i <= 10; i++) { //change the max card# from 9 to 10 -Alex
            cardArrayList.add(new Card(i, "C", i + "D.png"));
            cardArrayList.add(new Card(i, "D", i + "C.png"));
            cardArrayList.add(new Card(i, "H", i + "H.png"));
            cardArrayList.add(new Card(i, "S", i + "S.png"));
        }

        cardArrayList.add(new Card("A", "C", "AC.png"));
        cardArrayList.add(new Card("A", "D", "AD.png"));
        cardArrayList.add(new Card("A", "H", "AH.png"));
        cardArrayList.add(new Card("A", "S", "AS.png"));

        cardArrayList.add(new Card("J", "C", "JC.png"));
        cardArrayList.add(new Card("J", "D", "JD.png"));
        cardArrayList.add(new Card("J", "H", "JH.png"));
        cardArrayList.add(new Card("J", "S", "JS.png"));

        cardArrayList.add(new Card("Q", "C", "QC.png"));
        cardArrayList.add(new Card("Q", "D", "QD.png"));
        cardArrayList.add(new Card("Q", "H", "QH.png"));
        cardArrayList.add(new Card("Q", "S", "QS.png"));

        cardArrayList.add(new Card("K", "C", "KC.png"));
        cardArrayList.add(new Card("K", "D", "KD.png"));
        cardArrayList.add(new Card("K", "H", "KH.png"));
        cardArrayList.add(new Card("K", "S", "KS.png"));
    }
    
    //------- Alex's Code Below -------
    /**
     * The location of the top card. All cards before this position are in use or
     * have been discarded. From this position on is the deck.
     */
    private int topCardLocation = 0;
    
    /**
     * Shuffles the deck
     */
    public void shuffleDeck() {
    	Collections.shuffle(cardArrayList);
    }
    
    /**
     * move the position of the top card
     * @return the top card
     */
    public Card drawCard() {
    	//if last card add new deck
    	if (topCardLocation == 52)
    		addNewDeck();
    	//move the location of the top of the deck
    	topCardLocation++;
    	//return the top card (-1 since the topCardLocation was moved)
    	return cardArrayList.get(topCardLocation - 1);
    }
    
    /**
     * Simulates adding a new deck
     */
    public void addNewDeck(){
    	shuffleDeck();
    	topCardLocation = 0;
    }
}
