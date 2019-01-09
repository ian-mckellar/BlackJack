import java.util.ArrayList;

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
        for (int i = 2; i <= 9; i++) {
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
}
