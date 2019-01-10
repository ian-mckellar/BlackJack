public class BlackJack {
    public static void main(String[] args) {
        Deck testDeck = new Deck();
        testDeck.fillDeck();
        for (Card card : testDeck.getCardArrayList()) {
            System.out.println(card.toString());
        }
    }
}
