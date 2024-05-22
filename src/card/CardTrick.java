package card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Himanshu Himanshu
 * Student number:991722866
 * 
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rand=new Random();
        String[] suits = new String[4];  
        suits[0] = "Hearts";
        suits[1] = "Diamonds";
        suits[2] = "Clubs";
        suits[3] = "Spades";

        System.out.println("Randomly generated cards in the magic hand:");
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(rand.nextInt(13) + 1);  
            c.setSuit(suits[rand.nextInt(4)]); 
            magicHand[i] = c;
            System.out.println(c.getValue() + " " + c.getSuit());
        }
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the card value (1-13): ");
        int value=in.nextInt();
        in.nextLine();
        
        System.out.println("Enter a suit {Hearts, Diamonds, Clubs, Spades}");
        String usersuit=in.nextLine();
        
        Card userCard=new Card();
        userCard.setValue(value);
        userCard.setSuit(usersuit);
        
        boolean found=false;
        for(Card card : magicHand){
            if(card!= null){
                if(card.getValue()==userCard.getValue() && card.getSuit().equalsIgnoreCase(userCard.getSuit())){
                    found=true;
                    break;
                }
            }
        }
        
        if(found){
            System.out.println("Your card is in the magic hand.");
        }
        else{
            System.out.println("Your card is not in the magic hand.");
        }
    }
}
