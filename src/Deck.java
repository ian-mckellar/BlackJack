import java.util.ArrayList;

public class Deck {
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
            cardArrayList.add(new Card(i, "clubs", i + "_of_clubs.png"));
            cardArrayList.add(new Card(i, "diamonds", i + "_of_diamonds.png"));
            cardArrayList.add(new Card(i, "hearts", i + "_of_hearts.png"));
            cardArrayList.add(new Card(i, "spades", i + "_of_spades.png"));
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cardArrayList.add(new Card(faceValues[i], suits[j],
                        faceValues[i] + "_of_" + suits[j] + ".png"));
            }
        }
    }
}
