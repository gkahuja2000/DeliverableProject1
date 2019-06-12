/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;//method called to store the size of grouping value
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<Card> showCards()
    {
        return cards;//this will return the group of cards array created by software.
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);//this method will shuffle the cards. this method is called with collection keyword 
        //which is called above by java.util inbuilt package
    }
    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;//this method will retun size. We used this method because our size variable was private 
        // in order to return its value we need to call get method.
    }
    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize; //this method will set size.We used this method because our size variable was private 
        // in order to reset its value we need to call set method.
    }
    
}//end class

