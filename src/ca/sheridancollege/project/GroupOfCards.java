/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.*;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author warriors 11-06-2019
 */
public class GroupOfCards 
{
private static int cash;
private static int bet;
private static int aceCounter;
private static ArrayList<Card> hand;
private static int handvalue;
private static String name;
public static void main(String[] args){
    System.out.println("Hello! \n What is your name?");
    Scanner sc = new Scanner(System.in);
    name = sc.nextLine();
    System.out.println("Hello, "+name+", lets have some fun with BlackJack!");
    System.out.println("How much cash do you want to start with?");
    Scanner money = new Scanner(System.in);
    cash = money.nextInt();
    System.out.println("You start with cash: "+cash);
    while(cash>0){
        Player player = new Player();
        player.shuffle();
        aceCounter=0;
        Game game = new Game(player);
        List<Card> hand = new ArrayList<>();
        hand.add(player.drawCard());
        hand.add(player.drawCard());
        System.out.println("How much would you like to bet?");
        bet=Bet(cash);
        System.out.println("Cash:"+(cash-bet));
        System.out.println("Money on the table:"+bet);
        System.out.println("Here is your hand: "+hand);
        int handvalue = cal(hand);
        System.out.println("Other player is  showing: ");
        game.showFirstCard();
        if(hasBlackJack(handvalue) && game.hasBlackJack())
        {
            Push();
        }
        else if(hasBlackJack(handvalue))
        {
            System.out.println("You have BlackJack!");
            System.out.println("You win 2x your money back!");
            cash=cash+bet;
            Win();
        }
        else if(game.hasBlackJack())
        {
            System.out.println("Here is the other's hand:");
            game.showHand();
            Lose();
        }
        else
        {
            if(2*bet<cash)
            {
                System.out.println("Would you like to double down?");
                Scanner doubledown = new Scanner(System.in);
                String doubled = doubledown.nextLine();
                while(!isyesorno(doubled))
                {
                    System.out.println("Please enter yes or no.");
                    doubled = doubledown.nextLine();
                }
                if(doubled.equals("yes"))
                {
                    System.out.println("You have opted to double down!");
                    bet=2*bet;
                    System.out.println("Cash:"+(cash-bet));
                    System.out.println("Money on the table:"+bet);
                }
            }
            System.out.println("Would you like to hit or stand?");
            Scanner hitorstand = new Scanner(System.in);
            String hitter = hitorstand.nextLine();
            while(!isHitorStand(hitter))
            {
                System.out.println("Please enter 'hit' or 'stand'.");
                hitter = hitorstand.nextLine();
            }
            while(hitter.equals("hit"))
            {
                Hit(player, hand);
                System.out.println("Your hand is now:");
                System.out.println(hand);
                handvalue = cal(hand);
                if(bust(handvalue))
                {
                    Lose();
                    break;
                }
                if(handvalue<=21 && hand.size()==5)
                {
                    fivecardtrick();
                    break;
                }
                System.out.println("Would you like to hit or stand?");
                hitter = hitorstand.nextLine();
            }
            if(hitter.equals("stand"))
            {
                int dealerhand = game.takeTurn(player); 
                System.out.println("");
                System.out.println("Here is the other's hand:");
                game.showHand();
                if(dealerhand>21)
                {
                    Win();
                }
                else
                {
                    int you = 21-handvalue;
                    int deal = 21-dealerhand;
                    if(you==deal)
                    {
                        Push();
                    }
                    if(you<deal)
                    {
                        Win();
                    }
                    if(deal<you)
                    {
                        Lose();
                    }
                }
            }
        }
    System.out.println("Would you like to play again?");
    Scanner yesorno = new Scanner(System.in);
    String answer = yesorno.nextLine();
    while(!isyesorno(answer))
            {
                System.out.println("Please answer yes or no.");
                answer = yesorno.nextLine();
            }
    if(answer.equals("no"))
    {
        break;
    }
}
    System.out.println("Your cash is: "+cash);
   if(cash==0)
    {
        System.out.println("You ran out of cash!");
    }
    else
    {
        System.out.println("Enjoy your winnings, "+name+"!");
    }
}
public static boolean hasBlackJack(int handValue)
{
    if(handValue==21)
    {
        return true;
    }
    return false;
}
public static int cal(List<Card> hand)
{
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    int handvalue=0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            aceCounter++;
        }
        while(aceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            aceCounter--;
        }
    }
    return handvalue;
}
public static int Bet(int cash)
{
    Scanner sc=new Scanner(System.in);
    int bet=sc.nextInt();
    while(bet>cash)
    {
        System.out.println("You cannot bet more cash than you have!");
        System.out.println("How much would you like to bet?");
        bet=sc.nextInt();
    }
    return bet;
}
public static void Win()
{
    System.out.println("Congratulations, you win!");
    cash=cash+bet;
    System.out.println("Cash: "+cash);
}
public static void Lose()
{
    System.out.println("Sorry, you lose!");
    cash=cash-bet;
    System.out.println("Cash: "+cash);
}
public static void Push()
{
    System.out.println("It's a push!");
    System.out.println("You get your money back.");
    System.out.println("Cash: "+cash);
}
public static void Hit(Player player, List<Card> hand)
{
    hand.add(player.drawCard());
    Card[] aHand = new Card[]{};
    aHand = hand.toArray(aHand);
    handvalue = 0;
    for(int i=0; i<aHand.length; i++)
    {
        handvalue += aHand[i].getValue();
        if(aHand[i].getValue()==11)
        {
            aceCounter++;
        }
        while(aceCounter>0 && handvalue>21)
        {
            handvalue-=10;
            aceCounter--;
        }
    }
}

public static boolean isHitorStand(String hitter)
{
    if(hitter.equals("hit") || hitter.equals("stand"))
    {
        return true;
    }
    return false;
}
public static boolean bust(int handvalue)
{
    if(handvalue>21)
    {
        System.out.println("You have busted!");
        return true;
    }
    return false;
}
public static boolean isyesorno(String answer)
{
    if(answer.equals("yes") || answer.equals("no"))
    {
        return true;
    }
    return false;
}
public static void fivecardtrick()
{
    System.out.println("You have achieved a five card trick!");
    Win();
}

    }