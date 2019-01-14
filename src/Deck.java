import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    /**
     * The location of the top card. All cards before this position are in use or
     * have been discarded. From this position on is the deck.
     */
    private int topCardLocation = 0;
    private ArrayList<Card> cardArrayList = new ArrayList<>();

    ArrayList<Card> getCardArrayList() {
        return cardArrayList;
    }

    /**
     * Fills cardArrayList with one of each card
     */
    public void fillDeck() {
        String[] faceValues = {"ace", "jack", "queen", "king"};
        String[] suits = {"clubs", "diamonds", "hearts", "spades"};
        for (int i = 2; i <= 10; i++) {
            cardArrayList.add(new Card(i, "clubs", "images/" + i + "_of_clubs.png"));
            cardArrayList.add(new Card(i, "diamonds", "images/" + i + "_of_diamonds.png"));
            cardArrayList.add(new Card(i, "hearts", "images/" + i + "_of_hearts.png"));
            cardArrayList.add(new Card(i, "spades", "images/" + i + "_of_spades.png"));
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cardArrayList.add(new Card(faceValues[i], suits[j],
                        "images/" + faceValues[i] + "_of_" + suits[j] + ".png"));
            }
        }
    }

    /**
     * Shuffles the deck
     */
    public void shuffleDeck() {
        topCardLocation = 0;
        Collections.shuffle(cardArrayList);
    }

    /**
     * move the position of the top card
     *
     * @return the top card
     */
    public Card drawCard() {
        //if last card add new deck
        if (topCardLocation == 52) {
            addNewDeck();
        }
        //move the location of the top of the deck
        topCardLocation++;
        //return the top card (-1 since the topCardLocation was moved)
        return cardArrayList.get(topCardLocation - 1);
    }

    /**
     * Simulates adding a new deck
     */
    public void addNewDeck() {
        shuffleDeck();
    }
}
