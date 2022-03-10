import java.util.Random;

public class CardGame {
    public static void main(String[] args) {
        Card[] player1 = new Card[2];
        Card[] player2 = new Card[2];
        Card winCard;

        System.out.println("카드를 돌렸습니다.");
        player1[0] = selcetCard();
        player1[1] = selcetCard();
        player2[0] = selcetCard();
        player2[1] = selcetCard();

        System.out.println("Player 1의 카드는 " + player1[0].getSuit().display + player1[0].getNumber().value +" , " +
                player1[1].getSuit().display + player1[1].getNumber().value + " 입니다");
        System.out.println("Player 2의 카드는 " + player2[0].getSuit().display + player2[0].getNumber().value +" , " +
                player2[1].getSuit().display + player2[1].getNumber().value + " 입니다");

        player1[0] = compare(player1[0],player1[1]);
        player2[0] = compare(player2[0],player2[1]);
        winCard = compare(player1[0],player2[0]);

        System.out.println("가장 높은 카드인 " + winCard.getSuit().display + winCard.getNumber().value + "를 뽑은 Player가 승리했습니다!!");

    }

    // 카드 비교 메서드
    static Card compare(Card card1, Card card2) {
        if (card1.getNumber().value > card2.getNumber().value)
            return card1;
        else if (card1.getNumber().value < card2.getNumber().value)
            return card2;
        else {
            if (card1.getSuit().order > card2.getSuit().order)
                return card1;
            else if (card1.getSuit().order < card2.getSuit().order)
                return card2;
        }

        System.out.println("여기까지 오면 안되지");
        return null;
    }

    // 카드 배분
    static Card selcetCard() {
        Suit suit = new Suit();
        Number number = new Number();

        return new Card(suit.getSuit(), number.getNumber());
    }
}

// spades, hearts, diamonds, clubs
class Suit {
    String display;
    int order;

    public Suit getSuit() {
        Random random = new Random();
        order = random.nextInt(4)+1;
        switch (order) {
            case 1:
                display = "spades";
                break;
            case 2:
                display = "hearts";
                break;
            case 3:
                display = "diamonds";
                break;
            case 4:
                display = "clubs";
                break;
        }
        return this;
    }
}

// Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
class Number {
    int value;

    public Number getNumber() {
        Random random = new Random();
        String result;
        value = random.nextInt(13)+1;
        return this;
    }
}

class Card {
    private Suit suit;
    private Number number;

    public Card(Suit suit, Number number) {
        this.suit = suit;
        this.number = number;
    }

//    public static Card joker() {
//        return ???
//    }

    public Suit getSuit() {
        return this.suit;
    }
    public Number getNumber() {
        return this.number;
    }
}