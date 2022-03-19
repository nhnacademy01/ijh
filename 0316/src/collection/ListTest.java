package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {


    }
}

class CardGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("게임 참여자 수 > ");
        int numHands = s.nextInt();
        System.out.print("참여자 당 카드 수 > ");
        int cardsPerHand = s.nextInt();

        String[] suit = new String[] {"♠", "♥", "♦", "♣"};
        String[] rank = new String[] {
                "Ace", "2", "3", "4",
                "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King" };
        List<String> deck = new ArrayList<String>();
        for (int i = 0; i < suit.length; i++)
            for (int j = 0; j < rank.length; j++)
                deck.add(suit[i] + " " + rank[j]);

        Collections.shuffle(deck);

        if (numHands * cardsPerHand > deck.size()) {
            System.out.println("Not enough cards.");
            return;
        }
        for (int i = 0; i < numHands; i++)
            System.out.println(dealHand(deck, cardsPerHand));
    }

    public static <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }
}
