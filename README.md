# Everyone work in your own repository so we don't overwrite other peoples code (it'll probably happen a few times anyway, git can be confusing) and remember to comment.  

# https://github.com/Kunena/Kunena-Forum/wiki/Create-a-new-branch-with-git-and-manage-branches is a good resource for working with branches.

Create and shuffle a deck of cards
         Create two BlackjackHands, userHand and dealerHand
         Deal two cards into each hand
         if dealer has blackjack
             User loses and the game ends now
         If user has blackjack
             User wins and the game ends now
         Repeat:
             Ask whether user wants to hit or stand
             if user stands:
                 break out of loop
             if user hits:
                 Give user a card
                 if userHand.getBlackjackValue() > 21:
                     User loses and the game ends now
         while  dealerHand.getBlackJackValue() <= 16 :
             Give dealer a card
             if dealerHand.getBlackjackValue() > 21:
                 User wins and game ends now
         if dealerHand.getBlackjackValue() >= userHand.getBlackjackValue()
             User loses
         else
             User wins
