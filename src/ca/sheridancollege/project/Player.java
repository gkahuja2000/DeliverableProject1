/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;
import java.util.*;
/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author warriors 11-06-2019
 */
public class Player 
{

    private ArrayList<Card> deck;

    Player() {
        deck = new ArrayList<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck.add(new Card(i, j));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        Card temp;
        for (int i = 0; i < 200; i++) {
            int index1 = random.nextInt(deck.size() - 1);
            int index2 = random.nextInt(deck.size() - 1);
            temp = deck.get(index2);
            deck.set(index2, deck.get(index1));
            deck.set(index1, temp);
        }
    }

    public Card drawCard() {
        return deck.remove(0);
    }
}


