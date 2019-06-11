/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author warriors 11-06-2019
 */
public class Game {
      ArrayList<Card> hand;
      private int handvalue =0;
      private Card[] aHand;
      private int AceCounter;
          
     Game(Player player){
     hand = new ArrayList<>();
     aHand = new Card[]{};
     int AceCounter =0;
     for( int i =0; i<2 ; i++){
       hand.add(player.drawCard());
     }
     aHand = hand.toArray(aHand);
     for(int i=0; i<aHand.length; i++){
       handvalue += aHand[i].getValue();
       if(aHand[i].getValue()==11){
         AceCounter++;
       }
       while(AceCounter>0 && handvalue>21){
         handvalue = handvalue-10;
         AceCounter--;
       }
     }
}
     public void showFirstCard(){
         Card[] firstCard = new Card[]{};
         firstCard = hand.toArray(firstCard);
         System.out.println("["+firstCard[0]+"]");
     }
     public void Hit(Player player){
     
     hand.add(player.drawCard());
     aHand = hand.toArray(aHand);
     handvalue =0;
     for(int i=0;i<aHand.length;i++){
      handvalue += aHand[i].getValue();
      if(aHand[i].getValue()==11){
      AceCounter++;
      }
      while(AceCounter>0 && handvalue>21){
           handvalue-=10;
           AceCounter--;
      }
     }
}
     public boolean wantsToHit(){
        if(handvalue<17){
        return true;
        }
        return false;
     }
     public boolean hasBlackJack(){
     if(hand.size()==2 && handvalue == 21){
         System.out.println("You have a blackjack");
         return true;
     }
     return false;
     }
     public void showHand(){
         System.out.println(hand);
     }

    public int getHandvalue() {
        return handvalue;
    }
     public boolean busted(int handvalue){
       if(handvalue>21){
           System.out.println("You busted buddy!");
           return true;
     }
       return false;
    }
     public int takeTurn(Player player){
      while(wantsToHit()){
          System.out.println("You hit");
          Hit(player);
          if(busted(handvalue)){
              break;
              }        
      } 
      if(handvalue<=21){
          System.out.println("You stand.");       
      }
      return handvalue;
     }

}
