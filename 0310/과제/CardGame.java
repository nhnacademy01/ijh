public class CardGame {

}

// spades, hearts, diamonds, clubs
class Suit {
    String display;
    int order;
}

// Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
class Number {
    int value;
}

class Card {
    private Suit suit;
    private Number number;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

    public static Card joker() {
        return ???
    }
}