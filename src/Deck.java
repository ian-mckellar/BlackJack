import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cardArrayList = new ArrayList<>();

    /**
     * Fills cardArrayList with one of each card
     */
    public void fillDeck() {
        for (int i = 2; i <= 9; i++) {
            cardArrayList.add(new Card("spade", i));
            cardArrayList.add(new Card("heart", i));
            cardArrayList.add(new Card("diamond", i));
            cardArrayList.add(new Card("club", i));
        }

        cardArrayList.add(new Card("spade", "jack"));
        cardArrayList.add(new Card("spade", "king"));
        cardArrayList.add(new Card("spade", "queen"));

        cardArrayList.add(new Card("heart", "jack"));
        cardArrayList.add(new Card("heart", "king"));
        cardArrayList.add(new Card("heart", "queen"));

        cardArrayList.add(new Card("diamond", "jack"));
        cardArrayList.add(new Card("diamond", "king"));
        cardArrayList.add(new Card("diamond", "queen"));

        cardArrayList.add(new Card("club", "jack"));
        cardArrayList.add(new Card("club", "king"));
        cardArrayList.add(new Card("club", "queen"));
    }


}
