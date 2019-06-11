/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author warriors 11-06-2019
 */
public  class Card 
{
        private int position;
        private int suit;
        private int value;
        private static String[] positions = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        private static String[] suits = {"Diamonds","Clubs","Hearts","Spades"};
        
        Card(int suit, int values){
        this.position = values;
        this.suit = suit;
        }
        public String toString(){
        return positions[position]+" of "+suits[suit];
        }

    public int getPosition() {
        return position;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        if(position>10){
            value=10;
        }
        else if(position==1){
          value = 11;
        }
        else{
          value = position;
        }
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
        
}

