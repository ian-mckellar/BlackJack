import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cardArrayList = new ArrayList<>();

    // Creates all of the number cards for each of the suits

    public void fillDeck() {
        for (int i = 2; i <= 9; i++) {
            cardArrayList.add(new Card("spade", i));
            cardArrayList.add(new Card("heart", i));
            cardArrayList.add(new Card("diamond", i));
            cardArrayList.add(new Card("club", i));
        }

        cardArrayList.add(new Card("spade", 10, "jack"));
        cardArrayList.add(new Card("spade", 10, "king"));
        cardArrayList.add(new Card("spade", 10, "queen"));

        cardArrayList.add(new Card("heart", 10, "jack"));
        cardArrayList.add(new Card("heart", 10, "king"));
        cardArrayList.add(new Card("heart", 10, "queen"));

        cardArrayList.add(new Card("diamond", 10, "jack"));
        cardArrayList.add(new Card("diamond", 10, "king"));
        cardArrayList.add(new Card("diamond", 10, "queen"));

        cardArrayList.add(new Card("club", 10, "jack"));
        cardArrayList.add(new Card("club", 10, "king"));
        cardArrayList.add(new Card("club", 10, "queen"));
    }


}
