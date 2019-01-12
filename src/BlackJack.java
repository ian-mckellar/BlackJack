import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
        Deck testDeck = new Deck();
       //fill and shuffle deck 
       testDeck.fillDeck();
       testDeck.shuffleDeck();
       
       Player player = new Player("Group4");
       Player dealer = new Player("The Dealer");
       
       //give player and dealer 2 cards each
       player.addCardToHand(testDeck.drawCard());
       dealer.addCardToHand(testDeck.drawCard()); 
       player.addCardToHand(testDeck.drawCard());
       dealer.addCardToHand(testDeck.drawCard());
       
       
       //print player hand
       player.cardOutput(true);
       dealer.cardOutput(false);
       
       //when player is done hitting
       boolean playerDone = false;
       boolean dealerDone = false;
       String decision;
       
       
       //main loop of the gaplayer
       while (!playerDone || !dealerDone)
       {
         //player
         if(!playerDone)
         {
         System.out.println("do you want to Hit or Stay? (Enter H or S): ");
         decision = input.next();
         System.out.println();
         
         //if the player choose to hit
            if(decision.compareToIgnoreCase("H") == 0)
            {
            //add a card to player's hand
            playerDone = !player.addCardToHand(testDeck.drawCard());
            player.cardOutput(true);
            }
            else
            {
            playerDone = true;
            }

        }
       
         //dealer
         if(!dealerDone)
         {
            if(dealer.getPlayersHandTotal() < 17)
            {
            //dealer will hit
            System.out.println("Dealer Hits\n");
            dealerDone = !dealer.addCardToHand(testDeck.drawCard());
            dealer.cardOutput(false);
            }
            else
            {
            System.out.println("Dealer Stays");
            dealerDone = true;
            }
         }
        
System.out.println();

        

    }//end of main
    
   input.close();
   //reveal all cards 
   player.cardOutput(true);
   dealer.cardOutput(true);
   
   //calculate and view results
   int playerTotal = player.getPlayersHandTotal();
   int dealerTotal = dealer.getPlayersHandTotal();
   
   if (playerTotal > dealerTotal && playerTotal <= 21 || dealerTotal > 21 )
   { 
      System.out.println("You win!");
   }
   else
   {
   System.out.println("You lose :(");
   }
   
   }
   
}
