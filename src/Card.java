public class Card {
    String suit;
    int value;

    Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    Card(String suit, int value, String face) {
        this.suit = suit;
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
